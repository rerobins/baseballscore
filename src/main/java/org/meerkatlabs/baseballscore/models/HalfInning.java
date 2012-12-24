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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meerkatlabs.baseballscore.models;

import org.meerkatlabs.baseballscore.interfaces.IHalfInningListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Data store for half innings.
 *
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
     * The current lay down of the infield with the base runners on the respective
     * bases.
     */
    Field currentField = null;

    /**
     * List of listeners that are subscribing to the state changes of this half inning.
     */
    private final List<IHalfInningListener> listeners = new ArrayList<IHalfInningListener>();

    /**
     * The maximum number of outs that are allowed in this half inning of baseball.
     */
    private final int maximumOuts;

    /**
     * Team that is up to bat.
     */
    final Lineup battingTeam;

    /**
     * Team that is in the field.
     */
    final Lineup fieldingTeam;

    /**
     * Default constructor for building the first half inning of the game.
     * @param gameInformation the current game type information for this object.
     */
    public HalfInning(final Game gameInformation) {
        this.inningNumber = 1;
        this.inningHalf = Half.TOP;
        this.fieldingTeam = gameInformation.getHomeLineup();
        this.battingTeam = gameInformation.getAwayLineup();
        this.maximumOuts = gameInformation.getGameType().getOutsPerHalfInning();

        this.currentField = new Field();
    }

    /**
     * Gets the next half inning that follows this one.
     *
     * @param previousHalf the previous half inning
     */
    protected HalfInning(final HalfInning previousHalf) {
        int nextInning = previousHalf.inningNumber;
        Half nextHalf;

        switch (previousHalf.inningHalf) {
            case TOP:
                nextHalf = Half.BOTTOM;
                break;
            case BOTTOM:
            default:
                nextHalf = Half.TOP;
                nextInning++;
        }

        this.inningNumber = nextInning;
        this.inningHalf = nextHalf;
        this.fieldingTeam = previousHalf.battingTeam;
        this.battingTeam = previousHalf.fieldingTeam;
        this.maximumOuts = previousHalf.maximumOuts;

        this.currentField = new Field();
    }

    /**
     *
     *
     * @return next half inning value.
     */
    public HalfInning getNextHalfInning() {
        return new HalfInning(this);
    }

    /**
     * Current at bat for this half inning.
     *
     * @return current at bat object.
     */
    public AtBat getCurrentAtBat() {
        return currentAtBat;
    }

    /**
     * Current at bat mutator.
     *
     * @param currentAtBat value.
     */
    public void setCurrentAtBat(final AtBat currentAtBat) {

        if (currentAtBat == null) {
            throw new IllegalArgumentException("Current at bat cannot be null.");
        }

        atBats.add(currentAtBat);
        this.currentAtBat = currentAtBat;
    }

    /**
     * Current outs accessor.
     *
     * @return current outs.
     */
    public int getCurrentOuts() {
        return currentOuts;
    }

    /**
     * Current outs mutator.
     *
     * @param currentOuts value.
     */
    public void setCurrentOuts(final int currentOuts) {
        this.currentOuts = currentOuts;
    }

    /**
     * Inning number accessor.
     *
     * @return inning number.
     */
    public int getInningNumber() {
        return inningNumber;
    }

    /**
     * Inning half accessor.
     *
     * @return current inning half.
     */
    public Half getInningHalf() {
        return inningHalf;
    }

    /**
     * Get the collection of at bats associated with this half inning.
     *
     * @return current list of at bats in this inning.
     */
    public List<AtBat> getAtBats() {
        return Collections.unmodifiableList(atBats);
    }

    /**
     * Current field accessor.
     * @return current field lay out.
     */
    public Field getCurrentField() {
        return this.currentField;
    }

    /**
     * Add a listener to this half inning.
     * @param listener listener.
     */
    public void addListener(final IHalfInningListener listener) {
        if (listener != null) {
            this.listeners.add(listener);
        }
    }

    /**
     * Remove a listener from this half inning.
     * @param listener listener.
     */
    public void removeListener(final IHalfInningListener listener) {
        if (listener != null) {
            this.listeners.remove(listener);
        }
    }

    /**
     * Clear all of the listeners out of this half inning.
     */
    public void clearListeners() {
        this.listeners.clear();
    }

    /**
     * Notify all of the listeners that this half inning has been completed.
     */
    public void notifyInningFinished() {
        for (IHalfInningListener listener : listeners) {
            listener.finished(this);
        }
    }

    /**
     * Maximum outs accessor.
     * @return the maximum number of outs that are allowed in this half inning.
     */
    public int getMaximumOuts() {
        return maximumOuts;
    }

    /**
     * Batting team accessor.
     * @return batting team.
     */
    public Lineup getBattingTeam() {
        return battingTeam;
    }

    /**
     * Field team accessor.
     * @return fielding team.
     */
    public Lineup getFieldingTeam() {
        return fieldingTeam;
    }
}
