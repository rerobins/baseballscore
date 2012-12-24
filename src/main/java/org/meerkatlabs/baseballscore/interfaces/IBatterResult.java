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

package org.meerkatlabs.baseballscore.interfaces;

import org.meerkatlabs.baseballscore.models.AtBat;
import org.meerkatlabs.baseballscore.models.HalfInning;

/**
 * Result type that will be used after a batter event has finished.
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public interface IBatterResult {

    /**
     * Process this set of results by taking into consideration the current at bat and the
     * current half inning that is being worked on.
     * @param currentAtBat the at bat that caused the results.
     * @param currentHalfInning the half inning that should be queried and or modified.
     */
    void process(AtBat currentAtBat, HalfInning currentHalfInning);

}
