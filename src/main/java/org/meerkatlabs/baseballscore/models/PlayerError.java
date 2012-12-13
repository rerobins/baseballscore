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

/**
 * Data incapsulating an error.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class PlayerError {

    /**
     * The position that caused the error.
     */
    IPosition playerPosition;

    /**
     * Constructor.
     *
     * @param playerPosition position that caused the error.
     */
    public PlayerError(final IPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    /**
     * Player position.
     *
     * @return position.
     */
    public IPosition getPlayerPosition() {
        return playerPosition;
    }

}
