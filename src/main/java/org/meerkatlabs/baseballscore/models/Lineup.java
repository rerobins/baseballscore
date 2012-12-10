/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meerkatlabs.baseballscore.models;

/**
 *
 * @author Robert Robinson
 */
public class Lineup {
    
    final ActivePlayer[] lineup;

    Player activePitcher;
    
    private int currentBatter = 0;

    public Lineup(IGameType gameType) {
        if (gameType.getMaxPlayers() < 1) {
            throw new IllegalArgumentException("Must have at least one player in the lineup.");
        }

        lineup = new ActivePlayer[gameType.getMaxPlayers()];
    }

    /**
     * Set the batting position.  0 is the first batter.
     * @param lineupPosition position in the line up.
     * @param player player to assign to that position.
     */
    public void setBatter(int lineupPosition, Player player, IPosition position) {
        if (lineupPosition < 0) {
            throw new IllegalArgumentException("Lineup position must be greater than 0");
        }
        
        if (lineupPosition > lineup.length) {
            throw new IllegalArgumentException("Lineup position must be less than " + lineup.length);
        }

        ActivePlayer activePlayer = new ActivePlayer();
        activePlayer.fieldingPosition = position;
        activePlayer.player = player;

        lineup[lineupPosition] = activePlayer;

        if (position.isPitcher()) {
            this.activePitcher = player;
        }
    }
    
    public Player getCurrentBatter() {
        return lineup[currentBatter].player;
    }

    public Player getNextBatter() {
        return lineup[(currentBatter+1) % lineup.length].player ;
    }

    public Player getActivePitcher() {
        return activePitcher;
    }

    public Player getPlayerAtIndex(final int i) {
        return lineup[i].player;
    }

    public void advanceLineup() {
        currentBatter = (currentBatter + 1) % lineup.length;
    }

}
