package com.torneio.resources;

import com.torneio.entities.User;
import com.torneio.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;


    @POST
    public Response login(User user) {
        return userService.login(user);
    }

}
