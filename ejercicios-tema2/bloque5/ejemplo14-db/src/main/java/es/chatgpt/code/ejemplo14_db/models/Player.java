package es.chatgpt.code.ejemplo14_db.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Player {
    
    public interface BasicAtt {
    }

    public interface TeamAtt {
    }

    @JsonView(BasicAtt.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonView(BasicAtt.class)
    private String name;

    @JsonView(BasicAtt.class)
    private int goals;

    @JsonView(TeamAtt.class)
    @ManyToMany
    private List<Team> teams = new ArrayList<>();

    protected Player() {
    }

    public Player(String author, int goals) {
        super();
        this.name = author;
        this.goals = goals;
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

    public void setName(String author) {
        this.name = author;
    }

    public int getGoals() {
        return goals;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", goals=" + goals + "]";
    }
}
