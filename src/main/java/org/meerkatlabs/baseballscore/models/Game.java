/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meerkatlabs.baseballscore.models;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Robert Robinson
 */
public class Game {

    /**
     * Home team in the game.
     */
    final Team homeTeam;

    /**
     * Away team in the game.
     */
    final Team awayTeam;

    /**
     * Start time of the game.
     */
    Date startTime;

    /**
     * Location of the game.
     */
    String location;

    /**
     * Game identifier.
     */
    String gameId;

    /**
     * Notes/Description of the game.
     */
    String notes;

    /**
     * The type of game that is being played.
     */
    final IGameType gameType;

    /**
     * Line up for the home team.
     */
    Lineup homeLineup;

    /**
     * Line up for the away team.
     */
    Lineup awayLineup;

    /**
     * Constructor.
     * @param homeTeam
     * @param awayTeam
     * @param startTime
     * @param location
     * @param gameId
     * @param notes
     * @param gameType
     */
    public Game(Team homeTeam, Team awayTeam, Date startTime,
                String location, String gameId, String notes, IGameType gameType) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.startTime = startTime;
        this.location = location;
        this.gameId = gameId;
        this.notes = notes;
        this.gameType = gameType;

        homeLineup = new Lineup(gameType);
        awayLineup = new Lineup(gameType);
    }
    
    public Game(Team homeTeam, Team awayTeam, IGameType gameType) {
        this(homeTeam, awayTeam, new Date(), homeTeam.getTeamCity(),
                UUID.randomUUID().toString(), "", gameType);
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public IGameType getGameType() {
        return gameType;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Lineup getAwayLineup() {
        return awayLineup;
    }

    public Lineup getHomeLineup() {
        return homeLineup;
    }

    public void startGame() {

    }
    
}
