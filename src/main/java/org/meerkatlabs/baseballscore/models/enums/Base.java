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
 * List of enumerations that are used to look up the base runners on each of the bases.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public enum Base {

    /**
     * Used to look up the base runner on first base.
     */
    FIRST_BASE,

    /**
     * Used to look up the base runner on second base.
     */
    SECOND_BASE,

    /**
     * Used to look up the base runner on third base.
     */
    THIRD_BASE,

    /**
     * Used to look up the base runner that is on home plate.
     */
    HOME_PLATE,

    /**
     * Used to count the number of bases.
     */
    NONE;

    /**
     * Returns the next base that this base should point to.
     *
     * @return next base after this value.
     */
    public Base getNextBase() {
        Base returnValue;

        switch (this) {
            case FIRST_BASE:
                returnValue = SECOND_BASE;
                break;

            case SECOND_BASE:
                returnValue = THIRD_BASE;
                break;

            case THIRD_BASE:
                returnValue = HOME_PLATE;
                break;

            case NONE:
            case HOME_PLATE:
            default:
                returnValue = NONE;
        }

        return returnValue;
    }

}
