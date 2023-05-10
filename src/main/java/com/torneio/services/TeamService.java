package com.torneio.services;

import com.torneio.entities.Player;
import com.torneio.entities.Team;
import com.torneio.repositories.TeamRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@ApplicationScoped
public class TeamService {

    @Inject
    TeamRepository teamRepository;

    public Response findAll() {
        return Response.ok(teamRepository.findAll().list()).build();
    }

    public Response findByName(String name) {
        verifyTeamNotExists(name);
        return Response.ok(teamRepository.findByName(name)
        ).build();
    }

    public Response saveTeam(Team team) {
        verifyTeamSize(team.getPlayers());
        lowerCase(team);
        teamRepository.persist(team);
        return Response.ok(team).status(Response.Status.CREATED).build();
    }



    public Response updateTeam(String name, Team team) {
        lowerCase(team);
        verifyTeamNotExists(name);
        verifyTeamExists(team.getName());
        Team teamToUpdate = teamRepository.findByName(name.toLowerCase());
        teamToUpdate.setName(team.getName());
        teamToUpdate.setPlayers(team.getPlayers());
        teamRepository.update(teamToUpdate);
        return Response.ok(team).build();
    }

    public Response addPlayer(String name, Player player) {
        verifyTeamNotExists(name);
        Team updateTeam = teamRepository.findByName(name);
        if(updateTeam.getPlayers().size() == 10){
            throw new WebApplicationException("maximo de 10 jogadores em um time", Response.Status.BAD_REQUEST);
        }
        player.setName(player.getName().toLowerCase());
        updateTeam.addPlayer(player);
        return Response.ok(updateTeam).build();
    }

    public Response deleteTeam(String name) {
        verifyTeamNotExists(name);
        Team teamToDelete = teamRepository.findByName(name.toLowerCase());
        teamRepository.deleteById(teamToDelete.getId());
        return Response.noContent().build();
    }

    private void lowerCase(Team team){
        team.setName(team.getName().toLowerCase());
        for (Player player : team.getPlayers()) {
            player.setName(player.getName().toLowerCase());
        }
    }
    private void verifyTeamNotExists(String name){
        if (teamRepository.findByName(name.toLowerCase()) == null) {
            throw new WebApplicationException("Time nao encontrado", Response.Status.NOT_FOUND);
        }
    }

    private void verifyTeamExists(String name){
        if (teamRepository.findByName(name.toLowerCase()) != null) {
            throw new WebApplicationException("Time ja existe", Response.Status.NOT_FOUND);
        }
    }

    public void verifyTeamSize(ArrayList<Player> players) {
        if (players.size() < 5) {
            throw new WebApplicationException("Time precisa de ao menos 5 jogadores", Response.Status.BAD_REQUEST);
        }

        if (players.size() > 10) {
            throw new WebApplicationException("maximo de 10 jogadores em um time", Response.Status.BAD_REQUEST);
        }
    }

}