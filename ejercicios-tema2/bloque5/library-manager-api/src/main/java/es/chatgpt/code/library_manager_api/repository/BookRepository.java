package es.chatgpt.code.library_manager_api.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import es.chatgpt.code.library_manager_api.models.Book;;

public interface BookRepository extends JpaRepository<Book, Long> {
    Collection<Book> findByAuthor(String author);
}
