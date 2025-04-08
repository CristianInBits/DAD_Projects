package es.chatgpt.code.dog_api.controllers;

import es.chatgpt.code.dog_api.models.DogResponse;
import es.chatgpt.code.dog_api.services.DogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dog-image")
    public String getDogImage() {
        DogResponse response = dogService.getRandomDogImage();
        return response.getMessage(); // Devuelve directamente la URL de la imagen
    }
}