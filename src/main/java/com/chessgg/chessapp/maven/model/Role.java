package com.chessgg.chessapp.maven.model;

import jakarta.persistence.*;
<<<<<<< HEAD

=======
>>>>>>> 295a1a5 (Documentation/Commenting final version)
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
<<<<<<< HEAD
    private String name;
=======
    private String name;  // Name of the role (e.g., "USER", "ADMIN")
>>>>>>> 295a1a5 (Documentation/Commenting final version)

    public Role() {}

    public Role(String name) {
        this.name = name;
    }

<<<<<<< HEAD
=======
    // Getters and Setters for all fields


>>>>>>> 295a1a5 (Documentation/Commenting final version)
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
