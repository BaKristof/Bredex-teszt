package com.example.jobapplication.repository;

import com.example.jobapplication.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByApikey(String apikey);
    boolean existsByEmail(String email);
}
