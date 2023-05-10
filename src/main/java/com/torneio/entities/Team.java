package com.torneio.entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Team extends PanacheMongoEntity {

    private ObjectId id;
    private String name;
    private ArrayList<Player> players;

    public Team() {
    }

    public Team(String name, ArrayList<Player> players) {
        this.name = name;
        this.players = players;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

}
