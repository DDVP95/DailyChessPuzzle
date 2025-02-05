package com.chessgg.chessapp.maven.service;

import com.chessgg.chessapp.maven.model.Puzzle;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PuzzleService {

    /**
     * Retrieves the daily puzzle for a specific date.
     * 
     * @param today The date for which to find the puzzle.
     * @return Optional containing the daily puzzle, or empty if not found.
     */
    Optional<Puzzle> getDailyPuzzle(LocalDate today);

    /**
     * Retrieves all puzzles from the database.
     * 
     * @return List of all puzzles.
     */
    List<Puzzle> getAllPuzzles();

    /**
     * Retrieves a puzzle by its ID.
     * 
     * @param id The ID of the puzzle.
     * @return The puzzle if found, otherwise throws an exception.
     */
    Puzzle getPuzzleById(Long id);

    /**
     * Retrieves puzzles published within a specific date range.
     * 
     * @param startDate The start date of the range.
     * @param endDate   The end date of the range.
     * @return List of puzzles within the specified date range.
     */
    List<Puzzle> getPuzzlesByDateRange(LocalDate startDate, LocalDate endDate);

    /**
     * Retrieves the most recent puzzle before a specific date.
     * 
     * @param date The reference date.
     * @return Optional containing the most recent puzzle before the date.
     */
    Optional<Puzzle> getMostRecentPuzzleBeforeDate(LocalDate date);

    /**
     * Retrieves puzzles marked as daily.
     * 
     * @return List of puzzles marked as daily puzzles.
     */
    List<Puzzle> getDailyPuzzles();

    /**
     * Saves a new puzzle to the database.
     * 
     * @param puzzle The puzzle to save.
     * @return The saved puzzle.
     */
    Puzzle savePuzzle(Puzzle puzzle);

    /**
     * Updates an existing puzzle in the database.
     * 
     * @param id     The ID of the puzzle to update.
     * @param puzzle The updated puzzle data.
     * @return The updated puzzle if successful, otherwise throws an exception.
     */
    Puzzle updatePuzzle(Long id, Puzzle puzzle);

    /**
     * Deletes a puzzle by its ID.
     * 
     * @param id The ID of the puzzle to delete.
     */
    void deletePuzzle(Long id);
}
