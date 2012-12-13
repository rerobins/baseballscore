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

package org.meerkatlabs.baseballscore.events.runner;

import org.meerkatlabs.baseballscore.interfaces.IRunnerEvent;
import org.meerkatlabs.baseballscore.models.enums.Base;

/**
 * Data object that describes a runner stealing a base.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class StolenBase implements IRunnerEvent {

    /**
     * Base stolen.
     */
    final Base baseStolen;

    /**
     * Constructor.
     *
     * @param baseStolen base stolen.
     */
    public StolenBase(final Base baseStolen) {
        this.baseStolen = baseStolen;
    }

    /**
     * Base stolen accessor.
     *
     * @return base stolen.
     */
    public Base getBaseStolen() {
        return baseStolen;
    }

}
