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
 * Data structure that maintains the data created by a fly ball being caught by a player.  MLB rules state that the
 * batter is not a runner until the ball hits the ground.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class FlyOut extends AbstractOut implements IOut, IBatterResult {

    /**
     * The player that is credited with catching the fly ball.
     */
    private final Player credited;

    /**
     * Credited player constructor.
     *
     * @param credited credited player.
     */
    public FlyOut(final Player credited) {
        this.credited = credited;
    }

    /**
     * Credited player accessor.
     *
     * @return credited player.
     */
    public Player getCredited() {
        return credited;
    }

    @Override
    public void process(final AtBat currentAtBat, final HalfInning currentHalfInning) {
        processAtBatOut(currentHalfInning);
    }
}
