package es.chatgpt.code.bookclient_node.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookJsonNodeService {

    public List<String> getBookTitles(String title) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + title;

        RestTemplate restTemplate = new RestTemplate();
        JsonNode root = restTemplate.getForObject(url, JsonNode.class);

        List<String> titles = new ArrayList<>();

        if (root != null && root.has("items")) {
            ArrayNode items = (ArrayNode) root.get("items");
            for (JsonNode item : items) {
                String bookTitle = item.get("volumeInfo").get("title").asText();
                titles.add(bookTitle);
            }
        }

        return titles;
    }
}
