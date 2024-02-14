package com.roshan.Gym.Tracker.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExerciseDto {
    private Long id;
    private String exerciseName;
    private String category;
    private String description;
}
