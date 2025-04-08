package es.chatgpt.code.dog_api.services;

import es.chatgpt.code.dog_api.models.DogResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "dog-api", url = "https://dog.ceo/")
public interface DogService {

    @GetMapping("api/breeds/image/random")
    DogResponse getRandomDogImage();
}