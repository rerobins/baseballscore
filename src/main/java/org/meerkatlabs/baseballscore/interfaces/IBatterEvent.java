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

/**
 * Interface for at bat events.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public interface IBatterEvent {

    /**
     * Have the event process the at bat for itself.
     * @param atBat the at bat that this event should be manipulating.
     * @return the result of processing the event.
     */
    IBatterResult process(AtBat atBat);

}
