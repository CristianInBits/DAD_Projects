package es.chatgpt.code.recipe_api.services;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import es.chatgpt.code.recipe_api.models.Recipe;;

@Service
public class RecipeService {

    private final ConcurrentMap<Long, Recipe> recipes = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong();

    public RecipeService() {
        save(new Recipe("Spaghetti Carbonara", "Pasta, Eggs, Bacon", "Mix all together", 20));
        save(new Recipe("Pancakes", "Flour, Milk, Eggs", "Mix and fry", 15));
    }

    public Collection<Recipe> findAll() {
        return recipes.values();
    }

    public Recipe findById(long id) {
        return recipes.get(id);
    }

    public void save(Recipe recipe) {
        if (recipe.getId() == null || recipe.getId() == 0) {
            recipe.setId(nextId.getAndIncrement());
        }
        recipes.put(recipe.getId(), recipe);
    }

    public void deleteById(long id) {
        recipes.remove(id);
    }
}
