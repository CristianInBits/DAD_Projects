package es.chatgpt.code.item_filter_api.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.item_filter_api.models.Item;
import es.chatgpt.code.item_filter_api.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public Collection<Item> getItems(@RequestParam(required = false) Double priceBelow) {
        if (priceBelow != null)
            return itemService.findByPriceBelow(priceBelow);
        else
            return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable long id) {
        Item item = itemService.findById(id);
        if (item != null)
            return ResponseEntity.ok(item);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        itemService.save(item);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable long id) {
        Item item = itemService.findById(id);
        if (item != null) {
            itemService.deleteById(id);
            return ResponseEntity.ok(item);
        } else
            return ResponseEntity.notFound().build();
    }
}
