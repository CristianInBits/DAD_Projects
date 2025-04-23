package es.chatgpt.code.ejemplo21_db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.chatgpt.code.ejemplo21_db.models.Post;
import es.chatgpt.code.ejemplo21_db.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository posts;

    public void save(Post post) {
        posts.save(post);
    }

    public List<Post> findAll() {
        return posts.findAll();
    }

    public List<Post> findByCommentUser(String commentUser) {
        return posts.findByCommentUser(commentUser);
    }

    public Optional<Post> findById(long id) {
        return posts.findById(id);
    }

    /**
     * Only atomic attributes are updated
     * 
     * @param updatedPost
     */
    public void replace(Post updatedPost) {
        Post post = posts.findById(updatedPost.getId()).orElseThrow();
        post.getComments().forEach(c -> updatedPost.addComment(c));
        posts.save(updatedPost);
    }

    public void deleteById(long id) {
        posts.deleteById(id);
    }
}
