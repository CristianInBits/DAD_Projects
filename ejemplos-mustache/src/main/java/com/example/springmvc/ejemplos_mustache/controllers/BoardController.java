package com.example.springmvc.ejemplos_mustache.controllers;

import java.util.ArrayList;
import java.util.List;
import com.example.springmvc.ejemplos_mustache.models.Post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    private List<Post> posts = new ArrayList<>();
    private long nextId = 1;

    @GetMapping("/")
    public String showBoard(Model model) {
        model.addAttribute("posts", posts);
        return "board/main_board";
    }

    @GetMapping("/post/{id}")
    public String showPost(@PathVariable long id, Model model) {
        Post post = posts.stream()
                         .filter(p -> p.getId() == id)
                         .findFirst()
                         .orElse(null);

        model.addAttribute("post", post);
        return "board/show_post";
    }

    @GetMapping("/new-post")
    public String showNewPostForm() {
        return "board/new_post";
    }

    @PostMapping("/save-post")
    public String savePost(Post post, Model model) {
        post.setId(nextId++);
        posts.add(post);
        model.addAttribute("post", post);
        return "board/post_saved";
    }

    @GetMapping("/delete-post/{id}")
    public String deletePost(@PathVariable long id) {
        posts.removeIf(p -> p.getId() == id);
        return "redirect:/";
    }
}
