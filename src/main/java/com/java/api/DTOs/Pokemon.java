package com.java.api.DTOs;

import java.util.List;

public class Pokemon {

    private Integer pokemonId;
    private String name;
    private Integer level;
    private Integer baseExp;
    private Stat hp;
    private Stat attack;
    private Stat defense;
    private Stat specialAttack;
    private Stat specialDefense;
    private Stat speed;
    private List<String> moves;
    private List<String> types;

    public Pokemon () {}

    public Pokemon(Integer pokemonId, String name, Integer level, Integer baseExp, Stat hp, Stat attack, Stat defense, Stat specialAttack, Stat specialDefense, Stat speed, List<String> moves, List<String> types) {
        this.pokemonId = pokemonId;
        this.name = name;
        this.level = level;
        this.baseExp = baseExp;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.moves = moves;
        this.types = types;
    }

    public Integer getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getBaseExp() {
        return baseExp;
    }

    public void setBaseExp(Integer baseExp) {
        this.baseExp = baseExp;
    }

    public Stat getHp() {
        return hp;
    }

    public void setHp(Stat hp) {
        this.hp = hp;
    }

    public Stat getAttack() {
        return attack;
    }

    public void setAttack(Stat attack) {
        this.attack = attack;
    }

    public Stat getDefense() {
        return defense;
    }

    public void setDefense(Stat defense) {
        this.defense = defense;
    }

    public Stat getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(Stat specialAttack) {
        this.specialAttack = specialAttack;
    }

    public Stat getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(Stat specialDefense) {
        this.specialDefense = specialDefense;
    }

    public Stat getSpeed() {
        return speed;
    }

    public void setSpeed(Stat speed) {
        this.speed = speed;
    }

    public List<String> getMoves() {
        return moves;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "pokemonId=" + pokemonId +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", baseExp=" + baseExp +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", specialAttack=" + specialAttack +
                ", specialDefense=" + specialDefense +
                ", speed=" + speed +
                ", moves=" + moves +
                ", types=" + types +
                '}';
    }
}
