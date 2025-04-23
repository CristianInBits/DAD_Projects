package es.chatgpt.code.post_pagination_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.chatgpt.code.post_pagination_web.model.Post;
import es.chatgpt.code.post_pagination_web.repository.PostRespository;
import jakarta.annotation.PostConstruct;

@Controller
@RequestMapping("/web/posts")
public class PostController {

    @Autowired
    private PostRespository postsRespository;

    @PostConstruct
    public void init() {
        postsRespository.save(new Post("Pepe", "Vendo bici", "Está como nueva"));
        postsRespository.save(new Post("Juan", "Recomendaciones", "¿Qué leer este verano?"));
        postsRespository.save(new Post("Luis", "Concierto", "Alguien va al concierto este finde?"));
        postsRespository.save(new Post("Ana", "Clases de guitarra", "Ofrezco clases particulares"));
        postsRespository.save(new Post("Mario", "Vendo coche", "Seat Ibiza 2010, buen estado"));
    }

    @GetMapping("/")
    public String listPosts(Model model, @RequestParam(required = false) String username, Pageable pageable) {

        Page<Post> page;

        if (username != null) {
            page = postsRespository.findByUsername(username, pageable);
        } else {
            page = postsRespository.findAll(pageable);
        }

        model.addAttribute("posts", page.getContent());
        model.addAttribute("page", page);
        model.addAttribute("pageNumber", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages() - 1);
        model.addAttribute("pageSize", page.getSize());
        model.addAttribute("isFirst", page.isFirst());
        model.addAttribute("isLast", page.isLast());
        model.addAttribute("prevPage", page.getNumber() - 1);
        model.addAttribute("nextPage", page.getNumber() + 1);

        return "posts";
    }

}
