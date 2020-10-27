package com.codecool.recommendation.controller;

import com.codecool.recommendation.model.Recommendation;
import com.codecool.recommendation.model.RecommendationList;
import com.codecool.recommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

    private final RecommendationService service;

    @Autowired
    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @GetMapping("/{videoId}")
    public RecommendationList getAllRecByVideo (@PathVariable("videoId") Long videoId) {
        return service.getAllByVideo(videoId);
    }

    @PostMapping("/save")
    public Recommendation addRec (@RequestBody Recommendation recommendation) {
        service.saveRec(recommendation);
        return recommendation;
    }

}
