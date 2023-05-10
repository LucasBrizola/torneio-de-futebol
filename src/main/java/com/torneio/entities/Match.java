package com.torneio.entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

public class Match extends PanacheMongoEntity {

    private ObjectId id;
    private String name;

    private String hour;
    private String team1;
    private String team2;

    private String goals;

    public Match() {
    }

    public Match(String name, String hour, String team1, String team2, String goals) {
        this.name = name;
        this.hour = hour;
        this.team1 = team1;
        this.team2 = team2;
        this.goals = goals;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHour() { return hour; }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getGoals() {
        return goals;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }
}
