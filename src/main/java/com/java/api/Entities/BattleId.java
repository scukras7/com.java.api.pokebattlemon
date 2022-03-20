package com.java.api.Entities;

import java.util.Date;

public class BattleId {

    private String battleId;
    private Date dateCreated;

    public BattleId(String battleId, Date dateCreated) {
        this.battleId = battleId;
        this.dateCreated = dateCreated;
    }

    public String getBattleId() {
        return battleId;
    }

    public void setBattleId(String battleId) {
        this.battleId = battleId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "BattleId{" +
                "battleId='" + battleId + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
