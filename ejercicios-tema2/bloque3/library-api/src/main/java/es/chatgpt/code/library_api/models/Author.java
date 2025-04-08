package es.chatgpt.code.library_api.models;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;
import java.util.List;

public class Author {

    public interface Basic {
    }

    public interface Books {
    }

    @JsonView(Basic.class)
    private long id = -1;

    @JsonView(Basic.class)
    private String name;

    @JsonView(Basic.class)
    private String nationality;

    @JsonView(Books.class)
    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(long id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author [id=" + id + ", name=" + name + ", nationality=" + nationality + ", books=" + books + "]";
    }
}