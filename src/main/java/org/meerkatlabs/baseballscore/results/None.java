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

package org.meerkatlabs.baseballscore.results;

import org.meerkatlabs.baseballscore.interfaces.IBatterResult;
import org.meerkatlabs.baseballscore.interfaces.IRunnerResult;
import org.meerkatlabs.baseballscore.models.AtBat;
import org.meerkatlabs.baseballscore.models.HalfInning;

/**
 * A syntactically null result for the a result.
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class None implements IBatterResult, IRunnerResult {

    @Override
    public void process(final AtBat currentAtBat, final HalfInning currentHalfInning) {
        // Don't have to do anything because nothing has happened.
    }

    @Override
    public void process(final HalfInning currentHalfInning) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
