package com.java.api.DTOs;

import com.java.api.Entities.Faints;
import com.java.api.Entities.Moves;
import com.java.api.Entities.Winner;

import java.util.List;

public class ReportSingleBattleId {

    private List<Moves> moves;
    private List<Faints> faints;
    private Winner winner;

    public ReportSingleBattleId(List<Moves> moves, List<Faints> faints, Winner winner) {
        this.moves = moves;
        this.faints = faints;
        this.winner = winner;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    public List<Faints> getFaints() {
        return faints;
    }

    public void setFaints(List<Faints> faints) {
        this.faints = faints;
    }

    public Winner getWinner() {
        return winner;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "ReportSingleBattleId{" +
                "moves=" + moves +
                ", faints=" + faints +
                ", winner=" + winner +
                '}';
    }
}
