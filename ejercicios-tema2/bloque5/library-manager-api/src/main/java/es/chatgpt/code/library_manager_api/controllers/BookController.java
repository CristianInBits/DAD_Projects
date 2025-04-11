package es.chatgpt.code.library_manager_api.controllers;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

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

import es.chatgpt.code.library_manager_api.models.Book;
import es.chatgpt.code.library_manager_api.repository.BookRepository;
import jakarta.annotation.PostConstruct;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository books;

    @PostConstruct
    public void init() {
        books.save(new Book("Hábitos atómicos", "James Clear", 5));
        books.save(new Book("Piensa rápido, piensa despacio", "Daniel Kahneman", 3));
        books.save(new Book("Los 7 hábitos de la gente altamente efectiva", "Stephen Covey", 4));
    }

    @GetMapping("/")
    public Collection<Book> getBooks() {
        return books.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable long id) {

        Optional<Book> book = books.findById(id);
        return ResponseEntity.of(book);
    }

    @GetMapping(params = "author")
    public Collection<Book> getBooksByAuthor(@RequestParam String author) {
        return books.findByAuthor(author);
    }

    @PostMapping("/")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        books.save(book);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(location).body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> replaceBook(@PathVariable long id, @RequestBody Book newBook) {

        Optional<Book> book = books.findById(id);
        return ResponseEntity.of(book.map(_ -> {
            newBook.setId(id);
            books.save(newBook);
            return newBook;
        }));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {

        Optional<Book> book = books.findById(id);
        book.ifPresent(_ -> books.deleteById(id));
        return ResponseEntity.of(book);
    }
}
