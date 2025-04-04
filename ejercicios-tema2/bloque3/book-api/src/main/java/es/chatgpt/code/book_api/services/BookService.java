package es.chatgpt.code.book_api.services;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import es.chatgpt.code.book_api.models.Book;

@Service
public class BookService {

    private ConcurrentMap<Long, Book> books = new ConcurrentHashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    public BookService() {
        save(new Book("1984", "George Orwell", 5));
        save(new Book("Crónica de una muerte anunciada", "Gabriel García Márquez", 4));
    }

    public Collection<Book> findAll() {
        return books.values();
    }

    public Book findById(long id) {
        return books.get(id);
    }

    public void save(Book book) {
        if (book.getId() == null || book.getId() == 0) {
            long id = nextId.getAndIncrement();
            book.setId(id);
        }

        books.put(book.getId(), book);
    }

    public void deleteById(long id) {
        books.remove(id);
    }
}
