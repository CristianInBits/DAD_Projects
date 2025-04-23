package es.chatgpt.code.post_pagination_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.chatgpt.code.post_pagination_web.model.Post;
import es.chatgpt.code.post_pagination_web.repository.PostRespository;
import jakarta.annotation.PostConstruct;

@Controller
@RequestMapping("/web/posts")
public class PostController {

    @Autowired
    private PostRespository posts;

    @PostConstruct
    public void init() {
        posts.save(new Post("Pepe", "Vendo bici", "Está como nueva"));
        posts.save(new Post("Juan", "Recomendaciones", "¿Qué leer este verano?"));
        posts.save(new Post("Luis", "Concierto", "Alguien va al concierto este finde?"));
        posts.save(new Post("Ana", "Clases de guitarra", "Ofrezco clases particulares"));
        posts.save(new Post("Mario", "Vendo coche", "Seat Ibiza 2010, buen estado"));
    }

    @GetMapping("/")
    public String listPosts(Model model, Pageable pageable) {

        Page<Post> page = posts.findAll(pageable);

        model.addAttribute("posts", page.getContent());
        model.addAttribute("page", page);
        model.addAttribute("pageNumber", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("pageSize", page.getSize());
        model.addAttribute("isFirst", page.isFirst());
        model.addAttribute("isLast", page.isLast());
        model.addAttribute("prevPage", page.getNumber() - 1);
        model.addAttribute("nextPage", page.getNumber() + 1);

        return "posts";
    }

}
