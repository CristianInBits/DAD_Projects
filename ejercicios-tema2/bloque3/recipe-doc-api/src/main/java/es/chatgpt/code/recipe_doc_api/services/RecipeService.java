package es.chatgpt.code.recipe_doc_api.services;

import org.springframework.stereotype.Service;

import es.chatgpt.code.recipe_doc_api.models.Recipe;

import java.util.*;

@Service
public class RecipeService {

    private final Map<Long, Recipe> recipes = new HashMap<>();
    private long nextId = 1;

    public RecipeService() {
        save(new Recipe(null, "Pasta", "Pasta, tomato, garlic", 15));
        save(new Recipe(null, "Omelette", "Eggs, salt, pepper", 5));
    }

    public List<Recipe> findAll() {
        return new ArrayList<>(recipes.values());
    }

    public Recipe findById(Long id) {
        return recipes.get(id);
    }

    public Recipe save(Recipe recipe) {
        if (recipe.getId() == null) {
            recipe.setId(nextId++);
        }
        recipes.put(recipe.getId(), recipe);
        return recipe;
    }

    public boolean deleteById(Long id) {
        return recipes.remove(id) != null;
    }
}