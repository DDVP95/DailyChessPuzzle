package com.chessgg.chessapp.maven.repository;

import com.chessgg.chessapp.maven.model.Puzzle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
@Repository
public interface PuzzleRepository extends JpaRepository<Puzzle, Long> {
    Optional<Puzzle> findByPublishDateAndIsDaily(LocalDate publishDate, boolean isDaily);

    Optional<Puzzle> findFirstByOrderByPublishDateDesc();
    Optional<Puzzle> findByPosition(String position); // ✅ Add this method to prevent duplicates
    Optional<Puzzle> findFirstByPublishDateLessThanOrderByPublishDateDesc(LocalDate date);
     @Query("SELECT p FROM Puzzle p LEFT JOIN FETCH p.solutions WHERE p.publishDate = :date")
    Optional<Puzzle> getDailyPuzzle(@Param("date") LocalDate date);
}

=======
@Repository  // Marks this interface as a repository, a part of Spring's component scan
public interface PuzzleRepository extends JpaRepository<Puzzle, Long> {
    
    /**
     * Finds a puzzle by its publish date and whether it is marked as a daily puzzle.
     * 
     * @param publishDate The date the puzzle was published.
     * @param isDaily A flag indicating whether the puzzle is daily.
     * @return An optional puzzle matching the criteria.
     */
    Optional<Puzzle> findByPublishDateAndIsDaily(LocalDate publishDate, boolean isDaily);

    /**
     * Retrieves the most recently published puzzle.
     * 
     * @return The most recently published puzzle (if it exists).
     */
    Optional<Puzzle> findFirstByOrderByPublishDateDesc();

    /**
     * Finds a puzzle by its position (FEN notation). This is useful for ensuring no duplicate puzzles.
     * 
     * @param position The FEN position of the puzzle.
     * @return An optional puzzle with the specified position.
     */
    Optional<Puzzle> findByPosition(String position); // ✅ Add this method to prevent duplicates

    /**
     * Finds the most recent puzzle that was published before the given date.
     * 
     * @param date The date to compare against.
     * @return An optional puzzle that was published before the given date.
     */
    Optional<Puzzle> findFirstByPublishDateLessThanOrderByPublishDateDesc(LocalDate date);

    /**
     * Retrieves a daily puzzle for a given date, including its associated solutions.
     * This query uses a LEFT JOIN to ensure the solutions are fetched alongside the puzzle.
     * 
     * @param date The date of the puzzle to fetch.
     * @return An optional puzzle with its solutions for the specified date.
     */
    @Query("SELECT p FROM Puzzle p LEFT JOIN FETCH p.solutions WHERE p.publishDate = :date")
    Optional<Puzzle> getDailyPuzzle(@Param("date") LocalDate date);
}
>>>>>>> 295a1a5 (Documentation/Commenting final version)
