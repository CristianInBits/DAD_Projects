package es.chatgpt.code.item_filter_api.models;

public class Item {

    private Long id;
    private String itemName;
    private double price;
    private boolean checked;

    public Item() {
    }

    public Item(String itemName, double price, boolean checked) {
        this.itemName = itemName;
        this.price = price;
        this.checked = checked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
