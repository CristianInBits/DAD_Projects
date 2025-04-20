package es.chatgpt.code.ejemplo12_db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.chatgpt.code.ejemplo12_db.models.Player;
import es.chatgpt.code.ejemplo12_db.models.Team;
import es.chatgpt.code.ejemplo12_db.repository.PlayerRepository;
import es.chatgpt.code.ejemplo12_db.repository.TeamRepository;
import jakarta.annotation.PostConstruct;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;
    
    @Autowired
    private PlayerRepository playerRepository;

    @PostConstruct
    public void init() {
        Team team1 = new Team("Selección de Portugal", 2);
        Team team2 = new Team("FC Barcelona", 2);
        Team team3 = new Team("Real Madrid", 1);
        Team team4 = new Team("Selección de Argentina", 1);

        teamRepository.save(team1);
        teamRepository.save(team2);
        teamRepository.save(team3);
        teamRepository.save(team4);

        Player p1 = new Player("Cristiano Ronaldo", 11);
        Player p2 = new Player("Lionel Messi", 10);

        p1.getTeams().add(team1);
        p1.getTeams().add(team3);
        p2.getTeams().add(team2);
        p2.getTeams().add(team4);

        playerRepository.save(p1);
        playerRepository.save(p2);
    }

    interface TeamListView extends Team.BasicAtt, Team.PlayersAtt, Player.BasicAtt {
    }

    @JsonView(TeamListView.class)
    @GetMapping("/teams/")
    public List<Team> getTeams() throws Exception {
        return teamRepository.findAll();
    }

    interface PlayerView extends Player.BasicAtt, Player.TeamAtt, Team.BasicAtt {
    }

    @JsonView(PlayerView.class)
    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable long id) throws Exception {
        return playerRepository.findById(id).orElseThrow();
    }
}
