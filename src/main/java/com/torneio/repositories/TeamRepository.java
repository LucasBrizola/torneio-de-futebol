package com.torneio.repositories;

import com.torneio.entities.Team;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeamRepository implements PanacheMongoRepository<Team> {

    public Team findByName(String name){
        return find("name", name).firstResult();
    }

}
