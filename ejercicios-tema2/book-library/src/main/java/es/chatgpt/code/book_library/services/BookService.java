package es.chatgpt.code.book_library.services;

import es.chatgpt.code.book_library.models.Book;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final ConcurrentMap<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong();

    public BookService() {
        save(new Book("Los hermanos Karamazov", "Fiódor Dostoyevski", "Novela filosófica compleja", 1880));
        save(new Book("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico con generaciones inolvidables", 1967));
        save(new Book("Juego de Tronos", "George R. R. Martin", "Intrigas, dragones y política medieval", 1996));
    }

    public Collection<Book> findAll() {
        return books.values();
    }

    public Book findById(long id) {
        return books.get(id);
    }

    public void save(Book book) {
        long id = nextId.getAndIncrement();
        book.setId(id);
        books.put(id, book);
    }

    public boolean deleteById(long id) {
        return books.remove(id) != null;
    }
}