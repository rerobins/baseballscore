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

package org.meerkatlabs.baseballscore.models;

import junit.framework.TestCase;
import org.meerkatlabs.baseballscore.models.enums.AtBatResult;
import org.meerkatlabs.baseballscore.models.enums.InPlay;
import org.meerkatlabs.baseballscore.models.interfaces.IInPlayDescription;

/**
 * Test Case for At Bats.
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

        IInPlayDescription result = currentAtBat.throwStrike();

        assertEquals("Verify that strike 1 result is none",
                result, InPlay.NONE);
        assertEquals("Verify that strikes is 1",
                1, currentAtBat.getStrikes());
        assertEquals("Verify that balls is 0 after one strike",
                0, currentAtBat.getBalls());
        assertEquals("Verify that the fouls is 0 after one strike",
                0, currentAtBat.getFouls());

        result = currentAtBat.throwStrike();
        assertEquals(result, InPlay.NONE);
        assertEquals(2, currentAtBat.getStrikes());
        assertEquals(0, currentAtBat.getBalls());
        assertEquals(0, currentAtBat.getFouls());

        result = currentAtBat.throwStrike();
        assertEquals(new AtBatResultInPlayWrapper(AtBatResult.STRIKE_OUT), result);
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

        IInPlayDescription result = currentAtBat.throwBall();

        assertEquals("Verify that ball 1 result is none",
                result, InPlay.NONE);
        assertEquals("Verify that strikes is 0 after one ball",
                0, currentAtBat.getStrikes());
        assertEquals("Verify that balls is 1 after one ball",
                1, currentAtBat.getBalls());
        assertEquals("Verify that the fouls is 0 after one ball",
                0, currentAtBat.getFouls());

        result = currentAtBat.throwBall();
        assertEquals("Verify that ball 1 result is none",
                result, InPlay.NONE);
        assertEquals("Verify that strikes is 0 after two balls",
                0, currentAtBat.getStrikes());
        assertEquals("Verify that balls is 2 after two balls",
                2, currentAtBat.getBalls());
        assertEquals("Verify that the fouls is 0 after two balls",
                0, currentAtBat.getFouls());

        result = currentAtBat.throwBall();
        assertEquals("Verify that ball 1 result is none",
                result, InPlay.NONE);
        assertEquals("Verify that strikes is 0 after three balls",
                0, currentAtBat.getStrikes());
        assertEquals("Verify that balls is 3 after three balls",
                3, currentAtBat.getBalls());
        assertEquals("Verify that the fouls is 0 after three balls",
                0, currentAtBat.getFouls());

        result = currentAtBat.throwBall();
        assertEquals("Verify that ball 4 result is base on balls",
                result, InPlay.BASE_ON_BALLS);
        assertEquals("Verify that strikes is 0 after four balls",
                0, currentAtBat.getStrikes());
        assertEquals("Verify that balls is 4 after four balls",
                4, currentAtBat.getBalls());
        assertEquals("Verify that the fouls is 0 after four balls",
                0, currentAtBat.getFouls());
    }

    public void testAtBatThrowFouls() {
        Player goodPitcher = new Player(1, "Pitcher");
        Player badBatter = new Player(2, "Batter");

        AtBat currentAtBat = new AtBat(goodPitcher, badBatter);

        assertEquals("Verify initial strike count",
                0, currentAtBat.getStrikes());
        assertEquals("Verify initial ball count",
                0, currentAtBat.getBalls());
        assertEquals("Verify initial foul count",
                0, currentAtBat.getFouls());

        IInPlayDescription result = currentAtBat.hitFoul();

        assertEquals("Verify that strike 1 result is none",
                result, InPlay.NONE);
        assertEquals("Verify that strikes is 1",
                1, currentAtBat.getStrikes());
        assertEquals("Verify that balls is 0 after one strike",
                0, currentAtBat.getBalls());
        assertEquals("Verify that the fouls is 1 after one strike",
                1, currentAtBat.getFouls());

        result = currentAtBat.hitFoul();
        assertEquals(result, InPlay.NONE);
        assertEquals(2, currentAtBat.getStrikes());
        assertEquals(0, currentAtBat.getBalls());
        assertEquals(2, currentAtBat.getFouls());

        result = currentAtBat.hitFoul();
        assertEquals(result, InPlay.NONE);
        assertEquals(2, currentAtBat.getStrikes());
        assertEquals(0, currentAtBat.getBalls());
        assertEquals(3, currentAtBat.getFouls());

        result = currentAtBat.hitFoul();
        assertEquals(result, InPlay.NONE);
        assertEquals(2, currentAtBat.getStrikes());
        assertEquals(0, currentAtBat.getBalls());
        assertEquals(4, currentAtBat.getFouls());

        result = currentAtBat.hitFoul();
        assertEquals(result, InPlay.NONE);
        assertEquals(2, currentAtBat.getStrikes());
        assertEquals(0, currentAtBat.getBalls());
        assertEquals(5, currentAtBat.getFouls());
    }

}
