package es.chatgpt.code.ejemplo16_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.chatgpt.code.ejemplo16_db.models.Team;
import es.chatgpt.code.ejemplo16_db.models.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    @Query("SELECT distinct t FROM Match m JOIN m.tournament t " +
            "WHERE m.team1 = :team OR m.team2 = :team")
    public List<Tournament> getTournaments(Team team);
}