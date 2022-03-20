package com.java.api.DTOs;

import java.sql.Date;

public class WinnerReq {

    private String battleId;
    private String winningPlayer;
    private String winningPokemon;
    private Date dateCreated;

    public WinnerReq() {}

    public WinnerReq(String battleId, String winningPlayer, String winningPokemon, Date dateCreated) {
        this.battleId = battleId;
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
        return "WinnersReq{" +
                "battleId='" + battleId + '\'' +
                ", winningPlayer='" + winningPlayer + '\'' +
                ", winningPokemon='" + winningPokemon + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
