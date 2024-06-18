package com.example.jobapplication.controller;

import com.example.jobapplication.entity.Client;
import com.example.jobapplication.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@Validated
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostMapping
    public ResponseEntity<Client> registerClient(@Valid @RequestBody Client client) {
        Client registeredClient = clientService.register(client);
        return ResponseEntity.ok(registeredClient);
    }
}
