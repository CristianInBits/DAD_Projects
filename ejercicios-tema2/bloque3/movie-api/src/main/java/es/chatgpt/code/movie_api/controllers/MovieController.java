package es.chatgpt.code.movie_api.controllers;

import es.chatgpt.code.movie_api.models.Movie;
import es.chatgpt.code.movie_api.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/")
    public Collection<Movie> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@PathVariable long id) {
        Movie movie = service.findById(id);
        if (movie != null)
            return ResponseEntity.ok(movie);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {
        service.save(movie);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(movie.getId()).toUri();
        return ResponseEntity.created(location).body(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable long id, @RequestBody Movie updated) {
        Movie existing = service.findById(id);
        if (existing != null) {
            updated.setId(id);
            service.save(updated);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> delete(@PathVariable long id) {
        Movie movie = service.findById(id);
        if (movie != null) {
            service.deleteById(id);
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
