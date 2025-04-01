package es.chatgpt.code.customer_survey.controllers;

import es.chatgpt.code.customer_survey.models.SurveyResponse;
import es.chatgpt.code.customer_survey.services.SurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/survey")
    public String showForm() {
        return "form";
    }

    @PostMapping("/survey")
    public String submitSurvey(@ModelAttribute SurveyResponse response, Model model) {
        surveyService.save(response);
        model.addAttribute("response", response);
        return "detail";
    }

    @GetMapping("/responses")
    public String listResponses(Model model) {
        model.addAttribute("responses", surveyService.findAll());
        return "responses";
    }

    @GetMapping("/responses/{id}")
    public String viewResponse(@PathVariable long id, Model model) {
        SurveyResponse response = surveyService.findById(id);
        if (response != null) {
            model.addAttribute("response", response);
            return "detail";
        }
        return "redirect:/responses";
    }

    @GetMapping("/responses/{id}/delete")
    public String deleteResponse(@PathVariable long id, Model model) {
        surveyService.deleteById(id);
        model.addAttribute("id", id);
        return "deleted";
    }

    @GetMapping("/stats")
    public String showStats(Model model) {
        model.addAttribute("average", surveyService.getAverageRating());
        return "stats";
    }
}
