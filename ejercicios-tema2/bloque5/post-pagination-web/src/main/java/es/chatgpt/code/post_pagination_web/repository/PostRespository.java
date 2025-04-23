package es.chatgpt.code.post_pagination_web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.chatgpt.code.post_pagination_web.model.Post;

public interface PostRespository extends JpaRepository<Post, Long> {

    Page<Post> findByUsername(String username, Pageable page);
}
