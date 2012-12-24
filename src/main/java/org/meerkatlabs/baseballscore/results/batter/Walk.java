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

package org.meerkatlabs.baseballscore.results.batter;

import org.meerkatlabs.baseballscore.interfaces.IBatterResult;
import org.meerkatlabs.baseballscore.models.AtBat;
import org.meerkatlabs.baseballscore.models.HalfInning;
import org.meerkatlabs.baseballscore.models.Player;

/**
 * Data container for a walk.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class Walk implements IBatterResult {

    /**
     * The player that gets credit for the walk.
     */
    final Player pitcher;

    /**
     * Constructor.
     *
     * @param pitcher the pitcher that threw the walk.
     */
    public Walk(final Player pitcher) {
        this.pitcher = pitcher;
    }

    /**
     * Pitcher accessor.
     *
     * @return pitcher that is credited with the walk.
     */
    public Player getPitcher() {
        return pitcher;
    }

    @Override
    public void process(final AtBat currentAtBat, final HalfInning currentHalfInning) {
        currentHalfInning.getCurrentField().walkRunner(currentAtBat);

        currentHalfInning.getBattingTeam().advanceLineup();

        AtBat nextAtBat = new AtBat(currentHalfInning.getFieldingTeam().getActivePitcher(),
                currentHalfInning.getBattingTeam().getCurrentBatter());

        currentHalfInning.setCurrentAtBat(nextAtBat);
    }
}
