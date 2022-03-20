package com.java.api.DTOs;

import java.util.Date;

public class FaintsReq {

    private String battleId;
    private Integer turnCount;
    private String pokemon;
    private String pokemonOwner;
    private Date dateCreated;

    public FaintsReq() {}

    public FaintsReq(String battleId, Integer turnCount, String pokemon, String pokemonOwner, Date dateCreated) {
        this.battleId = battleId;
        this.turnCount = turnCount;
        this.pokemon = pokemon;
        this.pokemonOwner = pokemonOwner;
        this.dateCreated = dateCreated;
    }

    public String getBattleId() {
        return battleId;
    }

    public void setBattleId(String battleId) {
        this.battleId = battleId;
    }

    public Integer getTurnCount() { return turnCount; }

    public void setTurnCount(Integer turnCount) { this.turnCount = turnCount; }

    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

    public String getPokemonOwner() {
        return pokemonOwner;
    }

    public void setPokemonOwner(String pokemonOwner) {
        this.pokemonOwner = pokemonOwner;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "FaintsReq{" +
                "battleId='" + battleId + '\'' +
                ", turnCount=" + turnCount +
                ", pokemon='" + pokemon + '\'' +
                ", pokemonOwner='" + pokemonOwner + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
