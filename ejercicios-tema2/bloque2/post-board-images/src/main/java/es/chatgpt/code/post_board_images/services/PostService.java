package es.chatgpt.code.post_board_images.services;

import es.chatgpt.code.post_board_images.models.Post;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PostService {

    private final ConcurrentHashMap<Long, Post> posts = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong();

    public Collection<Post> findAll() {
        return posts.values();
    }

    public Post findById(long id) {
        return posts.get(id);
    }

    public Post save(Post post) {
        long id = nextId.getAndIncrement();
        post.setId(id);
        posts.put(id, post);
        return post;
    }

    public void deleteById(long id) {
        this.posts.remove(id);
    }
}
