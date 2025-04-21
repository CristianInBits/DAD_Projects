package es.chatgpt.code.comparativa_consultas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.chatgpt.code.comparativa_consultas.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUsername(String username);

    @Query("SELECT p FROM Post p WHERE p.username = ?1")
    List<Post> getByUsername(String username);

    @Query("SELECT p FROM Post p WHERE :username IS NULL OR p.username = :username")
    List<Post> findByUsernameOptional(@Param("username") String username);
}
