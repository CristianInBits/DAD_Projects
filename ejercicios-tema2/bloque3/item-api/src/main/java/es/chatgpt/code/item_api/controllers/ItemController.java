package es.chatgpt.code.item_api.controllers;

import es.chatgpt.code.item_api.models.Item;
import es.chatgpt.code.item_api.services.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public Collection<Item> getItems() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable long id) {
        Item item = itemService.findById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        itemService.save(item);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(location).body(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> replaceItem(@PathVariable long id, @RequestBody Item newItem) {
        Item existing = itemService.findById(id);
        if (existing != null) {
            newItem.setId(id);
            itemService.save(newItem);
            return ResponseEntity.ok(newItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable long id) {
        Item item = itemService.findById(id);
        if (item != null) {
            itemService.deleteById(id);
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
