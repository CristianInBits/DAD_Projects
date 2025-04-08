package es.chatgpt.code.bookclient_model.controllers;

import es.chatgpt.code.bookclient_model.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/booktitles")
    public List<String> getBookTitles(@RequestParam String title) {
        return service.getBookTitles(title);
    }
}