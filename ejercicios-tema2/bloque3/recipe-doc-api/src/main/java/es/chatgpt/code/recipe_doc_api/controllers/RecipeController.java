package es.chatgpt.code.recipe_doc_api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.chatgpt.code.recipe_doc_api.models.Recipe;
import es.chatgpt.code.recipe_doc_api.services.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @Operation(summary = "Get all recipes")
    @ApiResponse(responseCode = "200", description = "List of all recipes", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Recipe.class)))
    @GetMapping
    public List<Recipe> getAll() {
        return service.findAll();
    }

    @Operation(summary = "Get a recipe by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Recipe found", content = @Content(schema = @Schema(implementation = Recipe.class))),
            @ApiResponse(responseCode = "404", description = "Recipe not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getById(
            @Parameter(description = "ID of the recipe") @PathVariable Long id) {
        Recipe recipe = service.findById(id);
        return recipe != null ? ResponseEntity.ok(recipe) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new recipe")
    @ApiResponse(responseCode = "201", description = "Recipe created", content = @Content(schema = @Schema(implementation = Recipe.class)))
    @PostMapping
    public ResponseEntity<Recipe> create(@RequestBody Recipe recipe) {
        return ResponseEntity.status(201).body(service.save(recipe));
    }

    @Operation(summary = "Delete a recipe by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Recipe deleted"),
            @ApiResponse(responseCode = "404", description = "Recipe not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.deleteById(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}