package es.chatgpt.code.comparativa_consultas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.comparativa_consultas.models.Post;
import es.chatgpt.code.comparativa_consultas.repository.PostRepository;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostConstruct
    public void init() {
        postRepository.save(new Post("Pepe", "¿Alguien vende bici?", "Busco una bici en buen estado"));
        postRepository.save(new Post("Juan", "Ideas de recetas", "¿Qué hacer con garbanzos?"));
    }

    // Derived method
    @GetMapping("/derived")
    public List<Post> getPosts(@RequestParam(required = false) String username) {
        if (username != null) {
            return postRepository.findByUsername(username);
        } else {
            return postRepository.findAll();
        }
    }

    // JPQL Mehtod
    @GetMapping("/jpql")
    public List<Post> getPostsJPQL(@RequestParam(required = false) String username) {
        if (username == null) {
            return postRepository.findAll(); // método de JpaRepository
        } else {
            return postRepository.getByUsername(username); // @Query
        }
    }

    @GetMapping("/jpql-optional")
    public List<Post> getPostsJPQLOptional(@RequestParam(required = false) String username) {
        return postRepository.findByUsernameOptional(username);
    }
}
