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
import org.meerkatlabs.baseballscore.models.enums.Base;

/**
 * Test case for the field object.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class FieldTestCase extends TestCase {

    public void testAdvanceAllBases() {
        Field gameField = new Field();

        Player lousyPitcher = new Player(1, "Lousy");
        Player thirdBaseRunner = new Player(3, "Third");
        Player secondBaseRunner = new Player(2, "Second");
        Player firstBaseRunner = new Player(1, "First");
        Player batter = new Player(0, "Batter");

        Runner thirdBase = new Runner(new AtBat(lousyPitcher, thirdBaseRunner));
        Runner secondBase = new Runner(new AtBat(lousyPitcher, secondBaseRunner));
        Runner firstBase = new Runner(new AtBat(lousyPitcher, firstBaseRunner));
        Runner newRunner = new Runner(new AtBat(lousyPitcher, batter));

        gameField.baseRunners[Base.THIRD_BASE.ordinal()] = thirdBase;
        gameField.baseRunners[Base.SECOND_BASE.ordinal()] = secondBase;
        gameField.baseRunners[Base.FIRST_BASE.ordinal()] = firstBase;

        gameField.advanceRunners(Base.FIRST_BASE, newRunner);

        assertSame("Check third runner on home",
                thirdBase, gameField.baseRunners[Base.HOME_PLATE.ordinal()]);
        assertSame("Check second runner on third",
                secondBase, gameField.baseRunners[Base.THIRD_BASE.ordinal()]);
        assertSame("Check first runner on second",
                firstBase, gameField.baseRunners[Base.SECOND_BASE.ordinal()]);
        assertSame("Check new runner on first",
                newRunner, gameField.baseRunners[Base.FIRST_BASE.ordinal()]);

    }

}
