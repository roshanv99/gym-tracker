package com.roshan.Gym.Tracker.api.repository;

import com.roshan.Gym.Tracker.api.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Optional<Exercise> findByExerciseName(String url);
}
