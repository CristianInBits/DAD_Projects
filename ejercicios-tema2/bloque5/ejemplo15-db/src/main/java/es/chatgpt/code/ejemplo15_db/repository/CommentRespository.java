package es.chatgpt.code.ejemplo15_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.chatgpt.code.ejemplo15_db.models.Comment;

public interface CommentRespository extends JpaRepository<Comment, Long> {

}
