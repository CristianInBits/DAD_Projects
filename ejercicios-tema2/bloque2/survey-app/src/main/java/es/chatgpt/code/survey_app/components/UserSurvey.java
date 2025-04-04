package es.chatgpt.code.survey_app.components;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSurvey {

    private String name;
    private String liked;
    private int rating;
    private String comment;

    public String getName() {
        return name;
    }

    public String getLiked() {
        return liked;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLiked(String liked) {
        this.liked = liked;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
