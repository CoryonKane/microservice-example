package com.codecool.videoservice.controller;

import com.codecool.recommendation.model.Recommendation;
import com.codecool.videoservice.dto.VideoWithRecommendations;
import com.codecool.videoservice.model.Video;
import com.codecool.videoservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoController {

    private final VideoService service;

    @Autowired
    public VideoController(VideoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Video> getAllVideos() {
        return service.getAllVideos();
    }

    @GetMapping("/{id}")
    public VideoWithRecommendations getVideo (@PathVariable("id") Long id) {
        return service.getVideoWithRec(id);
    }

    @PostMapping("/update")
    public VideoWithRecommendations updateVideo (@RequestBody Video video) {
        service.updateVideo(video);
        return service.getVideoWithRec(video.getId());
    }

    @PostMapping("/save-rec")
    public Recommendation saveRec (@RequestBody Recommendation recommendation) {
        return service.saveRec(recommendation);
    }
}
