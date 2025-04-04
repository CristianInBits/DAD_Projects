package es.chatgpt.code.book_library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.chatgpt.code.book_library.services.BookService;
import es.chatgpt.code.book_library.models.Book;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/main";
    }

    @GetMapping("/books/new")
    public String showNewBookForm() {
        return "books/new";
    }

    @PostMapping("/books")
    public String saveBook(@ModelAttribute Book book, Model model) {
        bookService.save(book);
        model.addAttribute("book", book);
        return "books/book_saved";
    }

    @GetMapping("/books/{id}")
    public String showBook(Model model, @PathVariable Long id) {
        Book book = bookService.findById(id);
        if (book != null) {
            model.addAttribute("book", book);
            return "books/show";
        }
        return "redirect:/";
    }

    @GetMapping("/books/{id}/delete")
    public String deleteBook(Model model, @PathVariable Long id) {
        bookService.deleteById(id);
        model.addAttribute("id", id);
        return "books/book_deleted";
    }
}
