package com.codecool.videoservice.dto;

import com.codecool.recommendation.model.Recommendation;
import com.codecool.videoservice.model.Video;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoWithRecommendations {

    private Video video;
    private List<Recommendation> recommendations;

}
