package com.torneio.services;

import com.torneio.entities.Match;
import com.torneio.repositories.MatchRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class MatchService {

    @Inject
    MatchRepository matchRepository;

    public Response findAll() {
        return Response.ok(matchRepository.findAll().list()).build();
    }

    public Response findByName(String name) {
        verifyMatchNotExists(name);
        return Response.ok(matchRepository.findByName(name)
        ).build();
    }

    public Response createMatch(Match match) {
        lowerCase(match);
        validateGoalsInput(match.getGoals());
        matchRepository.persist(match);
        return Response.ok(match).status(Response.Status.CREATED).build();
    }



    public Response updateMatch(String name, Match match) {
        lowerCase(match);
        verifyMatchNotExists(name);
        validateGoalsInput(match.getGoals());
        Match matchToUpdate = matchRepository.findByName(name.toLowerCase());
        matchToUpdate.setName(match.getName());
        matchToUpdate.setHour(match.getHour());
        matchToUpdate.setTeam1(match.getTeam1());
        matchToUpdate.setTeam2(match.getTeam2());
        matchToUpdate.setGoals(match.getGoals());
        matchRepository.update(matchToUpdate);
        return Response.ok(match).build();
    }

    public Response updateGoals(String name, String goals){
        verifyMatchNotExists(name);
        validateGoalsInput(goals);
        Match matchToUpdate = matchRepository.findByName(name.toLowerCase());
        matchToUpdate.setGoals(goals);
        matchRepository.update(matchToUpdate);
        return Response.ok(matchToUpdate).build();
    }

    public Response deleteMatch(String name) {
        Match matchToDelete = matchRepository.findByName(name.toLowerCase());
        matchRepository.deleteById(matchToDelete.getId());
        return Response.noContent().build();
    }

    private void lowerCase(Match match){
        match.setName(match.getName().toLowerCase());
    }

    private void verifyMatchNotExists(String name){
        if (matchRepository.findByName(name.toLowerCase()) == null) {
            throw new WebApplicationException("Partida nao encontrada", Response.Status.NOT_FOUND);
        }
    }

    private void validateGoalsInput(String goals){
        if (!goals.contains("x")) {
            throw new WebApplicationException("Formato errado de placar Ex: 0x0", Response.Status.BAD_REQUEST);
        }
        String[] goalSplit = goals.split("x");
        for (String goal: goalSplit ) {
            if(!goal.matches("^[0-9]$")){
                throw new WebApplicationException("Somente numeros no placar Ex: 0x0", Response.Status.BAD_REQUEST);
            }
        }
    }

}