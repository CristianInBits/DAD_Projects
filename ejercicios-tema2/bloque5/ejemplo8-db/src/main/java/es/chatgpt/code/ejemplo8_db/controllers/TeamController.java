package es.chatgpt.code.ejemplo8_db.controllers;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.ejemplo8_db.models.Player;
import es.chatgpt.code.ejemplo8_db.models.Team;
import es.chatgpt.code.ejemplo8_db.repository.PlayerRepository;
import es.chatgpt.code.ejemplo8_db.repository.TeamRepository;
import jakarta.annotation.PostConstruct;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @PostConstruct
    public void init() {

        Player p1 = new Player("Torres", 10);
        Player p2 = new Player("Iniesta", 10);

        playerRepository.save(p1);
        playerRepository.save(p2);

        Team team = new Team("Selección", 1);

        team.getPlayers().add(p1);
        team.getPlayers().add(p2);

        teamRepository.save(team);
    }

    @GetMapping("/teams/")
    public List<Team> getTeams() throws Exception {
        return teamRepository.findAll();
    }

    @GetMapping("/players/")
    public List<Player> getPlayers() throws Exception {
        return playerRepository.findAll();
    }

    // Deleting a team doesn't delete its associated players
    @DeleteMapping("/teams/{id}")
    public Team deleteTeam(@PathVariable long id) {
        Team team = teamRepository.findById(id).orElseThrow();
        // Force loading players from database to be returned as JSON
        Hibernate.initialize(team.getPlayers());
        teamRepository.deleteById(id);
        return team;
    }

    // A player only can be deleted if it has no associated team
    @DeleteMapping("/players/{id}")
    public Player deletePlayer(@PathVariable long id) {
        Player player = playerRepository.findById(id).orElseThrow();
        playerRepository.deleteById(id);
        return player;
    }
}
