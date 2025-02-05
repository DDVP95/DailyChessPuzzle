package com.chessgg.chessapp.maven.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "puzzle")
public class Puzzle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String position;
    private String description;
    private int rating;
    private String title;
    private String themes;
    private String pgn;
    private int ratingDeviation;
    private int popularity;
    private int nbPlays;
    private String gameUrl;
    private String video;
    private String openingTags;

    @JsonProperty("daily")
    private boolean isDaily;

    private LocalDate publishDate;

    @OneToMany(mappedBy = "puzzle", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonDeserialize(using = PuzzleSolutionListDeserializer.class)
    private List<PuzzleSolution> solutions = new ArrayList<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getThemes() { return themes; }
    public void setThemes(String themes) { this.themes = themes; }

    public String getPgn() { return pgn; }
    public void setPgn(String pgn) { this.pgn = pgn; }

    public int getRatingDeviation() { return ratingDeviation; }
    public void setRatingDeviation(int ratingDeviation) { this.ratingDeviation = ratingDeviation; }

    public int getPopularity() { return popularity; }
    public void setPopularity(int popularity) { this.popularity = popularity; }

    public int getNbPlays() { return nbPlays; }
    public void setNbPlays(int nbPlays) { this.nbPlays = nbPlays; }

    public String getGameUrl() { return gameUrl; }
    public void setGameUrl(String gameUrl) { this.gameUrl = gameUrl; }

    public String getVideo() { return video; }
    public void setVideo(String video) { this.video = video; }

    public String getOpeningTags() { return openingTags; }
    public void setOpeningTags(String openingTags) { this.openingTags = openingTags; }

    public boolean isDaily() { return isDaily; }
    public void setDaily(boolean daily) { isDaily = daily; }

    public LocalDate getPublishDate() { return publishDate; }
    public void setPublishDate(LocalDate publishDate) { this.publishDate = publishDate; }

    public List<PuzzleSolution> getSolutions() { return solutions; }
    public void setSolutions(List<PuzzleSolution> solutions) { this.solutions = solutions; }
}
