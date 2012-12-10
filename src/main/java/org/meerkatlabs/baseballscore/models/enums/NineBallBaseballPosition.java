/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
