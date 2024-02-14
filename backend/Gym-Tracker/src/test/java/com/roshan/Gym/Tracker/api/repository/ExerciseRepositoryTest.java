package com.roshan.Gym.Tracker.api.repository;

import com.roshan.Gym.Tracker.api.models.Exercise;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ExerciseRepositoryTest {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Test
    public void ExerciseRepository_SaveAll_ReturnSavedExercises() {
        //Arrange
        Exercise exercise = Exercise.builder().exerciseName("Ex1").description("").category("chest").build();
        //Act
        Exercise savedExercise = exerciseRepository.save(exercise);
        //Assert
        Assertions.assertThat(savedExercise).isNotNull();
        Assertions.assertThat(savedExercise.getId()).isGreaterThan(0);
    }
}
