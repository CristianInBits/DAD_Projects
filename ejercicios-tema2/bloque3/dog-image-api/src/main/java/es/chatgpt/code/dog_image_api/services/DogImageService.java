package es.chatgpt.code.dog_image_api.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.chatgpt.code.dog_image_api.models.DogImageResponse;

@Service
public class DogImageService {

    private static final Path IMAGES_FOLDER = Paths.get(System.getProperty("user.dir"), "images", "random");

    public String downloadAndSaveRandomImage() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        DogImageResponse response = restTemplate.getForObject("https://dog.ceo/api/breeds/image/random",
                DogImageResponse.class);

        if (response != null && response.getStatus().equals("success")) {
            String imageUrl = response.getMessage();
            String fileName = "image-" + UUID.randomUUID() + ".jpg";
            Files.createDirectories(IMAGES_FOLDER);

            Path imagePath = IMAGES_FOLDER.resolve(fileName);

            try (InputStream in = new URL(imageUrl).openStream()) {
                Files.copy(in, imagePath, StandardCopyOption.REPLACE_EXISTING);
            }

            return imagePath.toString();
        }
        throw new IOException("Failed to retrieve image from dog.ceo");
    }
}
