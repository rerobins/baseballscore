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
import org.meerkatlabs.baseballscore.models.enums.NineBallBaseballPosition;

/**
 * Created with IntelliJ IDEA.
 * User: rerobins
 * Date: 12/10/12
 * Time: 7:03 PM
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class LineupTestCase extends TestCase {

    public void testAdvanceLineup() {

        Player[] players = new Player[]{

                new Player(1, "Rockies 1", NineBallBaseballPosition.PITCHER),
                new Player(2, "Rockies 2", NineBallBaseballPosition.CATCHER),
                new Player(3, "Rockies 3", NineBallBaseballPosition.FIRST_BASE),
                new Player(4, "Rockies 4", NineBallBaseballPosition.SECOND_BASE),
                new Player(5, "Rockies 5", NineBallBaseballPosition.THIRD_BASE),
                new Player(6, "Rockies 6", NineBallBaseballPosition.SHORT_STOP),
                new Player(7, "Rockies 7", NineBallBaseballPosition.LEFT_FIELD),
                new Player(8, "Rockies 8", NineBallBaseballPosition.CENTER_FIELD),
                new Player(9, "Rockies 9", NineBallBaseballPosition.RIGHT_FIELD),
        };

        Lineup lineup = new Lineup(BaseballGameType.INSTANCE);

        for (int i = 0; i < NineBallBaseballPosition.values().length; ++i) {
            lineup.setBatter(i, players[i], NineBallBaseballPosition.values()[i]);
        }

        for (int i = 0; i < NineBallBaseballPosition.values().length - 1; ++i) {
            assertSame(players[i], lineup.getCurrentBatter());
            assertSame(players[i + 1], lineup.getNextBatter());
            lineup.advanceLineup();
        }

        // Should now be on the 9th batter.
        assertSame(players[8], lineup.getCurrentBatter());
        assertSame(players[0], lineup.getNextBatter());

        // Now should wrap around to the first batter.
        lineup.advanceLineup();

        assertSame(players[0], lineup.getCurrentBatter());
        assertSame(players[1], lineup.getNextBatter());

    }

}
