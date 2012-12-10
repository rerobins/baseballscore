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

package org.meerkatlabs.baseballscore.util;

import org.meerkatlabs.baseballscore.models.BaseballGameType;
import org.meerkatlabs.baseballscore.models.Game;
import org.meerkatlabs.baseballscore.models.Player;
import org.meerkatlabs.baseballscore.models.Team;
import org.meerkatlabs.baseballscore.models.enums.NineBallBaseballPosition;

/**
 * Created with IntelliJ IDEA.
 * User: rerobins
 * Date: 9/25/12
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */
public enum BuildGame {

    INSTANCE;

    public Game buildBasicGame() {

        Team coloradoRockies = buildRockies();
        Team skySox = buildSkySox();

        Game game = new Game(coloradoRockies,
                skySox, BaseballGameType.INSTANCE);

        game.getHomeLineup().setBatter(0, coloradoRockies.getPlayer(1), NineBallBaseballPosition.PITCHER);
        game.getHomeLineup().setBatter(1, coloradoRockies.getPlayer(2), NineBallBaseballPosition.CATCHER);
        game.getHomeLineup().setBatter(2, coloradoRockies.getPlayer(3), NineBallBaseballPosition.FIRST_BASE);
        game.getHomeLineup().setBatter(3, coloradoRockies.getPlayer(4), NineBallBaseballPosition.SECOND_BASE);
        game.getHomeLineup().setBatter(4, coloradoRockies.getPlayer(5), NineBallBaseballPosition.THIRD_BASE);
        game.getHomeLineup().setBatter(5, coloradoRockies.getPlayer(6), NineBallBaseballPosition.SHORT_STOP);
        game.getHomeLineup().setBatter(6, coloradoRockies.getPlayer(7), NineBallBaseballPosition.LEFT_FIELD);
        game.getHomeLineup().setBatter(7, coloradoRockies.getPlayer(8), NineBallBaseballPosition.CENTER_FIELD);
        game.getHomeLineup().setBatter(8, coloradoRockies.getPlayer(9), NineBallBaseballPosition.RIGHT_FIELD);

        game.getAwayLineup().setBatter(0, skySox.getPlayer(1), NineBallBaseballPosition.PITCHER);
        game.getAwayLineup().setBatter(1, skySox.getPlayer(2), NineBallBaseballPosition.CATCHER);
        game.getAwayLineup().setBatter(2, skySox.getPlayer(3), NineBallBaseballPosition.FIRST_BASE);
        game.getAwayLineup().setBatter(3, skySox.getPlayer(4), NineBallBaseballPosition.SECOND_BASE);
        game.getAwayLineup().setBatter(4, skySox.getPlayer(5), NineBallBaseballPosition.THIRD_BASE);
        game.getAwayLineup().setBatter(5, skySox.getPlayer(6), NineBallBaseballPosition.SHORT_STOP);
        game.getAwayLineup().setBatter(6, skySox.getPlayer(7), NineBallBaseballPosition.LEFT_FIELD);
        game.getAwayLineup().setBatter(7, skySox.getPlayer(8), NineBallBaseballPosition.CENTER_FIELD);
        game.getAwayLineup().setBatter(8, skySox.getPlayer(9), NineBallBaseballPosition.RIGHT_FIELD);

        return game;
    }

    private Team buildRockies() {
        Team team = new Team();
        team.setTeamCity("Colorado");
        team.setTeamName("Rockies");

        Player player1 = new Player(1, "Rockies 1", NineBallBaseballPosition.PITCHER);
        Player player2 = new Player(2, "Rockies 2", NineBallBaseballPosition.CATCHER);
        Player player3 = new Player(3, "Rockies 3", NineBallBaseballPosition.FIRST_BASE);
        Player player4 = new Player(4, "Rockies 4", NineBallBaseballPosition.SECOND_BASE);
        Player player5 = new Player(5, "Rockies 5", NineBallBaseballPosition.THIRD_BASE);
        Player player6 = new Player(6, "Rockies 6", NineBallBaseballPosition.SHORT_STOP);
        Player player7 = new Player(7, "Rockies 7", NineBallBaseballPosition.LEFT_FIELD);
        Player player8 = new Player(8, "Rockies 8", NineBallBaseballPosition.CENTER_FIELD);
        Player player9 = new Player(9, "Rockies 9", NineBallBaseballPosition.RIGHT_FIELD);

        Player player10 = new Player(10, "Rockies 10");
        Player player11 = new Player(11, "Rockies 11", NineBallBaseballPosition.PITCHER);
        Player player12 = new Player(12, "Rockies 12", NineBallBaseballPosition.PITCHER);
        Player player13 = new Player(13, "Rockies 13", NineBallBaseballPosition.PITCHER);
        Player player14 = new Player(14, "Rockies 14", NineBallBaseballPosition.PITCHER);

        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.addPlayer(player4);
        team.addPlayer(player5);
        team.addPlayer(player6);
        team.addPlayer(player7);
        team.addPlayer(player8);
        team.addPlayer(player9);
        team.addPlayer(player10);
        team.addPlayer(player11);
        team.addPlayer(player12);
        team.addPlayer(player13);
        team.addPlayer(player14);

        return team;
    }

    private Team buildSkySox() {
        Team team = new Team();
        team.setTeamCity("Colorado Springs");
        team.setTeamName("Sky Sox");

        Player player1 = new Player(1, "Sky Sox 1", NineBallBaseballPosition.PITCHER);
        Player player2 = new Player(2, "Sky Sox 2", NineBallBaseballPosition.CATCHER);
        Player player3 = new Player(3, "Sky Sox 3", NineBallBaseballPosition.FIRST_BASE);
        Player player4 = new Player(4, "Sky Sox 4", NineBallBaseballPosition.SECOND_BASE);
        Player player5 = new Player(5, "Sky Sox 5", NineBallBaseballPosition.THIRD_BASE);
        Player player6 = new Player(6, "Sky Sox 6", NineBallBaseballPosition.SHORT_STOP);
        Player player7 = new Player(7, "Sky Sox 7", NineBallBaseballPosition.LEFT_FIELD);
        Player player8 = new Player(8, "Sky Sox 8", NineBallBaseballPosition.CENTER_FIELD);
        Player player9 = new Player(9, "Sky Sox 9", NineBallBaseballPosition.RIGHT_FIELD);

        Player player10 = new Player(10, "Sky Sox 10");
        Player player11 = new Player(11, "Sky Sox 11", NineBallBaseballPosition.PITCHER);
        Player player12 = new Player(12, "Sky Sox 12", NineBallBaseballPosition.PITCHER);
        Player player13 = new Player(13, "Sky Sox 13", NineBallBaseballPosition.PITCHER);
        Player player14 = new Player(14, "Sky Sox 14", NineBallBaseballPosition.PITCHER);

        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.addPlayer(player4);
        team.addPlayer(player5);
        team.addPlayer(player6);
        team.addPlayer(player7);
        team.addPlayer(player8);
        team.addPlayer(player9);
        team.addPlayer(player10);
        team.addPlayer(player11);
        team.addPlayer(player12);
        team.addPlayer(player13);
        team.addPlayer(player14);

        return team;
    }


}
