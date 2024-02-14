package com.roshan.Gym.Tracker.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Automatically generates getter and setter
@NoArgsConstructor //Automatically generates getter and setter | Needed to instantiate Beans
@AllArgsConstructor //Generates a constructor with arguments for all fields in your clss
@Builder //It generates a builder pattern for your class, allowing you to chain method calls to set the values of individual field
@Entity
@Table(name="Exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "exercise_name")
    private String exerciseName;
    private String category;
    private String description;
    private String imageURL;
}
