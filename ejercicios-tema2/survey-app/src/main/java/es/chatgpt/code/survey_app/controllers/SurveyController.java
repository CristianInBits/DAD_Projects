package es.chatgpt.code.survey_app.controllers;

import es.chatgpt.code.survey_app.components.UserSurvey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SurveyController {

    private final UserSurvey userSurvey;
    private int totalSurveys = 0; // compartido entre todos

    public SurveyController(UserSurvey userSurvey) {
        this.userSurvey = userSurvey;
    }

    @GetMapping("/survey")
    public String showSurveyForm() {
        return "form";
    }

    @PostMapping("/survey")
    public String processSurvey(
            @RequestParam String name,
            @RequestParam String liked,
            @RequestParam int rating,
            @RequestParam String comment) {
        userSurvey.setName(name);
        userSurvey.setLiked(liked);
        userSurvey.setRating(rating);
        userSurvey.setComment(comment);

        totalSurveys++;

        return "redirect:/summary";
    }

    @GetMapping("/summary")
    public String showSummary(Model model) {
        model.addAttribute("survey", userSurvey);
        model.addAttribute("total", totalSurveys);
        return "thank_you";
    }
}
