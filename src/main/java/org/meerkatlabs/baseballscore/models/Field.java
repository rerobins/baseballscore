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

import org.meerkatlabs.baseballscore.events.runner.Hit;
import org.meerkatlabs.baseballscore.models.enums.AtBatResult;
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
     * Moves the batter to the correct value based on the hit that was made.
     *
     * @param batter batter that was hitting.
     * @param hit    hit that was made.
     */
    public void runnerHit(final AtBat batter, final Hit hit) {

        // The easiest way to do this is to iterate the number of bases that need to be moved,
        // and for each one move the current batter forward, check the result of the field,
        // and then update the scores if necessary.

        Base baseEndedUpOn = hit.getFinalBase();

        for (int i = 0; i <= baseEndedUpOn.ordinal(); ++i) {

            Base baseToMoveTo = Base.values()[i];

            advanceRunners(baseToMoveTo, batter);
            updateScore();
        }

    }

    /**
     * Walk the at bat to first base.
     * @param atBat the runner that should advance to first base.
     */
    public void walkRunner(final AtBat atBat) {
        advanceRunners(Base.FIRST_BASE, atBat);
        updateScore();
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

    /**
     * Set the base runner onto the base provided.
     *
     * @param base  base that the runner should be on.
     * @param atBat the runner that should be there.
     */
    void setBaseRunner(final Base base, final AtBat atBat) {
        switch (base) {
            case FIRST_BASE:
            case SECOND_BASE:
            case THIRD_BASE:
            case HOME_PLATE:
                baseRunners[base.ordinal()] = atBat;
                break;

            case NONE:
            default:
                throw new IllegalArgumentException("Unknown base: " + base.toString());
        }
    }

    /**
     * Update the base runner that is currently on home, if there is one.
     */
    void updateScore() {
        AtBat atBat = getBaseRunner(Base.HOME_PLATE);

        if (atBat != null) {
            atBat.setResult(AtBatResult.SCORED);
        }

        // Clear the base runner that is on home plate since he is no longer in play.
        setBaseRunner(Base.HOME_PLATE, null);
    }

}
