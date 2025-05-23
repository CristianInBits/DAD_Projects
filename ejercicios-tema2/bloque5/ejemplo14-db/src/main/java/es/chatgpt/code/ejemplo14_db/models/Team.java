package es.chatgpt.code.ejemplo14_db.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Team {

    public interface BasicAtt {
    }

    public interface PlayersAtt {
    }

    @JsonView(BasicAtt.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @JsonView(BasicAtt.class)
    private String name;

    @JsonView(BasicAtt.class)
    private int ranking;

    @JsonView(PlayersAtt.class)
    @ManyToMany(mappedBy = "teams")
    private List<Player> players = new ArrayList<>();

    protected Team() {
    }

    public Team(String name, int ranking) {
        this.name = name;
        this.ranking = ranking;
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

    public void setName(String title) {
        this.name = title;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> comments) {
        this.players = comments;
    }

    @Override
    public String toString() {
        return "Team [id=" + id + ", name=" + name + ", ranking=" + ranking + "]";
    }

}