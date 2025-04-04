package es.chatgpt.code.item_api.models;

public class Item {

    private Long id;
    private String description;
    private boolean checked;

    public Item() {
    }

    public Item(String description, boolean checked) {
        this.description = description;
        this.checked = checked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
