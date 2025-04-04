package es.chatgpt.code.forum_service.services;

import org.springframework.stereotype.Service;

import es.chatgpt.code.forum_service.models.Post;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PostService {

    private final ConcurrentMap<Long, Post> posts = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong();

    public PostService() {
        save(new Post("Ada", "Tips de programación", "Divide y vencerás, también en tu código."));
        save(new Post("Nikola", "Energía libre", "¿Y si tu casa pudiera alimentarse sola?"));
        save(new Post("Alan", "Máquinas inteligentes", "Hoy soñamos con IA, mañana conviviremos con ella."));
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public Post findById(long id) {
        return posts.get(id);
    }

    public void save(Post post) {
        long id = nextId.getAndIncrement();
        post.setId(id);
        posts.put(id, post);
    }

    public void deleteById(long id) {
        posts.remove(id);
    }
}
