package com.torneio.repositories;

import com.torneio.entities.User;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {

    public User findByName(String name){
        return find("name", name).firstResult();
    }

}
