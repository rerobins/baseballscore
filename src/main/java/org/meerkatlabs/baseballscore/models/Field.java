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

package org.meerkatlabs.baseballscore.models;

import org.meerkatlabs.baseballscore.models.enums.Base;
import org.meerkatlabs.baseballscore.models.enums.InPlay;
import org.meerkatlabs.baseballscore.models.interfaces.IInPlayDescription;

/**
 * Object that will contain the current state of the field with regards to base runners.  It
 * will also provide the required logic that will be used to update the field as players hit,
 * walk, or become out.  The field will assume that the runners will always be forced forwards,
 * so when updating the field, it should be done from the lower bases first in the hopes that
 * the number of updates needed to update the field should be reduced.
 * <p/>
 * TODO: Need to figure out how to back up an inning in case the user makes a mistake and goes
 * towards the next half inning prematurely.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class Field {

    /**
     * Collection of base runners that are maintained.
     */
    final AtBat[] baseRunners = new AtBat[Base.values().length];

    /**
     * Default constructor.
     */
    public Field() {

    }

    /**
     * Update the field with the at bat and the result provided.
     *
     * @param atBat  at bat that will manipulate the field.
     * @param result how the field has manipulated the field.
     */
    public void processResult(final AtBat atBat, final IInPlayDescription result) {

        if (result == InPlay.BASE_ON_BALLS) {
            walkRunner(atBat);
        } else if (result == InPlay.NONE) {
            // Nothing to process.
        } else {
            throw new IllegalStateException("Unknown result to process for the field: " + result.toString());
        }

    }

    /**
     * Update the field by walking the runner.
     *
     * @param batter the at bat that was just walked.
     */
    void walkRunner(final AtBat batter) {
        advanceRunners(Base.FIRST_BASE, batter);
    }

    /**
     * Advance the runners starting at the base to start at.
     *
     * @param base  the base that the at bat should be placed at.
     * @param atBat the at bat that should be placed on the base.
     */
    void advanceRunners(final Base base, final AtBat atBat) {
        // Probably the easiest way to execute this is to run it recursively.

        if (baseRunners[base.ordinal()] != null) {
            // Need to move the base runner on the base to the next base.
            Base nextBase = base.getNextBase();
            if (nextBase != Base.NONE) {
                advanceRunners(nextBase, baseRunners[base.ordinal()]);
            }

        }

        baseRunners[base.ordinal()] = atBat;

    }

    /**
     * Return the base runner on the base provided.
     *
     * @param base base to look up.
     * @return the base runner or null.
     */
    public AtBat getBaseRunner(final Base base) {
        switch (base) {
            case FIRST_BASE:
            case SECOND_BASE:
            case THIRD_BASE:
            case HOME_PLATE:
                return baseRunners[base.ordinal()];

            case NONE:
            default:
                throw new IllegalArgumentException("Unknown base: " + base.toString());
        }
    }

}
