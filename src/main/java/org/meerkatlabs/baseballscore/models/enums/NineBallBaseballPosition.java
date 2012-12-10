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
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public enum NineBallBaseballPosition implements IPosition {


    PITCHER("Pitcher", "P"),
    CATCHER("Catcher", "C"),
    FIRST_BASE("First Base", "1B"),
    SECOND_BASE("Second Base", "2B"),
    THIRD_BASE("Third Base", "3B"),
    SHORT_STOP("Short Stop", "SS"),
    LEFT_FIELD("Left Field", "LF"),
    CENTER_FIELD("Center Field", "CF"),
    RIGHT_FIELD("Right Field", "RF");
    
    String humanReadable;
    
    String abbreviation;
    
    NineBallBaseballPosition(String humanReadable, String abbreviation) {
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
        return ordinal()+1;
    }

    @Override
    public boolean isPitcher() {
        return this == PITCHER;
    }


}
