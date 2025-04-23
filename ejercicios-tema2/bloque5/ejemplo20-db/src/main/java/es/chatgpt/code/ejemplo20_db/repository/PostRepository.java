package es.chatgpt.code.ejemplo20_db.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.chatgpt.code.ejemplo20_db.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByUser(String user, Pageable page);

    Page<Post> findByTitle(String title, Pageable page);
}