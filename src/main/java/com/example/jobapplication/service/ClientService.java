package com.example.jobapplication.service;

import com.example.jobapplication.entity.Client;
import com.example.jobapplication.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client register(Client client){
        if (clientRepository.existsByEmail(client.getEmail())) throw new RuntimeException("Az email már foglalt");
        return clientRepository.save(client);
    }
    public Optional<Client> validateApiKey(String apiKey){
        return clientRepository.findByApikey(apiKey);
    }

}
