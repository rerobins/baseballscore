/*
 * This file is part of BaseballScore.
 *
 * BaseballScore is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BaseballScore is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with BaseballScore.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.meerkatlabs.baseballscore.controller;

import junit.framework.TestCase;
import org.meerkatlabs.baseballscore.models.AtBat;
import org.meerkatlabs.baseballscore.models.Game;
import org.meerkatlabs.baseballscore.models.HalfInning;
import org.meerkatlabs.baseballscore.models.enums.AtBatResult;
import org.meerkatlabs.baseballscore.models.enums.Base;
import org.meerkatlabs.baseballscore.models.enums.InPlay;
import org.meerkatlabs.baseballscore.models.enums.Pitch;
import org.meerkatlabs.baseballscore.util.BuildGame;

/**
 * Want this test case to be as if a game was actually being played between these two
 * teams to make sure that the game controller is able to handle the information
 * and make the correct state changes as the game is played.
 * <p/>
 * Will want to be able to have multiple versions of these tests.
 */
public class GameControllerTestCase extends TestCase {

    public GameControllerTestCase() {
    }

    /**
     * Test when starting a game the the current inning information is defined when startGame
     * is called.
     */
    public void testStartGame() {

        Game game = BuildGame.INSTANCE.buildBasicGame();

        GameController gameController = new GameController(game);

        gameController.startGame();

        assertSame("Game is the same", gameController.game, game);

        assertEquals("Current Half Inning is Top...",
                gameController.currentHalfInning.getInningHalf(), HalfInning.Half.TOP);
        assertEquals("Of the first", gameController.currentHalfInning.getInningNumber(), 1);

        assertTrue(!gameController.innings.isEmpty());
        assertSame(gameController.innings.get(0), gameController.currentHalfInning);

        assertNotNull(gameController.currentHalfInning.getCurrentAtBat());

        assertSame(gameController.currentHalfInning.getCurrentAtBat().getPitcher(),
                game.getHomeLineup().getActivePitcher());
        assertSame(gameController.currentHalfInning.getCurrentAtBat().getBatter(),
                game.getAwayLineup().getCurrentBatter());

        // Make sure that the at bat has been added to the half inning
        assertTrue(!gameController.currentHalfInning.getAtBats().isEmpty());
        assertSame(gameController.currentHalfInning.getCurrentAtBat(),
                gameController.currentHalfInning.getAtBats().get(0));

    }

    public void testThrowingThreeStrikes() {
        Game game = BuildGame.INSTANCE.buildBasicGame();
        GameController controller = new GameController(game);

        controller.startGame();

        AtBat firstAtBat = controller.currentHalfInning.getCurrentAtBat();

        assertEquals("Make sure that the game controller starts at 0 outs.",
                0, controller.currentHalfInning.getCurrentOuts());

        // Throw a strike, make sure that the strike increased, and that the current
        // at bat didn't change.
        controller.pitch(Pitch.STRIKE);
        assertSame("Validate still on same batter",
                firstAtBat, controller.currentHalfInning.getCurrentAtBat());
        assertEquals("Validate Strike one",
                1, controller.currentHalfInning.getCurrentAtBat().getStrikes());
        assertEquals("Make sure that the game controller is still at 0 outs. Strike 1",
                0, controller.currentHalfInning.getCurrentOuts());

        controller.pitch(Pitch.STRIKE);
        assertSame("validate still on same batter strike 2",
                firstAtBat, controller.currentHalfInning.getCurrentAtBat());
        assertEquals("validate strike two",
                2, controller.currentHalfInning.getCurrentAtBat().getStrikes());
        assertEquals("Make sure that the game controller is still at 0 outs. Strike 2",
                0, controller.currentHalfInning.getCurrentOuts());

        controller.pitch(Pitch.STRIKE);

        // At this point the number of outs should be 1, and the next at bat should
        // be different then the one that was getting thrown to.
        assertNotSame("Validate move at bat forward",
                firstAtBat, controller.currentHalfInning.getCurrentAtBat());
        assertEquals("Validate one out",
                1, controller.currentHalfInning.getCurrentOuts());

        // Make sure that the new batter is the second batter in the line up
        AtBat secondAtBat = controller.currentHalfInning.getCurrentAtBat();
        assertSame("Validate pitcher correct in next at bat",
                game.getHomeLineup().getActivePitcher(), secondAtBat.getPitcher());
        assertSame("Validate that batter is the same as current batter in lineup",
                game.getAwayLineup().getCurrentBatter(), secondAtBat.getBatter());
        assertSame("Validate that the batter is the second batter on the lineup",
                game.getAwayLineup().getPlayerAtIndex(1), secondAtBat.getBatter());
    }

