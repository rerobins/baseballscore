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
 * A runner event that cause a runner to advance to a new base because of another runner event forced it.  This
 * will also allow for a batter to go from first to third on another batter's single hit.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class Advancement implements IRunnerEvent {

    /**
     * The event that caused this player to move forward at least one base.
     */
    IRunnerEvent becauseOf;

    /**
     * The base that the runner finished on.
     */
    Base finalBase;

    /**
     * Constructor.
     *
     * @param becauseOf event that caused the advancement.
     * @param finalBase base runner ended up on.
     */
    public Advancement(final IRunnerEvent becauseOf, final Base finalBase) {
        this.becauseOf = becauseOf;
        this.finalBase = finalBase;
    }

    public IRunnerEvent getBecauseOf() {
        return becauseOf;
    }

    public Base getFinalBase() {
        return finalBase;
    }

}
