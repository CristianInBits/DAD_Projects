package es.chatgpt.code.ejemplo10_db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.ejemplo10_db.models.Player;
import es.chatgpt.code.ejemplo10_db.models.Team;
import es.chatgpt.code.ejemplo10_db.repository.PlayerRepository;
import es.chatgpt.code.ejemplo10_db.repository.TeamRepository;
import jakarta.annotation.PostConstruct;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @PostConstruct
    public void init() {

        Team team = new Team("Selección", 1);

        teamRepository.save(team);

        Player p1 = new Player("Torres", 10);
        Player p2 = new Player("Iniesta", 10);

        p1.setTeam(team);
        p2.setTeam(team);

        playerRepository.save(p1);
        playerRepository.save(p2);
    }

    @GetMapping("/teams/")
    public List<Team> getTeams() throws Exception {
        return teamRepository.findAll();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable long id) throws Exception {
        return playerRepository.findById(id).orElseThrow();
    }
}
