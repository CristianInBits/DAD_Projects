package es.chatgpt.code.ejemplo14_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.chatgpt.code.ejemplo14_db.models.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
    
    @Query("select t from Team t where t.name = ?1")
    List<Team> findByName(String name);
}
