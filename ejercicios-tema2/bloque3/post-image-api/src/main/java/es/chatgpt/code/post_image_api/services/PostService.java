package es.chatgpt.code.post_image_api.services;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import es.chatgpt.code.post_image_api.models.Post;

@Service
public class PostService {

    private ConcurrentMap<Long, Post> posts = new ConcurrentHashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    public PostService() {
        save(new Post("Ana", "Selling guitar", "Almost new, barely used"));
        save(new Post("Luis", "Buying laptop", "Looking for a gaming laptop"));
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public Post findById(long id) {
        return posts.get(id);
    }

    public void save(Post post) {
        if (post.getId() == null || post.getId() == 0) {
            long id = nextId.getAndIncrement();
            post.setId(id);
        }
        posts.put(post.getId(), post);
    }

    public void deleteById(long id) {
        posts.remove(id);
    }
}