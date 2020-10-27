package com.codecool.videoservice.service;

import com.codecool.recommendation.model.Recommendation;
import com.codecool.recommendation.model.RecommendationList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class RecommendationServiceCaller {
    private final RestTemplate restTemplate;

    @Value("${recommendation-service.url}")
    private String baseUrl;

    @Autowired
    public RecommendationServiceCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Recommendation> getAllByVideo (Long videoId) {
        return Objects.requireNonNull(restTemplate.getForEntity(baseUrl + "/" + videoId, RecommendationList.class).getBody()).getRecommendations();
    }

    public Recommendation saveRec(Recommendation recommendation) {
        return restTemplate.postForEntity(baseUrl + "save", recommendation, Recommendation.class).getBody();
    }

}
