/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meerkatlabs.baseballscore.models;

import java.util.Collection;
import java.util.HashMap;

/**
 * Object that contains all of the information needed to define a base ball team.
 * @author Robert Robinson rerobins@meerkatlabs.org
 */
public class Team {
    String teamName;
    String teamCity;
    
    private final HashMap<Integer, Player> players = new HashMap<Integer, Player>();

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Collection<Player> getPlayers() {
        return players.values();
    }

    public void addPlayer(Player p) {
        if (hasPlayerNumber(p.getUniformNumber())) {
            throw new IllegalStateException("Cannot add a player that has the same uniform number");
        }
        
        players.put(p.getUniformNumber(), p);
    }
    
    protected boolean hasPlayerNumber(int number) {
        return players.containsKey(number);
    }
    
    public void removePlayer(Player p) {
        players.remove(p.getUniformNumber());
    }

    public Player getPlayer(int uniformNumber) {
        return players.get(uniformNumber);
    }
    
}
