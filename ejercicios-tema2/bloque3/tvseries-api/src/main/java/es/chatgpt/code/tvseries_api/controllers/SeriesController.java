package es.chatgpt.code.tvseries_api.controllers;

import java.util.ArrayList;
import java.util.List;

import es.chatgpt.code.tvseries_api.models.Actor;
import es.chatgpt.code.tvseries_api.models.Serie;
import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class SeriesController {

    private List<Serie> seriesList = new ArrayList<>();
    private List<Actor> actorList = new ArrayList<>();

    @PostConstruct
    public void init() {
        Serie serie1 = new Serie(0L, "Planet Earth", 2006);
        Serie serie2 = new Serie(1L, "Breaking Bad", 2008);
        Serie serie3 = new Serie(2L, "Dark", 2017);

        seriesList.add(serie1);
        seriesList.add(serie2);
        seriesList.add(serie3);

        Actor actor1 = new Actor(0L, "David Attenborough", "UK");
        Actor actor2 = new Actor(1L, "Bryan Cranston", "USA");
        Actor actor3 = new Actor(2L, "Louis Hofmann", "Germany");

        actorList.add(actor1);
        actorList.add(actor2);
        actorList.add(actor3);

        serie1.getActors().add(actor1);
        actor1.getSeries().add(serie1);

        serie2.getActors().add(actor2);
        actor2.getSeries().add(serie2);

        serie3.getActors().add(actor3);
        actor3.getSeries().add(serie3);
    }

    @JsonView(Serie.Basic.class)
    @GetMapping("/series")
    public List<Serie> getAllSeries() {
        return seriesList;
    }

    interface SerieDetail extends Serie.Basic, Serie.Actors, Actor.Basic {
    }

    @JsonView(SerieDetail.class)
    @GetMapping("/series/{id}")
    public Serie getSerie(@PathVariable int id) {
        return seriesList.get(id);
    }

    @JsonView(Actor.Basic.class)
    @GetMapping("/actors")
    public List<Actor> getAllActors() {
        return actorList;
    }

    interface ActorDetail extends Actor.Basic, Actor.Series, Serie.Basic {
    }

    @JsonView(ActorDetail.class)
    @GetMapping("/actors/{id}")
    public Actor getActor(@PathVariable int id) {
        return actorList.get(id);
    }
}
