package com.torneio.entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Player extends PanacheMongoEntity {

    private String name;
    private int number;

    public Player(){}

    public Player(String name, int number){
        this.name = name;
        this.number = number;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

}
