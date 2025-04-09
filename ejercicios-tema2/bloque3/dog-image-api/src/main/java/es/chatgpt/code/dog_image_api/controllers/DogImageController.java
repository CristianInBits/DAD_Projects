package es.chatgpt.code.dog_image_api.controllers;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.dog_image_api.services.DogImageService;

@RestController
public class DogImageController {

    @Autowired
    private DogImageService service;

    @GetMapping("/dog-image/save")
    public Map<String, String> saveDogImageLocally() throws IOException {
        String localPath = service.downloadAndSaveRandomImage();
        return Map.of("savedImagePath", localPath);
    }

    
}
