package es.chatgpt.code.forumApplication.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.chatgpt.code.forumApplication.models.Post;

@Controller
public class PostController {

    private final List<Post> posts = new ArrayList<>();
    private long nextId = 1;

    public PostController() {
        posts.add(new Post(nextId++, "post1", "author1", "content1"));
        posts.add(new Post(nextId++, "post2", "author2", "content2"));
    }

    @GetMapping("/")
    public String showAllPosts(Model model) {
        model.addAttribute("posts", posts);
        return "posts/main";
    }

    @GetMapping("/posts/new")
    public String showNewPostForm() {
        return "posts/new";
    }

    @PostMapping("/posts")
    public String savePost(@ModelAttribute Post post, Model model) {
        post.setId(nextId++);
        posts.add(post);
        model.addAttribute("post", post);
        return "posts/post_saved";
    }

    @GetMapping("/posts/{id}")
    public String showPost(Model model, @PathVariable long id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                model.addAttribute("post", post);
                return "posts/show";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id, Model model) {
        posts.removeIf(p -> p.getId() == id);
        model.addAttribute("id", id);
        return "posts/post_deleted";
    }
}
