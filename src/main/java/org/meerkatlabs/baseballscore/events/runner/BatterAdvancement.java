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

import org.meerkatlabs.baseballscore.interfaces.IBatterEvent;
import org.meerkatlabs.baseballscore.interfaces.IRunnerEvent;
import org.meerkatlabs.baseballscore.interfaces.IRunnerResult;
import org.meerkatlabs.baseballscore.models.HalfInning;
import org.meerkatlabs.baseballscore.models.enums.Base;

/**
 * Used when a batter is allowed to advance and become a runner due to events at the
 * plate.
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class BatterAdvancement implements IRunnerEvent {

    /**
     * The event that caused this player to move forward at least one base.
     */
    IBatterEvent becauseOf;

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
    public BatterAdvancement(final IBatterEvent becauseOf, final Base finalBase) {
        this.becauseOf = becauseOf;
        this.finalBase = finalBase;
    }

    /**
     * Return the reason that the runner got to advance to the next base.
     * @return the event that forced this advancement to occur.
     */
    public IBatterEvent getBecauseOf() {
        return becauseOf;
    }

    /**
     * Return the base that the runner will have advanced to because of the the runner
     * event.
     * @return the base that the runner ends up on because of the advancement event.
     */
    public Base getFinalBase() {
        return finalBase;
    }

    @Override
    public IRunnerResult process(final HalfInning currentHalfInning) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
