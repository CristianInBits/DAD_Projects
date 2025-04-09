package es.chatgpt.code.post_image_api.controllers;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.IOException;
import java.net.*;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import es.chatgpt.code.post_image_api.models.Post;
import es.chatgpt.code.post_image_api.services.ImageService;
import es.chatgpt.code.post_image_api.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

    private static final String POSTS_FOLDER = "posts";

    @Autowired
    private PostService postService;
    @Autowired
    private ImageService imageService;

    @GetMapping("/")
    public Collection<Post> getPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable long id) {
        Post post = postService.findById(id);
        return (post != null) ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        postService.save(post);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).body(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> replacePost(@PathVariable long id, @RequestBody Post newPost) {
        Post existing = postService.findById(id);
        if (existing != null) {
            newPost.setId(id);
            postService.save(newPost);
            return ResponseEntity.ok(newPost);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable long id) throws IOException {
        Post post = postService.findById(id);
        if (post != null) {
            postService.deleteById(id);
            if (post.getImage() != null) {
                imageService.deleteImage(POSTS_FOLDER, id);
            }
            return ResponseEntity.ok(post);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<Object> uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile)
            throws IOException {
        Post post = postService.findById(id);
        if (post != null) {
            URI location = fromCurrentRequest().build().toUri();
            post.setImage(location.toString());
            postService.save(post);
            imageService.saveImage(POSTS_FOLDER, post.getId(), imageFile);
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws MalformedURLException {
        return imageService.createResponseFromImage(POSTS_FOLDER, id);
    }

    @DeleteMapping("/{id}/image")
    public ResponseEntity<Object> deleteImage(@PathVariable long id) throws IOException {
        Post post = postService.findById(id);
        if (post != null) {
            post.setImage(null);
            postService.save(post);
            imageService.deleteImage(POSTS_FOLDER, id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}