    public void testThrowingFourBalls() {
        Game game = BuildGame.INSTANCE.buildBasicGame();
        GameController controller = new GameController(game);

        controller.startGame();

        AtBat firstAtBat = controller.currentHalfInning.getCurrentAtBat();

        // Throw a ball and make sure that the ball increased, and that the current at
        // bat didn't change.
        controller.pitch(Pitch.BALL);
        assertEquals("Get Balls is 1",
                1, controller.currentHalfInning.getCurrentAtBat().getBalls());
        assertSame(firstAtBat, controller.currentHalfInning.getCurrentAtBat());

        // Throw the rest of the balls to see if the batter walks.
        controller.pitch(Pitch.BALL);
        assertEquals("Get Balls is 2",
                2, controller.currentHalfInning.getCurrentAtBat().getBalls());
        assertSame(firstAtBat, controller.currentHalfInning.getCurrentAtBat());

        controller.pitch(Pitch.BALL);
        assertSame(firstAtBat, controller.currentHalfInning.getCurrentAtBat());
        assertEquals("Get Balls is 3",
                3, controller.currentHalfInning.getCurrentAtBat().getBalls());

        controller.pitch(Pitch.BALL);

        // At this point the number of outs should still be 0.
        // and the current at bat should be different than the first one.
        // And the batter should be on first base.
        AtBat secondAtBat = controller.currentHalfInning.getCurrentAtBat();
        assertNotSame(firstAtBat, secondAtBat);
        assertTrue(controller.currentHalfInning.getCurrentOuts() == 0);

        // Make sure that the new batter is the second batter in the line up
        assertSame(game.getHomeLineup().getActivePitcher(), secondAtBat.getPitcher());
        assertSame(game.getAwayLineup().getCurrentBatter(), secondAtBat.getBatter());
        assertSame(game.getAwayLineup().getPlayerAtIndex(1), secondAtBat.getBatter());

        // Make sure that the batter is now on first base.
        assertSame(firstAtBat, controller.currentField.getBaseRunner(Base.FIRST_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.SECOND_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.THIRD_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.HOME_PLATE));
    }

    public void testThrowingFiveFouls() {
        Game game = BuildGame.INSTANCE.buildBasicGame();
        GameController controller = new GameController(game);

        controller.startGame();

        AtBat firstAtBat = controller.currentHalfInning.getCurrentAtBat();

        assertEquals("Make sure that the game controller starts at 0 outs.",
                0, controller.currentHalfInning.getCurrentOuts());

        controller.inPlay(InPlay.FOUL);
        assertEquals("Validate Strike one",
                1, controller.currentHalfInning.getCurrentAtBat().getStrikes());
        assertSame("Validate still on same batter",
                firstAtBat, controller.currentHalfInning.getCurrentAtBat());
        assertEquals("Make sure that the game controller is still at 0 outs. Strike 1",
                0, controller.currentHalfInning.getCurrentOuts());
        assertEquals("Validate Foul one",
                1, controller.currentHalfInning.getCurrentAtBat().getFouls());

    }

