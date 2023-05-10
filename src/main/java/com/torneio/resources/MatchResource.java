package com.torneio.resources;

import com.torneio.entities.Match;
import com.torneio.services.MatchService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/matches")
@Produces(MediaType.APPLICATION_JSON)
public class MatchResource {

    @Inject
    MatchService matchService;

    @GET
    public Response findAll() {
        return matchService.findAll();
    }

    @GET
    @Path("/{name}")
    public Response findByName(@PathParam("name") String name) {
        return matchService.findByName(name);
    }

    @POST
    public Response saveMatch(Match match) {
        return matchService.createMatch(match);
    }

    @PUT
    @Path("/{name}")
    public Response updateTeam(@PathParam("name") String name, Match match) {
        return matchService.updateMatch(name, match);
    }

    @PATCH
    @Path("/{name}")
    public Response updateTeam(@PathParam("name") String name, String goals) {
        return matchService.updateGoals(name, goals);
    }

    @DELETE
    @Path("/{name}")
    public Response deleteTeam(@PathParam("name") String name) {
        return matchService.deleteMatch(name);
    }

}
