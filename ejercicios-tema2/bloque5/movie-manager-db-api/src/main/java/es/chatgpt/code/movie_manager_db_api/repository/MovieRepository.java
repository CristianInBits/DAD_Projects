package es.chatgpt.code.movie_manager_db_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.chatgpt.code.movie_manager_db_api.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
