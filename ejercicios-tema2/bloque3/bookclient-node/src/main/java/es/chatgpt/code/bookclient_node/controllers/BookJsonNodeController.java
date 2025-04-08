package es.chatgpt.code.bookclient_node.controllers;

import es.chatgpt.code.bookclient_node.services.BookJsonNodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookJsonNodeController {

    private final BookJsonNodeService service;

    public BookJsonNodeController(BookJsonNodeService service) {
        this.service = service;
    }

    @GetMapping("/booktitles-json")
    public List<String> getTitles(@RequestParam String title) {
        return service.getBookTitles(title);
    }
}
