package es.chatgpt.code.ejemplo16_db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.chatgpt.code.ejemplo16_db.models.Match;
import es.chatgpt.code.ejemplo16_db.models.Team;
import es.chatgpt.code.ejemplo16_db.models.Tournament;

import es.chatgpt.code.ejemplo16_db.repository.MatchRepository;
import es.chatgpt.code.ejemplo16_db.repository.TeamRepository;
import es.chatgpt.code.ejemplo16_db.repository.TournamentRepository;
import jakarta.annotation.PostConstruct;

@Controller
public class DataBaseSandbox {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @PostConstruct
    public void init() {

        Team t1 = new Team("Real Madrid");
        Team t2 = new Team("Manchester City");
        Team t3 = new Team("Bayern Munich");

        teamRepository.save(t1);
        teamRepository.save(t2);
        teamRepository.save(t3);

        Tournament tournament = new Tournament("Champions League 2025");
        tournamentRepository.save(tournament);

        Match m1 = new Match("Cuartos de final - Ida");
        m1.setTeam1(t1);
        m1.setTeam2(t2);

        Match m2 = new Match("Cuartos de final - Vuelta");
        m2.setTeam1(t2);
        m2.setTeam2(t3);

        Match m3 = new Match("Semifinal");
        m3.setTeam1(t1);
        m3.setTeam2(t3);

        m1.setTournament(tournament);
        m2.setTournament(tournament);
        m3.setTournament(tournament);

        matchRepository.save(m1);
        matchRepository.save(m2);
        matchRepository.save(m3);

        List<Tournament> tournaments = tournamentRepository.getTournaments(t1);
        System.out.println("Tournaments : " + tournaments);

        List<Match> matches = matchRepository.getMatches(tournament);
        System.out.println("Matches : " + matches);

        List<Team> teams = teamRepository.getTeams(tournament);
        System.out.println("Teams in : " + teams);
    }
}
