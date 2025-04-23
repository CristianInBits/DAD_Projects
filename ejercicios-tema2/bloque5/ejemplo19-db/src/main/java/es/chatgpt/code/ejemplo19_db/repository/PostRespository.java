package es.chatgpt.code.ejemplo19_db.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.chatgpt.code.ejemplo19_db.models.Post;

public interface PostRespository extends JpaRepository<Post, Long> {
    
    Page<Post> findByUsername(String username, Pageable page);

    Page<Post> findByTitle(String title, Pageable page);
}
