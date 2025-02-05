package com.chessgg.chessapp.maven.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "achievements")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String title; // Achievement title, e.g., "Puzzle Master", "Streak Hero"
    private String description; // Description of the achievement
    private LocalDate dateAchieved; // Date the achievement was unlocked
    private int xpReward; // Extra XP given for unlocking the achievement

    // Constructors
    public Achievement() {}

    public Achievement(User user, String title, String description, LocalDate dateAchieved, int xpReward) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.dateAchieved = dateAchieved;
        this.xpReward = xpReward;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateAchieved() {
        return dateAchieved;
    }

    public void setDateAchieved(LocalDate dateAchieved) {
        this.dateAchieved = dateAchieved;
    }

    public int getXpReward() {
        return xpReward;
    }

    public void setXpReward(int xpReward) {
        this.xpReward = xpReward;
    }
}
