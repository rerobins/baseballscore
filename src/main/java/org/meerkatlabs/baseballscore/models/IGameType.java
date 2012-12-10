/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meerkatlabs.baseballscore.models;

import java.util.List;

/**
 *
 * @author rerobins
 */
public interface IGameType {

    int getMaxPlayers();
    
    List<? extends IPosition> getPositions();

    int getOutsPerHalfInning();

    int getRegulationInningCount();


}
