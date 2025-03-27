package es.chatgpt.code.forum_service.controllers;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.chatgpt.code.forum_service.models.Post;
import es.chatgpt.code.forum_service.services.PostService;

@Controller
public class PostController {

    // @Autowired
    // private PostService postService;

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String showAllPosts(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "posts/main";
    }

    @GetMapping("/posts/new")
    public String showNewPostForm() {
        return "posts/new";
    }

    @PostMapping("/posts")
    public String savePost(@ModelAttribute Post post, Model model) {
        postService.save(post);
        model.addAttribute("post", post);
        return "posts/post_saved";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "posts/show";
        }
        return "redirect:/";
    }

    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable Long id, Model model) {
        postService.deleteById(id);
        model.addAttribute("id", id);
        return "posts/post_deleted";
    }
}
