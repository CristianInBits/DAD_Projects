package es.chatgpt.code.ejemplo12_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.chatgpt.code.ejemplo12_db.models.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
