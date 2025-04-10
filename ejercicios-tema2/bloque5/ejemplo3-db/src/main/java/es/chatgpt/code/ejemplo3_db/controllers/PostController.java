package es.chatgpt.code.ejemplo3_db.controllers;

import java.net.URI;
import java.util.Collection;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

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

import es.chatgpt.code.ejemplo3_db.models.Post;
import es.chatgpt.code.ejemplo3_db.repository.PostRepository;
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
    public Post getPost(@PathVariable long id) {
        return posts.findById(id).orElseThrow();
    }

    @PostMapping("/")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {

        posts.save(post);

        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(location).body(post);
    }

    @PutMapping("/{id}")
    public Post replacePost(@PathVariable long id, @RequestBody Post newPost) {

        posts.findById(id).orElseThrow();

        newPost.setId(id);
        posts.save(newPost);

        return newPost;
    }

    @DeleteMapping("/{id}")
    public Post delePost(@PathVariable long id) {

        Post post = posts.findById(id).orElseThrow();

        posts.deleteById(id);

        return post;
    }
}
