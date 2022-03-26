package com.java.api.Entities;

import java.util.Date;

public class Winner {

    private static final String EVENT = "winner";

    private String battleId;
    private final String event = EVENT;
    private Integer turnCount;
    private String winningPlayer;
    private String winningPokemon;
    private Date dateCreated;

    public Winner() {}

    public Winner(String battleId, Integer turnCount, String winningPlayer, String winningPokemon, Date dateCreated) {
        this.battleId = battleId;
        this.turnCount = turnCount;
        this.winningPlayer = winningPlayer;
        this.winningPokemon = winningPokemon;
        this.dateCreated = dateCreated;
    }

    public String getBattleId() {
        return battleId;
    }

    public void setBattleId(String battleId) {
        this.battleId = battleId;
    }

    public String getEvent() { return event; }

    public Integer getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(Integer turnCount) {
        this.turnCount = turnCount;
    }

    public String getWinningPlayer() {
        return winningPlayer;
    }

    public void setWinningPlayer(String winningPlayer) {
        this.winningPlayer = winningPlayer;
    }

    public String getWinningPokemon() {
        return winningPokemon;
    }

    public void setWinningPokemon(String winningPokemon) {
        this.winningPokemon = winningPokemon;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "WinnerReq{" +
                "battleId='" + battleId + '\'' +
                ", event='" + event + '\n' +
                ", turnCount=" + turnCount +
                ", winningPlayer='" + winningPlayer + '\'' +
                ", winningPokemon='" + winningPokemon + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
