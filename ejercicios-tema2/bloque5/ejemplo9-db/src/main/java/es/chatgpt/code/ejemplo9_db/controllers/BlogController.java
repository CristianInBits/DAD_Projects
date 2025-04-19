package es.chatgpt.code.ejemplo9_db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.ejemplo9_db.models.Blog;
import es.chatgpt.code.ejemplo9_db.models.Comment;
import es.chatgpt.code.ejemplo9_db.repository.BlogRepository;
import es.chatgpt.code.ejemplo9_db.repository.CommentRepository;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CommentRepository commentRepository;

    @PostConstruct
    public void init() {

        Blog blog = new Blog("Spring Tips", "Exploring hidden gems in Spring Boot");
        blog.getComments().add(new Comment("Great tips, thanks!", "Laura"));
        blog.getComments().add(new Comment("Please cover Spring Security next!", "Carlos"));
        blog.getComments().add(new Comment("Loved the part about @ControllerAdvice", "Marta"));

        blogRepository.save(blog);
    }

    @GetMapping("/blogs/")
    public List<Blog> getBlogs() throws Exception {
        return blogRepository.findAll();
    }

    // Deleting a blog delete its associated comments
    @DeleteMapping("/blogs/{id}")
    public Blog deleteBlog(@PathVariable Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow();
        blogRepository.deleteById(id);
        return blog;
    }

    // A comment only can be deleted if it has no associated blog
    // This method doesn't work
    @DeleteMapping("/comments/{id}")
    public Comment deleteComment(@PathVariable Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow();
        commentRepository.deleteById(id);
        return comment;
    }

    @DeleteMapping("/blog/{blogId}/comments/{commentId}")
    public Comment deleteComment(@PathVariable Long blogId, @PathVariable Long commentId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        blog.getComments().remove(comment);
        commentRepository.deleteById(commentId);
        return comment;
    }
}
