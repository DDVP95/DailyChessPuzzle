package com.chessgg.chessapp.maven.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

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
=======
@Entity  // This annotation marks the class as a JPA entity, meaning it corresponds to a table in the database
@Table(name = "puzzle")  // Specifies the table name in the database
public class Puzzle {

    @Id  // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates the ID value when a new puzzle is created
    private Long id;

    private String position;  // Stores the board position in FEN notation (Forsyth-Edwards Notation)
    private String description;  // A short description of the puzzle
    private int rating;  // Rating of the puzzle
    private String title;  // Title of the puzzle
    private String themes;  // Themes or categories of the puzzle (e.g., checkmate, tactical)
    private String pgn;  // Stores the PGN (Portable Game Notation) of the puzzle's solution
    private int ratingDeviation;  // Rating deviation of the puzzle
    private int popularity;  // Popularity score of the puzzle (can be based on how many people solve it)
    private int nbPlays;  // Number of times the puzzle has been played
    private String gameUrl;  // URL to the game related to this puzzle
    private String video;  // URL to a video explanation of the puzzle
    private String openingTags;  // Tags related to the opening in chess (e.g., King's Gambit)

    @JsonProperty("daily")  // Ensures the 'daily' property is properly serialized/deserialized
    private boolean isDaily;  // Flag indicating if this puzzle is a daily puzzle

    private LocalDate publishDate;  // The date when the puzzle was published

    // One-to-many relationship: A puzzle can have multiple solutions
    @OneToMany(mappedBy = "puzzle", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonDeserialize(using = PuzzleSolutionListDeserializer.class)  // Custom deserializer for puzzle solutions
    private List<PuzzleSolution> solutions = new ArrayList<>();  // List to hold the solutions for the puzzle

    // Getters and Setters for all fields

>>>>>>> 295a1a5 (Documentation/Commenting final version)

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
