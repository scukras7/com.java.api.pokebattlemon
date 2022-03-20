package com.java.api.DTOs;

import java.util.Date;

public class MoveReq {

    private String battleId;
    private Integer turnCount;
    private String attackingPokemon;
    private String defendingPokemon;
    private String name;
    private Integer damageAmountDealt;
    private Date dateCreated;

    public MoveReq() {}

    public MoveReq(String battleId, Integer turnCount, String attackingPokemon, String defendingPokemon, String name, Integer damageAmountDealt, Date dateCreate) {
        this.battleId = battleId;
        this.turnCount = turnCount;
        this.attackingPokemon = attackingPokemon;
        this.defendingPokemon = defendingPokemon;
        this.name = name;
        this.damageAmountDealt = damageAmountDealt;
        this.dateCreated = dateCreate;
    }

    public String getBattleId() {
        return battleId;
    }

    public void setBattleId(String battleId) {
        this.battleId = battleId;
    }

    public Integer getTurnCount() { return turnCount; }

    public void setTurnCount(Integer turnCount) {  this.turnCount = turnCount; }

    public String getAttackingPokemon() { return attackingPokemon; }

    public void setAttackingPokemon(String attackingPokemon) { this.attackingPokemon = attackingPokemon; }

    public String getDefendingPokemon() { return defendingPokemon; }

    public void setDefendingPokemon(String defendingPokemon) { this.defendingPokemon = defendingPokemon; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDamageAmountDealt() {
        return damageAmountDealt;
    }

    public void setDamageAmountDealt(Integer damageAmountDealt) {
        this.damageAmountDealt = damageAmountDealt;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "MovesReq{" +
                "battleId='" + battleId + '\'' +
                ", turnCount=" + turnCount +
                ", attackingPokemon='" + attackingPokemon + '\'' +
                ", defendingPokemon='" + defendingPokemon + '\'' +
                ", name='" + name + '\'' +
                ", damageAmountDealt=" + damageAmountDealt +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
