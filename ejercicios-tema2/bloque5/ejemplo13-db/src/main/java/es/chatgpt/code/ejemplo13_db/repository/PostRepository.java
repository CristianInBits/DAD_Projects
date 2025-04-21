package es.chatgpt.code.ejemplo13_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.chatgpt.code.ejemplo13_db.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    
    List<Post> findByUsername(String username);

    List<Post> findByTitle(String title);
}
