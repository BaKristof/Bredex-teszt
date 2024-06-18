package com.example.jobapplication.service;

import com.example.jobapplication.entity.Position;
import com.example.jobapplication.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    public List<Position> searchPositions(String keyword, String location) {
        return positionRepository.findAllByNameContainingAndLocationContaining(keyword, location);
    }


    public Optional<Position> getPositionById(Long id) {
        return positionRepository.findById(id);
    }
}
