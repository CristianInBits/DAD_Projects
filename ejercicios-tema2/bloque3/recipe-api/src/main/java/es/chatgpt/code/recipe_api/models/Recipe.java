package es.chatgpt.code.recipe_api.models;

public class Recipe {

    private Long id;
    private String title;
    private String ingredients;
    private String instructions;
    private int readyInMinutes;

    public Recipe() {
    }

    public Recipe(String title, String ingredients, String instructions, int readyInMinutes) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.readyInMinutes = readyInMinutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
