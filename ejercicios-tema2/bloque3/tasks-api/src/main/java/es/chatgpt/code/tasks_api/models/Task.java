package es.chatgpt.code.tasks_api.models;

public class Task {
    private Long id;
    private String description;
    private boolean done;

    public Task() {
    }

    public Task(String description, boolean done) {
        this.description = description;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
