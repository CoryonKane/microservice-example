package com.codecool.recommendation.service;

import com.codecool.recommendation.model.Recommendation;
import com.codecool.recommendation.model.RecommendationList;
import com.codecool.recommendation.repository.RecommendationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RecommendationService {
    private final RecommendationRepository repository;

    @Autowired
    public RecommendationService(RecommendationRepository repository) {
        this.repository = repository;
    }

    public RecommendationList getAllByVideo(Long videoId) {
        return new RecommendationList(repository.findAllByVideoId(videoId));
    }

    public void saveRec(Recommendation recommendation) {
        repository.save(recommendation);
    }

}
