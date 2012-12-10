/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meerkatlabs.baseballscore.models;

import org.meerkatlabs.baseballscore.models.enums.NineBallBaseballPosition;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Robert Robinson
 */
public enum BaseballGameType implements IGameType {

    INSTANCE;

    private final int MAXIMUM_PLAYERS = 9;

    private final int OUTS_PER_SIDE_PER_INNING = 3;
    
    private final int REGULATION_INNINGS = 9;
    
    private static final List<NineBallBaseballPosition> positions =
            Arrays.asList(NineBallBaseballPosition.values());

    @Override
    public int getMaxPlayers() {
        return MAXIMUM_PLAYERS;
    }

    @Override
    public List<? extends IPosition> getPositions() {
        return positions;
    }

    @Override
    public int getOutsPerHalfInning() {
        return OUTS_PER_SIDE_PER_INNING;
    }

    @Override
    public int getRegulationInningCount() {
        return REGULATION_INNINGS;
    }


}
