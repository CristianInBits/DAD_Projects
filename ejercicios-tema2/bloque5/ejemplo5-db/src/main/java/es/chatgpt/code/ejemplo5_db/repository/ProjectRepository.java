package es.chatgpt.code.ejemplo5_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.chatgpt.code.ejemplo5_db.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}