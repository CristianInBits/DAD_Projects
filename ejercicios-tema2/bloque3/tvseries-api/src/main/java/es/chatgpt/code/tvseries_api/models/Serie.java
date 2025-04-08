package es.chatgpt.code.tvseries_api.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

public class Serie {

    public interface Basic {
    }

    public interface Actors {
    }

    @JsonView(Basic.class)
    private Long id;

    @JsonView(Basic.class)
    private String title;

    @JsonView(Basic.class)
    private int releaseYear;

    @JsonView(Actors.class)
    private List<Actor> actors = new ArrayList<>();

    public Serie() {
    }

    public Serie(Long id, String title, int releaseYear) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
    }

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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
