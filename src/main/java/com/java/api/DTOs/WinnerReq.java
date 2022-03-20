package com.java.api.DTOs;

import java.sql.Date;

public class WinnerReq {

    private String battleId;
    private String player;
    private String winningPokemon;
    private Date dateCreated;

    public WinnerReq(String battleId, String player, String winningPokemon, Date dateCreated) {
        this.battleId = battleId;
        this.player = player;
        this.winningPokemon = winningPokemon;
        this.dateCreated = dateCreated;
    }

    public String getBattleId() {
        return battleId;
    }

    public void setBattleId(String battleId) {
        this.battleId = battleId;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
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
                ", player='" + player + '\'' +
                ", winningPokemon='" + winningPokemon + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
