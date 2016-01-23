package com.apan.sapca.controller;

import com.apan.sapca.service.model.Game;
import com.apan.sapca.service.model.Player;
import com.apan.sapca.service.model.Team;
import com.apan.sapca.service.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created by apanc on 1/23/2016.
 */

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameRepository gameRepo;

    @RequestMapping(method = RequestMethod.POST, path = "/createGame")
    public Game createGame(@RequestBody Game game) {
        game.setTeams(game.getTeams()
                .stream()
                .map(assignGameToTeam(game))
                .collect(toList()));
        return gameRepo.saveAndFlush(game);
    }

    private static Function<Team, Team> assignGameToTeam(@RequestBody Game game) {
        return team -> {
            team.setGame(game);
            team.setPlayers(assignTeamToPlayer(team).collect(toList()));
            return team;
        };
    }

    private static Stream<Player> assignTeamToPlayer(Team team) {
        return team.getPlayers().stream().map(player -> {
            player.setTeam(team);
            return player;
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Game retrieveGame(@PathVariable long id) {
        return gameRepo.findOne(id);
    }

}
