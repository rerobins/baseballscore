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
