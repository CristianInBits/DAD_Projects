package es.chatgpt.code.recipe_api.controllers;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.recipe_api.models.Recipe;
import es.chatgpt.code.recipe_api.services.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService service;

    @GetMapping("/")
    public Collection<Recipe> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getById(@PathVariable long id) {
        Recipe recipe = service.findById(id);
        if (recipe != null) {
            return ResponseEntity.ok(recipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Recipe> create(@RequestBody Recipe recipe) {
        service.save(recipe);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(recipe.getId()).toUri();
        return ResponseEntity.created(location).body(recipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> replace(@PathVariable long id, @RequestBody Recipe newRecipe) {
        Recipe old = service.findById(id);
        if (old != null) {
            newRecipe.setId(id);
            service.save(newRecipe);
            return ResponseEntity.ok(newRecipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable long id) {
        Recipe recipe = service.findById(id);
        if (recipe != null) {
            service.deleteById(id);
            return ResponseEntity.ok(recipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
