package org.meerkatlabs.baseballscore.models;

import junit.framework.TestCase;
import org.meerkatlabs.baseballscore.models.enums.AtBatResult;

/**
 * Created with IntelliJ IDEA.
 * User: rerobins
 * Date: 12/9/12
 * Time: 9:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class AtBatTestCase extends TestCase {

    public void testAtBatThrowStrikes() {
        Player goodPitcher = new Player(1, "Pitcher");
        Player badBatter = new Player(2, "Batter");

        AtBat currentAtBat = new AtBat(goodPitcher, badBatter);

        assertEquals("Verify initial strike count",
                0, currentAtBat.getStrikes());
        assertEquals("Verify initial ball count",
                0, currentAtBat.getBalls());
        assertEquals("Verify initial foul count",
                0, currentAtBat.getFouls());

        AtBatResult result = currentAtBat.throwStrike();

        assertEquals("Verify that strike 1 result is none",
                result, AtBatResult.NONE);
        assertEquals("Verify that strikes is 1",
                1, currentAtBat.getStrikes());
        assertEquals("Verify that balls is 0 after one strike",
                0, currentAtBat.getBalls());
        assertEquals("Verify that the fouls is 0 after one strike",
                0, currentAtBat.getFouls());

        result = currentAtBat.throwStrike();
        assertEquals(result, AtBatResult.NONE);
        assertEquals(2, currentAtBat.getStrikes());
        assertEquals(0, currentAtBat.getBalls());
        assertEquals(0, currentAtBat.getFouls());

        result = currentAtBat.throwStrike();
        assertEquals(result, AtBatResult.STRIKE_OUT);
        assertEquals(3, currentAtBat.getStrikes());
        assertEquals(0, currentAtBat.getBalls());
        assertEquals(0, currentAtBat.getFouls());

    }

    public void testAtBatThrowBalls() {
        Player lousyPitcher = new Player(1, "Pitcher");
        Player goodEye = new Player(2, "Batter");

        AtBat currentAtBat = new AtBat(lousyPitcher, goodEye);

        assertEquals("Verify initial strike count",
                0, currentAtBat.getStrikes());
        assertEquals("Verify initial ball count",
                0, currentAtBat.getBalls());
        assertEquals("Verify initial foul count",
                0, currentAtBat.getFouls());

        AtBatResult result = currentAtBat.throwBall();

        assertEquals("Verify that ball 1 result is none",
                result, AtBatResult.NONE);
        assertEquals("Verify that strikes is 0 after one ball",
                0, currentAtBat.getStrikes());
        assertEquals("Verify that balls is 1 after one ball",
                1, currentAtBat.getBalls());
        assertEquals("Verify that the fouls is 0 after one ball",
                0, currentAtBat.getFouls());

        result = currentAtBat.throwBall();
        assertEquals("Verify that ball 1 result is none",
                result, AtBatResult.NONE);
        assertEquals("Verify that strikes is 0 after two balls",
                0, currentAtBat.getStrikes());
        assertEquals("Verify that balls is 2 after two balls",
                2, currentAtBat.getBalls());
        assertEquals("Verify that the fouls is 0 after two balls",
                0, currentAtBat.getFouls());

        result = currentAtBat.throwBall();
        assertEquals("Verify that ball 1 result is none",
                result, AtBatResult.NONE);
        assertEquals("Verify that strikes is 0 after three balls",
                0, currentAtBat.getStrikes());
        assertEquals("Verify that balls is 3 after three balls",
                3, currentAtBat.getBalls());
        assertEquals("Verify that the fouls is 0 after three balls",
                0, currentAtBat.getFouls());

        result = currentAtBat.throwBall();
        assertEquals("Verify that ball 4 result is base on balls",
                result, AtBatResult.BASE_ON_BALLS);
        assertEquals("Verify that strikes is 0 after four balls",
                0, currentAtBat.getStrikes());
        assertEquals("Verify that balls is 4 after four balls",
                4, currentAtBat.getBalls());
        assertEquals("Verify that the fouls is 0 after four balls",
                0, currentAtBat.getFouls());
    }

}
