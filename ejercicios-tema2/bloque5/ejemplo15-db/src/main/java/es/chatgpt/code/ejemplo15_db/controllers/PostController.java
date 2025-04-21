package es.chatgpt.code.ejemplo15_db.controllers;

import java.net.URI;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.ejemplo15_db.models.Comment;
import es.chatgpt.code.ejemplo15_db.models.Post;
import es.chatgpt.code.ejemplo15_db.repository.CommentRespository;
import es.chatgpt.code.ejemplo15_db.repository.PostRepository;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRespository commentRespository;

    @PostConstruct
    public void init() {

        Post p = new Post();
        p.setUsername("Pepe");
        p.setTitle("Vendo moto de segunda mano");
        p.setText("Moto en buen estado, ideal para ciudad. Precio negociable.");

        p.addComment(new Comment("Juan", "¿En qué ciudad estás?"));
        p.addComment(new Comment("María", "¿Aún está disponible?"));

        postRepository.save(p);
    }

    @GetMapping("/")
    public Iterable<Post> getPosts(@RequestParam(required = false) String commentsUser) {
        if (commentsUser == null) {
            return postRepository.findAll();
        } else {
            return postRepository.findByCommentsUser(commentsUser);
        }
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable long id) {
        return postRepository.findById(id).orElseThrow();
    }

    @PostMapping("/")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        postRepository.save(post);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).body(post);
    }

    @PutMapping("/{id}")
    public Post replacePost(@PathVariable long id, @RequestBody Post newPost) {
        Post post = postRepository.findById(id).orElseThrow();
        newPost.setId(id);
        // We assume that comments are not updated with PUT operation
        post.getComments().forEach(c -> newPost.addComment(c));
        postRepository.save(newPost);
        return newPost;
    }

    @DeleteMapping("/{id}")
    public Post deletePost(@PathVariable long id) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.deleteById(id);
        return post;
    }

    @GetMapping("/{idPost}/comments/{idComment}")
    public Comment getComment(@PathVariable long idPost, @PathVariable long idComment) {
        return commentRespository.findById(idComment).orElseThrow();
    }

    @PostMapping("/{idPost}/comments/")
    public ResponseEntity<Comment> addComment(@PathVariable long idPost, @RequestBody Comment comment) {
        Post post = postRepository.findById(idPost).orElseThrow();
        comment.setPost(post);
        commentRespository.save(comment);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(comment.getId()).toUri();
        return ResponseEntity.created(location).body(comment);
    }

    @PutMapping("/{idPost}/comments/{idComment}")
    public Comment replaceComment(@PathVariable long idPost, @PathVariable long idComment,
            @RequestBody Comment updatedComment) {
        Comment comment = commentRespository.findById(idComment).orElseThrow();
        updatedComment.setId(idComment);
        updatedComment.setPost(comment.getPost());
        return updatedComment;
    }

    @DeleteMapping("/{idPost}/comments/{idComment}")
    public Comment deleteComment(@PathVariable long idPost, @PathVariable long idComment) {
        Comment comment = commentRespository.findById(idComment).orElseThrow();
        commentRespository.delete(comment);
        return comment;
    }

}
