package com.torneio.services;

import com.torneio.entities.User;
import com.torneio.repositories.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public Response login(User user) {
        lowerCase(user);
        verifyUserNotExists(user.getName());
        User userFromDB = userRepository.findByName(user.getName());
        if (userFromDB.getPassword().equals(user.getPassword())) {
            return Response.accepted(true).build();
        }
        throw new WebApplicationException("Senha incorreta", Response.Status.UNAUTHORIZED);
    }

    private void lowerCase(User user) {
        user.setName(user.getName().toLowerCase());
    }

    private void verifyUserNotExists(String name) {
        if (userRepository.findByName(name.toLowerCase()) == null) {
            throw new WebApplicationException("Usuario nao encontrado", Response.Status.NOT_FOUND);
        }
    }

}