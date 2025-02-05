package com.chessgg.chessapp.maven.model;

import jakarta.persistence.*;
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;  // Name of the role (e.g., "USER", "ADMIN")

    public Role() {}

    public Role(String name) {
        this.name = name;
    }

    // Getters and Setters for all fields


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
