package es.chatgpt.code.movie_manager_db_api.controllers;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.movie_manager_db_api.models.Movie;
import es.chatgpt.code.movie_manager_db_api.repository.MovieRepository;
import jakarta.annotation.PostConstruct;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movies;

    @PostConstruct
    public void init() {
        movies.save(new Movie("The Matrix", "Wachowski", 1999));
        movies.save(new Movie("Inception", "Nolan", 2010));
    }

    @GetMapping("/")
    public Collection<Movie> getMovies() {
        return movies.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable long id) {
        return movies.findById(id).orElseThrow();
    }

    @PostMapping("/")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        movies.save(movie);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(movie.getId()).toUri();
        return ResponseEntity.created(location).body(movie);
    }

    @PutMapping("/{id}")
    public Movie replaceMovie(@PathVariable long id, @RequestBody Movie newMovie) {
        movies.findById(id).orElseThrow();
        newMovie.setId(id);
        movies.save(newMovie);
        return newMovie;
    }

    @DeleteMapping("/{id}")
    public Movie deleteMovie(@PathVariable long id) {
        Movie movie = movies.findById(id).orElseThrow();
        movies.deleteById(id);
        return movie;
    }

}
