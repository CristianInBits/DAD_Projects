package es.chatgpt.code.ejemplo11_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.chatgpt.code.ejemplo11_db.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}