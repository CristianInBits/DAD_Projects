package es.chatgpt.code.recipe_manager.controllers;

import es.chatgpt.code.recipe_manager.services.RecipeService;
import es.chatgpt.code.recipe_manager.models.Recipe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public String list(Model model) {
        model.addAttribute("recipes", recipeService.findAll());
        return "recipes/list";
    }

    @GetMapping("/recipes/new")
    public String showNewForm() {
        return "recipes/new";
    }

    @PostMapping("/recipes")
    public String save(@ModelAttribute Recipe recipe, Model model) {
        recipeService.save(recipe);
        model.addAttribute("recipe", recipe);
        return "recipes/detail";
    }

    @GetMapping("/recipes/{id}")
    public String show(@PathVariable long id, Model model) {
        Recipe recipe = recipeService.findById(id);
        if (recipe != null) {
            model.addAttribute("recipe", recipe);
            return "recipes/detail";
        }
        return "redirect:/recipes";
    }

    @GetMapping("/recipes/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Recipe recipe = recipeService.findById(id);
        if (recipe != null) {
            model.addAttribute("recipe", recipe);
            return "recipes/edit";
        }
        return "redirect:/recipes";
    }

    @PostMapping("/recipes/{id}/edit")
    public String update(@PathVariable long id, @ModelAttribute Recipe recipe, Model model) {
        recipeService.update(id, recipe);
        model.addAttribute("recipe", recipe);
        return "recipes/detail";
    }

    @GetMapping("/recipes/{id}/delete")
    public String delete(@PathVariable long id, Model model) {
        recipeService.deleteById(id);
        model.addAttribute("id", id);
        return "recipes/deleted";
    }

    @GetMapping("/recipes/stats")
    public String showStats(Model model) {
        model.addAttribute("stats", recipeService.getDifficultyStats());
        return "recipes/stats";
    }
}
