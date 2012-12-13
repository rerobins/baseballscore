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

import org.meerkatlabs.baseballscore.models.enums.Base;

/**
 * A runner result that describes a runner that was left on base when the half inning was over.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class LeftOnBase {

    /**
     * The base that the runner was left on.
     */
    final Base baseLeftOn;

    /**
     * Constructor.
     *
     * @param baseLeftOn base that the runner was left on.
     */
    public LeftOnBase(final Base baseLeftOn) {
        this.baseLeftOn = baseLeftOn;
    }

    /**
     * Base left on accessor.
     *
     * @return base left on.
     */
    public Base getBaseLeftOn() {
        return baseLeftOn;
    }

}
