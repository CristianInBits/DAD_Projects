package es.chatgpt.code.bookclient_model.services;

import es.chatgpt.code.bookclient_model.models.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public List<String> getBookTitles(String title) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + title;

        RestTemplate restTemplate = new RestTemplate();
        BookResponse response = restTemplate.getForObject(url, BookResponse.class);

        List<String> titles = new ArrayList<>();
        if (response != null && response.items != null) {
            for (Book book : response.items) {
                titles.add(book.volumeInfo.title);
            }
        }
        return titles;
    }
}