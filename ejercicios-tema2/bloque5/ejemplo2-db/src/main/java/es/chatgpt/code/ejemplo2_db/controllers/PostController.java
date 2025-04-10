package es.chatgpt.code.ejemplo2_db.controllers;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

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
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import es.chatgpt.code.ejemplo2_db.models.Post;
import es.chatgpt.code.ejemplo2_db.repository.PostRepository;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository posts;

    @PostConstruct
    public void init() {
        posts.save(new Post("Laura", "Clases de guitarra", "Ofrezco clases para principiantes, horarios flexibles"));
        posts.save(new Post("Carlos", "Se busca programador",
                "Startup en crecimiento busca dev backend con experiencia en Java"));
        posts.save(new Post("Ana", "Regalo libros", "Colección de novelas clásicas, ideal para amantes de la lectura"));
    }

    @GetMapping("/")
    public Collection<Post> getPosts() {
        return posts.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable long id) {

        Optional<Post> post = posts.findById(id);
        if (post.isPresent()) {
            return ResponseEntity.ok(post.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {

        posts.save(post);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).body(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> replacePost(@RequestBody Post newPost, @PathVariable long id) {

        if (posts.existsById(id)) {
            newPost.setId(id);
            posts.save(newPost);
            return ResponseEntity.ok(newPost);
        } else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable long id) {

        Optional<Post> post = posts.findById(id);

        if (post.isPresent()) {
            posts.deleteById(id);
            return ResponseEntity.ok(post.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
