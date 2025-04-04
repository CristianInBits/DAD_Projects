package es.chatgpt.code.book_api.controllers;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import es.chatgpt.code.book_api.services.BookService;
import es.chatgpt.code.book_api.models.Book;

@RestController
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/books/")
    public Collection<Book> getBooks() {
        return service.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable long id) {
        Book book = service.findById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/books/")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        service.save(book);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(location).body(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book newBook) {
        Book old = service.findById(id);
        if (old != null) {
            newBook.setId(id);
            service.save(newBook);
            return ResponseEntity.ok(newBook);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {
        Book book = service.findById(id);
        if (book != null) {
            service.deleteById(id);
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }
}
