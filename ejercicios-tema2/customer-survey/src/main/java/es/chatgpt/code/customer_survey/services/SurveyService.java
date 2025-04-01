package es.chatgpt.code.customer_survey.services;

import es.chatgpt.code.customer_survey.models.SurveyResponse;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SurveyService {

    private final ConcurrentMap<Long, SurveyResponse> responses = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong();

    public void save(SurveyResponse response) {
        long id = nextId.getAndIncrement();
        response.setId(id);
        responses.put(id, response);
    }

    public Collection<SurveyResponse> findAll() {
        return responses.values();
    }

    public SurveyResponse findById(long id) {
        return responses.get(id);
    }

    public void deleteById(long id) {
        responses.remove(id);
    }

    public double getAverageRating() {
        return responses.values().stream()
                .mapToInt(SurveyResponse::getRating)
                .average()
                .orElse(0.0);
    }
}
