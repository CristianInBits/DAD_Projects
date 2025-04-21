package es.chatgpt.code.ejemplo13_db.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.ejemplo13_db.models.Post;
import es.chatgpt.code.ejemplo13_db.repository.PostRepository;
import jakarta.annotation.PostConstruct;

@RestController
public class PostController {

    @Autowired
    private PostRepository posts;

    @PostConstruct
    public void init() {
        posts.save(new Post("Pepe", "¿Alguien vende bici?", "Busco una bicicleta de segunda mano en buen estado."));
        posts.save(
                new Post("Juan", "Recomendaciones de libros", "¿Qué novela me recomiendan para este fin de semana?"));
    }

    @GetMapping("/")
    public Collection<Post> getPosts(@RequestParam(required = false) String username) {
        if (username != null) {
            return posts.findByUsername(username);
        } else {
            return posts.findAll();
        }
    }
}
