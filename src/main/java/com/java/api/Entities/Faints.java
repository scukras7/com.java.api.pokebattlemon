package com.java.api.Entities;

import java.util.Date;

public class Faints {

    private static final String EVENT = "faint";

    private String battleId;
    private final String event = EVENT;
    private Integer turnCount;
    private String pokemon;
    private String pokemonOwner;
    private Date dateCreated;

    public Faints() {}

    public Faints(String battleId, Integer turnCount, String pokemon, String pokemonOwner, Date dateCreated) {
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

    public String getEvent() { return event; }

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
                ", event='" + event + '\'' +
                ", turnCount=" + turnCount +
                ", pokemon='" + pokemon + '\'' +
                ", pokemonOwner='" + pokemonOwner + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
