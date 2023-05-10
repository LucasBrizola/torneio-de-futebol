package com.torneio.resources;

import com.torneio.entities.Player;
import com.torneio.entities.Team;
import com.torneio.services.TeamService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {

    @Inject
    TeamService teamService;

    @GET
    public Response findAll() {
        return teamService.findAll();
    }

    @GET
    @Path("/{name}")
    public Response findByName(@PathParam("name") String name) {
        return teamService.findByName(name);
    }

    @POST
    public Response saveTeam(Team team) {
        return teamService.saveTeam(team);
    }

    @POST
    @Path("/team/{name}")
    public Response addPlayer(@PathParam("name") String name, Player player) {
        return teamService.addPlayer(name, player);
    }

    @PUT
    @Path("/{name}")
    public Response updateTeam(@PathParam("name") String name, Team team) {
        return teamService.updateTeam(name, team);
    }

    @DELETE
    @Path("/{name}")
    public Response deleteTeam(@PathParam("name") String name) {
        return teamService.deleteTeam(name);
    }

}
