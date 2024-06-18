package com.example.jobapplication.controller;

import com.example.jobapplication.entity.Client;
import com.example.jobapplication.service.ClientService;
import com.example.jobapplication.entity.Position;
import com.example.jobapplication.service.PositionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/position")
@Validated
public class PositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private ClientService clientService;
    @PostMapping
    public ResponseEntity<?> createPosition(@RequestHeader("apiKey") String apiKey, @Valid @RequestBody Position position) {
        Optional<Client> client = clientService.validateApiKey(apiKey);
        if (client.isEmpty()) {
            return ResponseEntity.status(401).body("Invalid API key");
        }
        position.setClient(client.get());
        Position createdPosition = positionService.createPosition(position);
        String url = "/position/" + createdPosition.getId();
        return ResponseEntity.ok(url);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchPositions(@RequestHeader("apiKey") String apiKey,
                                             @RequestParam String keyword,
                                             @RequestParam String location) {
        Optional<Client> client = clientService.validateApiKey(apiKey);
        if (client.isEmpty()) {
            return ResponseEntity.status(401).body("Invalid API key");
        }
        List<Position> positions = positionService.searchPositions(keyword, location);
        return ResponseEntity.ok(positions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> getPosition(@PathVariable Long id, @RequestHeader("API-Key") String apiKey) {

        Optional<Client> client = clientService.validateApiKey(apiKey);
        if (client.isEmpty()) {
            return ResponseEntity.status(401).body(null);
        }

        Optional<Position> position = positionService.getPositionById(id);
        if (position.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(position.get());
    }
}
