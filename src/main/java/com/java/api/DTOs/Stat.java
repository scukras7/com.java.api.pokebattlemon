package com.java.api.DTOs;

public class Stat {

    private String name;
    private Integer baseStat;
    private Integer currentStat;

    public Stat () {}

    public Stat(String name, Integer baseStat, Integer currentStat) {
        this.name = name;
        this.baseStat = baseStat;
        this.currentStat = currentStat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(Integer baseStat) {
        this.baseStat = baseStat;
    }

    public Integer getCurrentStat() {
        return currentStat;
    }

    public void setCurrentStat(Integer currentStat) {
        this.currentStat = currentStat;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "name='" + name + '\'' +
                ", baseStat=" + baseStat +
                ", currentStat=" + currentStat +
                '}';
    }
}
