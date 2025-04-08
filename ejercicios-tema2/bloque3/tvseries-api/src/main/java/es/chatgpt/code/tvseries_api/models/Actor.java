package es.chatgpt.code.tvseries_api.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

public class Actor {

    public interface Basic {
    }

    public interface Series {
    }

    @JsonView(Basic.class)
    private Long id;

    @JsonView(Basic.class)
    private String name;

    @JsonView(Basic.class)
    private String nationality;

    @JsonView(Series.class)
    private List<Serie> series = new ArrayList<>();

    public Actor() {
    }

    public Actor(Long id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
