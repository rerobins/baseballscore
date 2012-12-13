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

package org.meerkatlabs.baseballscore.results.runner;

import org.meerkatlabs.baseballscore.models.IPosition;
import org.meerkatlabs.baseballscore.results.AbstractOut;

import java.util.Arrays;

/**
 * An out that is caused while the player is advancing after a ball has been hit into play.  This is not only for runners
 * that were already on the field when the ball was hit, but also for the runner that is advancing to first.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class WhileAdvancingOut extends AbstractOut {

    /**
     * The players that were participating to get the out.
     */
    private final IPosition[] players;

    /**
     * Constructor.
     *
     * @param players players participating to get the out.
     */
    public WhileAdvancingOut(final IPosition[] players) {
        this.players = Arrays.copyOf(players, players.length);
    }

    /**
     * Players accessor.
     *
     * @return participating players.
     */
    public IPosition[] getPlayers() {
        return players;
    }

}