    public void testWalkTheBases() {
        Game game = BuildGame.INSTANCE.buildBasicGame();
        GameController controller = new GameController(game);

        controller.startGame();

        AtBat firstAtBat = controller.currentHalfInning.getCurrentAtBat();

        // Throw a ball and make sure that the ball increased, and that the current at
        // bat didn't change.
        controller.pitch(Pitch.BALL);
        controller.pitch(Pitch.BALL);
        controller.pitch(Pitch.BALL);
        controller.pitch(Pitch.BALL);

        // Make sure that the batter is now on first base.
        assertSame(firstAtBat, controller.currentField.getBaseRunner(Base.FIRST_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.SECOND_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.THIRD_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.HOME_PLATE));

        // At this point the number of outs should still be 0.
        // and the current at bat should be different than the first one.
        // And the batter should be on first base.
        AtBat secondAtBat = controller.currentHalfInning.getCurrentAtBat();
        controller.pitch(Pitch.BALL);
        controller.pitch(Pitch.BALL);
        controller.pitch(Pitch.BALL);
        controller.pitch(Pitch.BALL);

        assertSame(secondAtBat, controller.currentField.getBaseRunner(Base.FIRST_BASE));
        assertSame(firstAtBat, controller.currentField.getBaseRunner(Base.SECOND_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.THIRD_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.HOME_PLATE));

        AtBat thirdAtBat = controller.currentHalfInning.getCurrentAtBat();
        controller.pitch(Pitch.BALL);
        controller.pitch(Pitch.BALL);
        controller.pitch(Pitch.BALL);
        controller.pitch(Pitch.BALL);

        assertSame(thirdAtBat, controller.currentField.getBaseRunner(Base.FIRST_BASE));
        assertSame(secondAtBat, controller.currentField.getBaseRunner(Base.SECOND_BASE));
        assertSame(firstAtBat, controller.currentField.getBaseRunner(Base.THIRD_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.HOME_PLATE));

        AtBat fourthAtBat = controller.currentHalfInning.getCurrentAtBat();
        controller.pitch(Pitch.BALL);
        controller.pitch(Pitch.BALL);
        controller.pitch(Pitch.BALL);
        controller.pitch(Pitch.BALL);

        assertSame(fourthAtBat, controller.currentField.getBaseRunner(Base.FIRST_BASE));
        assertSame(thirdAtBat, controller.currentField.getBaseRunner(Base.SECOND_BASE));
        assertSame(secondAtBat, controller.currentField.getBaseRunner(Base.THIRD_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.HOME_PLATE));

        // Make sure that the person on home plate is marked as having scored.
        assertEquals(AtBatResult.SCORED, firstAtBat.getResult());

        assertNotSame(firstAtBat, secondAtBat);
        assertNotSame(secondAtBat, thirdAtBat);
        assertNotSame(thirdAtBat, fourthAtBat);

    }

    public void testBaseHitting() {
        Game game = BuildGame.INSTANCE.buildBasicGame();
        GameController controller = new GameController(game);

        controller.startGame();

        AtBat firstBatter = controller.currentHalfInning.getCurrentAtBat();

        controller.inPlay(InPlay.SINGLE);

        assertSame(firstBatter, controller.currentField.getBaseRunner(Base.FIRST_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.SECOND_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.THIRD_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.HOME_PLATE));

        AtBat secondBatter = controller.currentHalfInning.getCurrentAtBat();
        assertNotSame(firstBatter, secondBatter);

        controller.inPlay(InPlay.SINGLE);

        assertSame(secondBatter, controller.currentField.getBaseRunner(Base.FIRST_BASE));
        assertSame(firstBatter, controller.currentField.getBaseRunner(Base.SECOND_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.THIRD_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.HOME_PLATE));

        AtBat thirdBatter = controller.currentHalfInning.getCurrentAtBat();
        assertNotSame(secondBatter, thirdBatter);
        controller.inPlay(InPlay.SINGLE);

        assertSame(thirdBatter, controller.currentField.getBaseRunner(Base.FIRST_BASE));
        assertSame(secondBatter, controller.currentField.getBaseRunner(Base.SECOND_BASE));
        assertSame(firstBatter, controller.currentField.getBaseRunner(Base.THIRD_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.HOME_PLATE));

        AtBat fourthBatter = controller.currentHalfInning.getCurrentAtBat();
        assertNotSame(thirdBatter, fourthBatter);
        controller.inPlay(InPlay.SINGLE);

        assertSame(fourthBatter, controller.currentField.getBaseRunner(Base.FIRST_BASE));
        assertSame(thirdBatter, controller.currentField.getBaseRunner(Base.SECOND_BASE));
        assertSame(secondBatter, controller.currentField.getBaseRunner(Base.THIRD_BASE));
        assertNull(controller.currentField.getBaseRunner(Base.HOME_PLATE));

        assertEquals(AtBatResult.SCORED, firstBatter.getResult());
    }

}
