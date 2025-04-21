package es.chatgpt.code.ejemplo16_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.chatgpt.code.ejemplo16_db.models.Tournament;
import es.chatgpt.code.ejemplo16_db.models.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("SELECT m FROM Match m WHERE m.tournament = :t")
    public List<Match> getMatches(Tournament t);
}
