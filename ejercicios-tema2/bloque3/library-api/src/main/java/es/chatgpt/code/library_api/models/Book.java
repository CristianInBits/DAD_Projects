package es.chatgpt.code.library_api.models;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;
import java.util.List;

public class Book {

    public interface Basic {
    }

    public interface Authors {
    }

    @JsonView(Basic.class)
    private long id = -1;

    @JsonView(Basic.class)
    private String title;

    @JsonView(Basic.class)
    private int price;

    @JsonView(Authors.class)
    private List<Author> authors = new ArrayList<>();

    public Book() {
    }

    public Book(long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", price=" + price + ", authors=" + authors + "]";
    }
}
