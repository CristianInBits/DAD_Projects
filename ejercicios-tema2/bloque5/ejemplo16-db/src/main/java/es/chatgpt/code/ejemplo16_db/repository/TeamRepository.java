package es.chatgpt.code.ejemplo16_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.chatgpt.code.ejemplo16_db.models.Team;
import es.chatgpt.code.ejemplo16_db.models.Tournament;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("SELECT distinct team FROM Match m, Team team "
            + "WHERE (m.team1 = team OR m.team2 = team) AND  m.tournament = :t")
    public List<Team> getTeams(Tournament t);
}
