package es.chatgpt.code.ejemplo9_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.chatgpt.code.ejemplo9_db.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
