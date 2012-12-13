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

import org.meerkatlabs.baseballscore.models.interfaces.IInPlayDescription;

/**
 * Collection of enumerations that will describe how a ball was placed into play.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public enum InPlay implements IInPlayDescription {

    /**
     * The result is that the batter hit a single.
     */
    SINGLE,

    /**
     * The result is that the batter hit a double.
     */
    DOUBLE,

    /**
     * The result is that the batter hit a triple.
     */
    TRIPLE,

    /**
     * The result is that the batter hit a home run.
     */
    HOME_RUN,

    /**
     * The result is that the batter walked.
     */
    BASE_ON_BALLS,

    /**
     * The result is that the batter hit a foul out of play.
     */
    FOUL,

    /**
     * This at bat was not in play.
     */
    NONE;

    @Override
    public boolean isOut() {
        return false;
    }

    @Override
    public boolean advanceLineup() {
        switch (this) {
            case FOUL:
            case NONE:
                return false;

            default:
                return true;
        }

    }

    /**
     * How does the in play description translate into the bast the the batter ends up on.
     *
     * @return the base value that the batter should end up on.
     */
    public Base baseValue() {
        Base returnValue;

        switch (this) {
            case BASE_ON_BALLS:
            case SINGLE:
                returnValue = Base.FIRST_BASE;
                break;

            case DOUBLE:
                returnValue = Base.SECOND_BASE;
                break;

            case TRIPLE:
                returnValue = Base.THIRD_BASE;
                break;

            case HOME_RUN:
                returnValue = Base.HOME_PLATE;
                break;

            case FOUL:
            case NONE:
            default:
                returnValue = Base.NONE;
        }

        return returnValue;
    }

}
