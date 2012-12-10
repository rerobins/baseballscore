package org.meerkatlabs.baseballscore.models;

import org.meerkatlabs.baseballscore.models.enums.AtBatResult;
import org.meerkatlabs.baseballscore.models.enums.Base;

/**
 * Object that will contain the current state of the field with regards to base runners.  It
 * will also provide the required logic that will be used to update the field as players hit,
 * walk, or become out.  The field will assume that the runners will always be forced forwards,
 * so when updating the field, it should be done from the lower bases first in the hopes that
 * the number of updates needed to update the field should be reduced.
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class Field {

    /**
     * Collection of base runners that are maintained.
     */
    final AtBat[] baseRunners = new AtBat[Base.values().length];

    /**
     * Update the field with the at bat and the result provided.
     * @param atBat at bat that will manipulate the field.
     * @param result how the field has manipulated the field.
     */
    public void processResult(final AtBat atBat, final AtBatResult result) {

        switch (result) {

            case BASE_ON_BALLS:
                walkRunner(atBat);
                return;

            default:
                throw new IllegalStateException("Unknown result to process for the field.");
        }

    }

    /**
     * Update the field by walking the runner.
     * @param walkee the at bat that was just walked.
     */
    void walkRunner(final AtBat walkee) {
        advanceRunners(Base.FIRST_BASE, walkee);
    }

    /**
     * Advance the runners starting at the base to start at.
     * @param base the base that the at bat should be placed at.
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

}