package es.chatgpt.code.ejemplo7_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.chatgpt.code.ejemplo7_db.models.Project;;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}