/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meerkatlabs.baseballscore.models;

/**
 *
 * @author rerobins
 */
public interface IPosition {

    /**
     * Abbreviation for the position.
     * @return human readable abbreviation for the position.
     */
    String getAbbreviation();

    /**
     * Numerical value for the position.
     * @return numerical value.
     */
    int getNumericalValue();

    boolean isPitcher();
}
