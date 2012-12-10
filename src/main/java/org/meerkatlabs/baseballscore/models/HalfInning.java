/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meerkatlabs.baseballscore.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Data store for half innings.
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class HalfInning {

    /**
     * Enumeration that will determine the type of half inning that is being represented.
     */
    public enum Half {
        /**
         * Top of the inning.
         */
        TOP,

        /**
         * Bottom of the inning.
         */
        BOTTOM
    }

    /**
     * The inning number that this inning is a part of.
     */
    final int inningNumber;

    /**
     * Which half of the inning this is representing.
     */
    final Half inningHalf;

    /**
     * A Half inning will contain a list of at bats for the inning.
     */
    private final List<AtBat> atBats = new ArrayList<AtBat>();

    /**
     * The current at bat that is being manipulated.
     */
    AtBat currentAtBat = null;

    /**
     * Current number of outs in this half inning.
     */
    int currentOuts = 0;

    /**
     * Default constructor for building the first half inning of the game.
     */
    public HalfInning() {
        this.inningNumber = 1;
        this.inningHalf = Half.TOP;
    }

    /**
     * Protected constructor for moving to next inning of the game.
     * @param inningNumber new inning number.
     * @param half new inning half.
     */
    protected HalfInning(final int inningNumber, final Half half) {
        this.inningNumber = inningNumber;
        this.inningHalf = half;
    }

    /**
     * Gets the next half inning that follows this one.
     * @return next half inning value.
     */
    public HalfInning getNextHalfInning() {
        int nextInning = inningNumber;
        Half nextHalf;

        switch (inningHalf) {
            case TOP:
                nextHalf = Half.BOTTOM;
                break;
            case BOTTOM:
            default:
                nextHalf = Half.TOP;
                nextInning++;
        }

        return new HalfInning(nextInning, nextHalf);
    }

    /**
     * Current at bat for this half inning.
     * @return current at bat object.
     */
    public AtBat getCurrentAtBat() {
        return currentAtBat;
    }

    /**
     * Current at bat mutator.
     * @param currentAtBat value.
     */
    public void setCurrentAtBat(final AtBat currentAtBat) {
        atBats.add(currentAtBat);
        this.currentAtBat = currentAtBat;
    }

    /**
     * Current outs accessor.
     * @return current outs.
     */
    public int getCurrentOuts() {
        return currentOuts;
    }

    /**
     * Current outs mutator.
     * @param currentOuts value.
     */
    public void setCurrentOuts(final int currentOuts) {
        this.currentOuts = currentOuts;
    }

    /**
     * Inning number accessor.
     * @return inning number.
     */
    public int getInningNumber() {
        return inningNumber;
    }

    /**
     * Inning half accessor.
     * @return current inning half.
     */
    public Half getInningHalf() {
        return inningHalf;
    }

    /**
     * Get the collection of at bats associated with this half inning.
     * @return current list of at bats in this inning.
     */
    public List<AtBat> getAtBats() {
        return Collections.unmodifiableList(atBats);
    }
}
