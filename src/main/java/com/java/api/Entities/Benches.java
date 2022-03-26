package com.java.api.Entities;

import com.java.api.POJOs.Pokemon;

import java.util.Date;
import java.util.List;

public class Benches {

    private String battleId;
    private List<Pokemon> playerBench;
    private List<Pokemon> opponentBench;
    private Date dateCreated;

    public Benches() {}

    public Benches(String battleId, List<Pokemon> playerBench, List<Pokemon> opponentBench, Date dateCreated) {
        this.battleId = battleId;
        this.playerBench = playerBench;
        this.opponentBench = opponentBench;
        this.dateCreated = dateCreated;
    }

    public String getBattleId() {
        return battleId;
    }

    public void setBattleId(String battleId) {
        this.battleId = battleId;
    }

    public List<Pokemon> getPlayerBench() {
        return playerBench;
    }

    public void setPlayerBench(List<Pokemon> playerBench) {
        this.playerBench = playerBench;
    }

    public List<Pokemon> getOpponentBench() {
        return opponentBench;
    }

    public void setOpponentBench(List<Pokemon> opponentBench) {
        this.opponentBench = opponentBench;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "BenchesReq{" +
                "battleId='" + battleId + '\'' +
                ", playerBench=" + playerBench +
                ", opponentBench=" + opponentBench +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
