package com.roshan.Gym.Tracker.api.repository;

import com.roshan.Gym.Tracker.api.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(String name);
}
