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

package org.meerkatlabs.baseballscore.models.enums;

/**
 * A collection of results that can be marked as the reason why an at bat has ended.  An at bat has ended when the
 * player is out, a player has scored, or the player is left on base because the inning is over.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public enum AtBatResult {

    /**
     * The result is that the batter struck out.
     */
    STRIKE_OUT,

    /**
     * The result is that the batter flew out.
     */
    FLY_OUT,

    /**
     * The result is that the batter grounded out.
     */
    GROUND_OUT,

    /**
     * The result is that the batter was left on base.
     */
    LEFT_ON_BASE,

    /**
     * The result is that the batter scored before the inning was over.
     */
    SCORED,

    /**
     * The result doesn't impact the state of the game, only the at bat.
     */
    NONE;

    /**
     * Is the batter out because of the at bat.
     *
     * @return if the batter is out.
     */
    public boolean isOut() {
        switch (this) {
            case STRIKE_OUT:
            case FLY_OUT:
            case GROUND_OUT:
                return true;

            case LEFT_ON_BASE:
            case SCORED:
            case NONE:
            default:
                return false;
        }
    }

    /**
     * Does the result of the at bat advance the line up.
     *
     * @return if the at bat should progress the game forward.
     */
    public boolean advanceLineup() {
        switch (this) {
            case NONE:
                return false;

            case STRIKE_OUT:
            case FLY_OUT:
            case GROUND_OUT:
            case SCORED:
            default:
                return true;
        }
    }
}
