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

import org.meerkatlabs.baseballscore.models.*;
import org.meerkatlabs.baseballscore.models.enums.AtBatResult;
import org.meerkatlabs.baseballscore.models.enums.Pitch;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller of a base ball game based on the rules defined in the game type.
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class GameController {

    /**
     * The game that is being controlled by this controller.
     */
    final Game game;

    /**
     * The current half inning for this game.
     */
    HalfInning currentHalfInning;

    /**
     * The collection of innings in this game.
     */
    final List<HalfInning> innings;

    /**
     * The current fielding team.
     */
    Lineup fieldingTeam;

    /**
     * The current batting team.
     */
    Lineup battingTeam;

    /**
     * Determines if the game is complete or not.
     */
    boolean gameComplete = false;

    /**
     * Constructor.
     * @param game game that this controller will be manipulating.
     */
    public GameController(final Game game) {
        this.game = game;

        // Set the initial size of the at bat listing to be the number of innings in a game
        // * the number of outs per inning.
        innings = new ArrayList<HalfInning>(game.getGameType().getRegulationInningCount());
    }

    /**
     * Start a game.  This will go through and verify that the game is correctly configured,
     * and that the lineups are correctly configured.
     */
    public void startGame() {
        // TODO: Go through and make sure that the game is correctly instantiated
        // TODO: Go through and make sure that the lineups are correctly instantiated.
        startNextHalfInning();
    }

    /**
     * Starts the next inning.  If this is the beginning of the game it will create a new half inning
     * and store it off in the list of innings.
     */
    protected void startNextHalfInning() {
        if (currentHalfInning == null) {
            currentHalfInning = new HalfInning();
        } else {
            currentHalfInning = currentHalfInning.getNextHalfInning();
        }

        if (currentHalfInning.getInningNumber() > game.getGameType().getRegulationInningCount()) {
            // The game is over.
            gameComplete = true;
        } else {
            innings.add(currentHalfInning);
        }

        switch (currentHalfInning.getInningHalf()) {
            case TOP:
                fieldingTeam = game.getHomeLineup();
                battingTeam = game.getAwayLineup();
                break;
            case BOTTOM:
                fieldingTeam = game.getAwayLineup();
                battingTeam = game.getHomeLineup();
                break;
        }

        // Configure the at bat for the inning.
        AtBat currentAtBat = new AtBat(fieldingTeam.getActivePitcher(),
                battingTeam.getCurrentBatter());

        currentHalfInning.setCurrentAtBat(currentAtBat);

    }

    /**
     * Throws a pitch to the current at bat.
     * @param pitchType the pitch that is being thrown to the batter by the pitcher.
     */
    public void pitch(final Pitch pitchType) {

        if (gameComplete) {
            throw new IllegalStateException("Cannot pitch in a complete game.");
        }

        AtBat currentAtBat = currentHalfInning.getCurrentAtBat();

        AtBatResult result = AtBatResult.NONE;

        switch (pitchType) {
            case STRIKE:
                result = currentAtBat.throwStrike();
                break;

            case BALL:
                result = currentAtBat.throwBall();
                break;

            default:

        }

        processResult(result);

    }

    /**
     * Provides a result for the current at bat instead of a default pitch.
     * @param result result that should be used to manipulate the game.
     */
    public void pitch(final AtBatResult result) {
        if (gameComplete) {
            throw new IllegalStateException("Cannot pitch in a complete game.");
        }
    }

    /**
     * Process the results of an at bat.
     * @param result result that should be processed.
     */
    protected void processResult(final AtBatResult result) {

        // If the result is an out and the results should no longer be processed, move on.
        if (result.isOut() && !increaseOuts()) {
            return;
        }

        // If the result advances the lineup, then move on to the next at bat.
        if (result.advanceLineup()) {
            battingTeam.advanceLineup();
            AtBat currentAtBat = new AtBat(fieldingTeam.getActivePitcher(),
                    battingTeam.getCurrentBatter());

            currentHalfInning.setCurrentAtBat(currentAtBat);
        }

    }

    /**
     * Add an out to the current half inning.
     * @return returns if the results should still be processed.  If the inning is over,
     * then the results should no longer be processed by this controller.
     */
    protected boolean increaseOuts() {
        int outs = currentHalfInning.getCurrentOuts() + 1;
        currentHalfInning.setCurrentOuts(outs);

        if (outs == game.getGameType().getOutsPerHalfInning()) {
            startNextHalfInning();
            return false;
        }

        return true;
    }

}
