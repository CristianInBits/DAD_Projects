package es.chatgpt.code.pagination10_posts_db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.pagination10_posts_db.models.Post;
import es.chatgpt.code.pagination10_posts_db.repository.PostRepository;
import jakarta.annotation.PostConstruct;

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
        posts.save(new Post("Ana", "Alquilo habitación", "Centro ciudad, cerca de metro. 350€/mes."));
        posts.save(new Post("Luis", "Clases de guitarra", "Profesor titulado con experiencia."));
        posts.save(new Post("Clara", "Donación de libros", "Colección completa de novela histórica."));
        posts.save(new Post("Mario", "Trueque de videojuegos", "Cambio PS4 por Nintendo Switch."));
        posts.save(new Post("Sara", "Busco compañero de piso", "Zona universitaria. Ambiente tranquilo."));
        posts.save(new Post("Andrés", "Venta de bicicleta", "Bicicleta de montaña, poco uso."));
        posts.save(new Post("Lucía", "Clases de inglés", "Online y presencial. Todos los niveles."));
        posts.save(new Post("Carlos", "Ofrezco empleo", "Puesto de desarrollador backend. Spring Boot."));
    }

    @GetMapping("/")
    public Page<Post> getPosts(@RequestParam(required = false) String username, Pageable page) {
        if (username != null) {
            return posts.findByUsername(username, page);
        } else {
            return posts.findAll(page);
        }
    }
}
