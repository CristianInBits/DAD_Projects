package es.chatgpt.code.ejemplo10_db.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String name;
    private int ranking;
    
    @OneToMany(mappedBy = "team")
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

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "Team [id=" + id + ", name=" + name + ", ranking=" + ranking + "]";
    }
}
