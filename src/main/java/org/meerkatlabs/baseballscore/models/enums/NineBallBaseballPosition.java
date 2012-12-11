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

package org.meerkatlabs.baseballscore.models.enums;

import org.meerkatlabs.baseballscore.models.IPosition;

/**
 * Positions for a standard base ball game.
 *
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public enum NineBallBaseballPosition implements IPosition {


    /**
     * Pitcher.
     */
    PITCHER("Pitcher", "P"),

    /**
     * Catcher.
     */
    CATCHER("Catcher", "C"),

    /**
     * First Base.
     */
    FIRST_BASE("First Base", "1B"),

    /**
     * Second Base.
     */
    SECOND_BASE("Second Base", "2B"),

    /**
     * Third Base.
     */
    THIRD_BASE("Third Base", "3B"),

    /**
     * Short Stop.
     */
    SHORT_STOP("Short Stop", "SS"),

    /**
     * Left Field.
     */
    LEFT_FIELD("Left Field", "LF"),

    /**
     * Center Field.
     */
    CENTER_FIELD("Center Field", "CF"),

    /**
     * Right Field.
     */
    RIGHT_FIELD("Right Field", "RF");

    /**
     * Human readable version of the enumeration.
     */
    String humanReadable;

    /**
     * Abbreviation of the position.
     */
    String abbreviation;

    /**
     * Constructor.
     *
     * @param humanReadable string.
     * @param abbreviation  string.
     */
    NineBallBaseballPosition(final String humanReadable, final String abbreviation) {
        this.humanReadable = humanReadable;
        this.abbreviation = abbreviation;
    }

    @Override
    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public String toString() {
        return humanReadable;
    }

    @Override
    public int getNumericalValue() {
        return ordinal() + 1;
    }

    @Override
    public boolean isPitcher() {
        return this == PITCHER;
    }


}
