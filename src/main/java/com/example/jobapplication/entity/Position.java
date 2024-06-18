package com.example.jobapplication.entity;


import com.example.jobapplication.entity.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;


@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    private String name;

    @Size(max = 50)
    private String location;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public void setClient(Client client) {
        this.client = client;
    }

    public String getId() {
        return this.id.toString();
    }
}
