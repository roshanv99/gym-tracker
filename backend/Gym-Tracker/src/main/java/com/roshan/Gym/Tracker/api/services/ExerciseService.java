package com.roshan.Gym.Tracker.api.services;

import com.roshan.Gym.Tracker.api.dto.ExerciseDto;
import com.roshan.Gym.Tracker.api.models.Exercise;
import com.roshan.Gym.Tracker.api.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {
    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
    public List<ExerciseDto> findAllExercises() {
        List<Exercise> exercises = exerciseRepository.findAll();
        return exercises.stream().map(ex -> mapToExerciseDto(ex)).collect(Collectors.toList());
    }

    private ExerciseDto mapToExerciseDto(Exercise exercise) {
        return ExerciseDto.builder()
                .id(exercise.getId())
                .exerciseName(exercise.getExerciseName())
                .category(exercise.getCategory())
                .description(exercise.getDescription())
                .build();
    }

    public Exercise addNewExercise(ExerciseDto exerciseDto) {
        Exercise exercise = new Exercise();
        exercise.setExerciseName(exerciseDto.getExerciseName());
        exercise.setDescription(exerciseDto.getDescription());
        exercise.setCategory(exerciseDto.getCategory());
        return exerciseRepository.save(exercise);
    }
}
