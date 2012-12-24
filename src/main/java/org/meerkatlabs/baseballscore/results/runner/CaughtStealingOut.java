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

import org.meerkatlabs.baseballscore.interfaces.IRunnerResult;
import org.meerkatlabs.baseballscore.models.HalfInning;
import org.meerkatlabs.baseballscore.models.IPosition;
import org.meerkatlabs.baseballscore.models.enums.Base;
import org.meerkatlabs.baseballscore.results.AbstractOut;

/**
 * An out that represents the batter was thrown out while trying to steal a base.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class CaughtStealingOut extends AbstractOut implements IRunnerResult {

    /**
     * Base attempted for.
     */
    final Base baseAttempted;

    /**
     * Participants that threw out the stealing runner.
     */
    final IPosition[] participants;

    /**
     * Constructor.
     *
     * @param baseAttempted base attempted for.
     * @param participants  participants that threw out the stealing runner.
     */
    public CaughtStealingOut(final Base baseAttempted, final IPosition[] participants) {
        this.baseAttempted = baseAttempted;
        this.participants = participants;
    }

    /**
     * Base attempted for accessor.
     *
     * @return base attempted for.
     */
    public Base getBaseAttempted() {
        return baseAttempted;
    }

    /**
     * Participants accessor.
     *
     * @return participants.
     */
    public IPosition[] getParticipants() {
        return participants;
    }

    @Override
    public void process(final HalfInning currentHalfInning) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
