package es.chatgpt.code.recipe_manager.services;

import es.chatgpt.code.recipe_manager.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class RecipeService {

    private final Map<Long, Recipe> recipes = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong();

    public RecipeService() {
        save(new Recipe("Paella", "Luis", "Arroz, marisco, verduras", "Cocer, sofreír y mezclar", "High"));
        save(new Recipe("Tostadas", "Ana", "Pan, mantequilla", "Tostar y untar", "Low"));
    }

    public void save(Recipe recipe) {
        long id = nextId.getAndIncrement();
        recipe.setId(id);
        recipes.put(id, recipe);
    }

    public Collection<Recipe> findAll() {
        return recipes.values();
    }

    public Recipe findById(long id) {
        return recipes.get(id);
    }

    public void update(long id, Recipe updated) {
        updated.setId(id);
        recipes.put(id, updated);
    }

    public void deleteById(long id) {
        recipes.remove(id);
    }

    public Map<String, Long> getDifficultyStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("Low", 0L);
        stats.put("Medium", 0L);
        stats.put("High", 0L);

        for (Recipe r : recipes.values()) {
            stats.put(r.getDifficulty(), stats.get(r.getDifficulty()) + 1);
        }

        return stats;
    }
}