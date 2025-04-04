package es.chatgpt.code.recipe_manager.models;

public class Recipe {

    private Long id;
    private String title;
    private String author;
    private String ingredients;
    private String instructions;
    private String difficulty; // "Low", "Medium", "High"

    public Recipe() {
    }

    public Recipe(String title, String author, String ingredients, String instructions, String difficulty) {
        this.title = title;
        this.author = author;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.difficulty = difficulty;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
