package com.roshan.Gym.Tracker.api.controllers;

import com.roshan.Gym.Tracker.api.dto.ExerciseDto;
import com.roshan.Gym.Tracker.api.models.Exercise;
import com.roshan.Gym.Tracker.api.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    private ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping()
    public ResponseEntity listExercises() {
        List<ExerciseDto> exercises = exerciseService.findAllExercises();
        return new ResponseEntity(exercises, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity addNewExercise(@RequestBody ExerciseDto exerciseDto) {
        return  new ResponseEntity<>(exerciseService.addNewExercise(exerciseDto), HttpStatus.CREATED);
    }
}
