package es.chatgpt.code.ejemplo8_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.chatgpt.code.ejemplo8_db.models.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
