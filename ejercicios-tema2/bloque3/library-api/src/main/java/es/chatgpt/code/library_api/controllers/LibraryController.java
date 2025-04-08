package es.chatgpt.code.library_api.controllers;

import java.util.ArrayList;
import java.util.List;

import es.chatgpt.code.library_api.models.Author;
import es.chatgpt.code.library_api.models.Book;
import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/")
public class LibraryController {

    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    @PostConstruct
    public void init() {

        Book book1 = new Book(0, "The Winds of Winter", 25);
        Book book2 = new Book(1, "Clean Code", 30);
        Book book3 = new Book(2, "The Pragmatic Programmer", 28);

        books.add(book1);
        books.add(book2);
        books.add(book3);

        Author author1 = new Author(0, "George R. R. Martin", "American");
        Author author2 = new Author(1, "Robert C. Martin", "American");

        authors.add(author1);
        authors.add(author2);

        book1.getAuthors().add(author1);
        author1.getBooks().add(book1);

        book2.getAuthors().add(author2);
        author2.getBooks().add(book2);

        book3.getAuthors().add(author2);
        author2.getBooks().add(book3);
    }

    @JsonView(Book.Basic.class)
    @GetMapping("/books")
    public List<Book> getBooks() {
        return books;
    }

    @JsonView(Author.Basic.class)
    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return authors;
    }

    public interface BookDetails extends Book.Basic, Book.Authors, Author.Basic {
    }

    @JsonView(BookDetails.class)
    @GetMapping("books/{id}")
    public Book getBook(@PathVariable int id) {
        return books.get(id);
    }

    public interface AuthorDetails extends Author.Basic, Author.Books, Book.Basic {
    }

    @JsonView(AuthorDetails.class)
    @GetMapping("/authors/{id}")
    public Author getAtAuthor(@PathVariable int id) {
        return authors.get(id);
    }
}
