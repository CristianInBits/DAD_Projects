package es.chatgpt.code.ejemplo21_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.chatgpt.code.ejemplo21_db.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT DISTINCT p FROM Post p JOIN p.comments c WHERE c.user=?1")
    List<Post> findByCommentUser(String user);
}
