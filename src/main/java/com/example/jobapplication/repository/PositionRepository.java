package com.example.jobapplication.repository;

import com.example.jobapplication.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position, Long> {
//List<Position> findByContaningNameAndLocation(String name, String location);
List<Position> findAllByNameContainingAndLocationContaining(String name, String location);
Optional<Position> findById(Long id);


}
