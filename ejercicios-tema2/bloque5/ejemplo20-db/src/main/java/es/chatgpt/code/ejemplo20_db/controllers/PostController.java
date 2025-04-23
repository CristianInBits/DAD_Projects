package es.chatgpt.code.ejemplo20_db.controllers;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.ejemplo20_db.models.Post;
import es.chatgpt.code.ejemplo20_db.repository.PostRepository;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository posts;

    @PostConstruct
    public void init() {
        posts.save(new Post("Pepe", "Vendo coche usado", "Modelo 2012, buen estado. Precio negociable."));
        posts.save(
                new Post("Juan", "Busco portátil", "Necesito un portátil para clases, preferiblemente i5 o superior."));
    }

    @GetMapping("/")
    public Page<Post> getPosts(@RequestParam(required = false) String user, Pageable page) {

        if (user != null) {
            return posts.findByUser(user, page);
        } else {
            return posts.findAll(page);
        }
    }
}