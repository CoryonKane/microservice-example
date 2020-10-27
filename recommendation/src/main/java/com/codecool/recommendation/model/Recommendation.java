package com.codecool.recommendation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recommendation {
    @Id
    @GeneratedValue
    private Long id;
    private Integer rating;
    private String comment;
    private Long videoId;
}
