package com.chessgg.chessapp.maven.model;

import jakarta.persistence.*;
@Entity
@Table(name = "puzzle_solution_move")
public class PuzzleSolutionMove {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-one relationship: Each move belongs to one solution
    @ManyToOne
    @JoinColumn(name = "solution_id", nullable = false)
    private PuzzleSolution solution;

    private int moveOrder;  // The order of the move in the solution
    private String moveText;  // The move text in PGN format

    // Getters and Setters for all fields


    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public PuzzleSolution getSolution() { return solution; }
    public void setSolution(PuzzleSolution solution) { this.solution = solution; }

    public int getMoveOrder() { return moveOrder; }
    public void setMoveOrder(int moveOrder) { this.moveOrder = moveOrder; }

    public String getMoveText() { return moveText; }
    public void setMoveText(String moveText) { this.moveText = moveText; }
}
