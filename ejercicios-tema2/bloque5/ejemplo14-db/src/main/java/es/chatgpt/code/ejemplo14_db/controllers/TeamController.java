package es.chatgpt.code.ejemplo14_db.controllers;

import java.util.List;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.chatgpt.code.ejemplo14_db.models.Player;
import es.chatgpt.code.ejemplo14_db.models.Team;
import es.chatgpt.code.ejemplo14_db.repository.PlayerRepository;
import es.chatgpt.code.ejemplo14_db.repository.TeamRepository;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @PostConstruct
    public void init() {
        Team team1 = new Team("Selección de Portugal", 1);
        Team team2 = new Team("FC Barcelona", 1);
        Team team3 = new Team("Real Madrid", 2);
        Team team4 = new Team("Selección de Argentina", 1);

        teamRepository.save(team1);
        teamRepository.save(team2);
        teamRepository.save(team3);
        teamRepository.save(team4);

        Player p1 = new Player("Cristiano Ronaldo", 7);
        Player p2 = new Player("Lionel Messi", 10);

        p1.getTeams().add(team1); // Portugal
        p1.getTeams().add(team3); // Man. United
        p2.getTeams().add(team2); // Barça
        p2.getTeams().add(team4); // Argentina

        playerRepository.save(p1);
        playerRepository.save(p2);
    }

    interface TeamListView extends Team.BasicAtt, Team.PlayersAtt, Player.BasicAtt {
    }

    @JsonView(TeamListView.class)
    @GetMapping("/teams/")
    public List<Team> getTeams(@RequestParam(required = false) String name) throws Exception {

        if (name == null) {
            return teamRepository.findAll();
        } else {
            return teamRepository.findByName(name);
        }
    }

    interface PlayerView extends Player.BasicAtt, Player.TeamAtt, Team.BasicAtt {
    }

    @JsonView(PlayerView.class)
    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable long id) throws Exception {
        return playerRepository.findById(id).orElseThrow();
    }
}