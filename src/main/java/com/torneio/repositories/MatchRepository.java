package com.torneio.repositories;

import com.torneio.entities.Match;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatchRepository implements PanacheMongoRepository<Match> {

    public Match findByName(String name){
        return find("name", name).firstResult();
    }

}
