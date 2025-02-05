package com.chessgg.chessapp.maven.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "puzzle_solution")
public class PuzzleSolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-one relationship: Multiple solutions can belong to one puzzle
    @ManyToOne
    @JoinColumn(name = "puzzle_id", nullable = false)
    private Puzzle puzzle;

    @OneToMany(mappedBy = "solution", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PuzzleSolutionMove> moves = new ArrayList<>();  // List of moves in this solution

    // Getters and Setters for all fields


    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Puzzle getPuzzle() { return puzzle; }
    public void setPuzzle(Puzzle puzzle) { this.puzzle = puzzle; }

    public List<PuzzleSolutionMove> getMoves() { return moves; }
    public void setMoves(List<PuzzleSolutionMove> moves) { this.moves = moves; }
}
