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
import org.meerkatlabs.baseballscore.interfaces.IOut;
import org.meerkatlabs.baseballscore.models.AtBat;
import org.meerkatlabs.baseballscore.models.HalfInning;
import org.meerkatlabs.baseballscore.models.Player;
import org.meerkatlabs.baseballscore.results.AbstractOut;

/**
 * Data object that represents a strike out.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class StrikeOut extends AbstractOut implements IOut, IBatterResult {

    /**
     * The player that gets credit for the strike out.
     */
    final Player pitcher;

    /**
     * Constructor.
     *
     * @param pitcher the pitcher that threw the strike out.
     */
    public StrikeOut(final Player pitcher) {
        this.pitcher = pitcher;
    }

    /**
     * Pitcher accessor.
     *
     * @return pitcher that is credited with the strike out.
     */
    public Player getPitcher() {
        return pitcher;
    }

    @Override
    public void process(final AtBat currentAtBat, final HalfInning currentHalfInning) {
        processAtBatOut(currentHalfInning);
    }

}
