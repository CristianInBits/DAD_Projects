package es.chatgpt.code.ejemplo21_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.chatgpt.code.ejemplo21_db.models.Comment;
import es.chatgpt.code.ejemplo21_db.models.Post;
import jakarta.annotation.PostConstruct;

@Service
public class SampleDaraService {

    @Autowired
    private PostService posts;

    @PostConstruct
    public void init() {

        Post p = new Post();
        p.setUser("Pepe");
        p.setTitle("Vendo moto de segunda mano");
        p.setText("Moto en buen estado, ideal para ciudad. Precio negociable.");

        p.addComment(new Comment("Juan", "¿En qué ciudad estás?"));
        p.addComment(new Comment("María", "¿Aún está disponible?"));

        posts.save(p);
    }

}
