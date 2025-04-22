package es.chatgpt.code.ejemplo18_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.chatgpt.code.ejemplo18_db.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByUsername(String username, Pageable page);

    Page<Post> findByTitle(String title, Pageable page);

}
