package es.chatgpt.code.ejemplo6_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.chatgpt.code.ejemplo6_db.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
