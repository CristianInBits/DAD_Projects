package es.chatgpt.code.movie_api.services;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import es.chatgpt.code.movie_api.models.Movie;

@Service
public class MovieService {

    private ConcurrentMap<Long, Movie> movies = new ConcurrentHashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    public MovieService() {
        save(new Movie("The Shawshank Redemption", "Frank Darabont", "Drama", 1994));
        save(new Movie("Inception", "Christopher Nolan", "Sci-Fi", 2010));
    }

    public Collection<Movie> findAll() {
        return movies.values();
    }

    public Movie findById(long id) {
        return movies.get(id);
    }

    public void save(Movie movie) {
        if (movie.getId() == null || movie.getId() == 0) {
            long id = nextId.getAndIncrement();
            movie.setId(id);
        }
        movies.put(movie.getId(), movie);
    }

    public void deleteById(long id) {
        movies.remove(id);
    }
}
