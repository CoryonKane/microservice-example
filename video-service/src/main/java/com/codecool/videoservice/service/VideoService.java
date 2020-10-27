package com.codecool.videoservice.service;

import com.codecool.recommendation.model.Recommendation;
import com.codecool.videoservice.dto.VideoWithRecommendations;
import com.codecool.videoservice.model.Video;
import com.codecool.videoservice.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class VideoService {

    private final VideoRepository videoRepository;

    private final RecommendationServiceCaller caller;

    @Autowired
    public VideoService(VideoRepository videoRepository, RecommendationServiceCaller caller) {
        this.videoRepository = videoRepository;
        this.caller = caller;
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public VideoWithRecommendations getVideoWithRec(Long id) {
        return VideoWithRecommendations.builder()
                .recommendations(caller.getAllByVideo(id))
                .video(videoRepository.getOne(id))
                .build();
    }

    public void updateVideo(Video video) {
        videoRepository.save(video);
    }

    public Recommendation saveRec (Recommendation recommendation) {
        return caller.saveRec(recommendation);
    }

}
