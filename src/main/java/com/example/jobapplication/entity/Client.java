package com.example.jobapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 100)
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String apikey;

    @PrePersist
    public void generateApiKey(){
        this.apikey = UUID.randomUUID().toString();
    }

    public String getEmail() {
        return email;
    }
}
