package es.chatgpt.code.recipe_doc_api.models;

public class Recipe {

    private Long id;
    private String name;
    private String ingredients;
    private int preparationTime;

    public Recipe() {
    }

    public Recipe(Long id, String name, String ingredients, int preparationTime) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.preparationTime = preparationTime;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }
}