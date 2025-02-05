package com.chessgg.chessapp.maven.serviceImpl;

import com.chessgg.chessapp.maven.model.Puzzle;
import com.chessgg.chessapp.maven.repository.PuzzleRepository;
import com.chessgg.chessapp.maven.service.PuzzleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service  // Marks this class as a service, making it available for dependency injection
public class PuzzleServiceImpl implements PuzzleService {

    @Autowired  // Inject the PuzzleRepository to interact with the database
    private PuzzleRepository puzzleRepository;

    /**
     * Retrieves the daily puzzle for a specific date.
     * If the puzzle for the given date doesn't exist, it tries to find a puzzle from the previous day.
     *
     * @param today The date to search for the daily puzzle.
     * @return Optional containing the puzzle, or empty if not found.
     */
    @Override
    public Optional<Puzzle> getDailyPuzzle(LocalDate today) {
        Optional<Puzzle> dailyPuzzle = puzzleRepository.findByPublishDateAndIsDaily(today, true);

        // If no puzzle is found for the given date, try finding the previous day's puzzle.
        if (dailyPuzzle.isEmpty()) {
            return findPreviousDayPuzzle(today);
        }
        return dailyPuzzle;
    }

    /**
     * Finds a puzzle from the previous day, searching back up to one year.
     * This method helps ensure that the user can always access a daily puzzle if the current one doesn't exist.
     *
     * @param date The reference date to find a previous day's puzzle.
     * @return Optional containing the previous day's puzzle, or empty if no puzzle is found within the last year.
     */
    private Optional<Puzzle> findPreviousDayPuzzle(LocalDate date) {
        LocalDate searchDate = date.minusDays(1);

        while (searchDate.isAfter(LocalDate.now().minusYears(1))) {
            Optional<Puzzle> previousPuzzle = puzzleRepository.findByPublishDateAndIsDaily(searchDate, true);
            if (previousPuzzle.isPresent()) {
                return previousPuzzle;  // Return the first valid puzzle found.
            }
            searchDate = searchDate.minusDays(1);  // Continue searching backward.
        }

        return Optional.empty();  // Return empty if no puzzle is found within the last year.
    }

    /**
     * Retrieves all puzzles in the database.
     *
     * @return A list of all puzzles.
     */
    @Override
    public List<Puzzle> getAllPuzzles() {
        return puzzleRepository.findAll();
    }

    /**
     * Retrieves a puzzle by its ID. Throws an exception if not found.
     *
     * @param id The ID of the puzzle to retrieve.
     * @return The found puzzle.
     * @throws RuntimeException if the puzzle with the given ID does not exist.
     */
    @Override
    public Puzzle getPuzzleById(Long id) {
        return puzzleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Puzzle not found with ID: " + id));
    }

    /**
     * Retrieves puzzles published within a specific date range.
     *
     * @param startDate The starting date of the range.
     * @param endDate The ending date of the range.
     * @return A list of puzzles within the specified date range.
     */
    @Override
    public List<Puzzle> getPuzzlesByDateRange(LocalDate startDate, LocalDate endDate) {
        return puzzleRepository.findAll().stream()
                .filter(p -> !p.getPublishDate().isBefore(startDate) && !p.getPublishDate().isAfter(endDate))
                .toList();
    }

    /**
     * Retrieves the most recent puzzle published before a specified date.
     *
     * @param date The reference date.
     * @return Optional containing the most recent puzzle, or empty if no puzzle is found.
     */
    @Override
    public Optional<Puzzle> getMostRecentPuzzleBeforeDate(LocalDate date) {
        return puzzleRepository.findFirstByPublishDateLessThanOrderByPublishDateDesc(date);
    }

    /**
     * Retrieves all puzzles marked as daily puzzles.
     *
     * @return A list of daily puzzles.
     */
    @Override
    public List<Puzzle> getDailyPuzzles() {
        return puzzleRepository.findAll().stream()
                .filter(Puzzle::isDaily)
                .toList();
    }

    /**
     * Saves a new puzzle to the database.
     *
     * @param puzzle The puzzle to save.
     * @return The saved puzzle.
     */
    @Override
    public Puzzle savePuzzle(Puzzle puzzle) {
        return puzzleRepository.save(puzzle);
    }

    /**
     * Updates an existing puzzle with new details.
     * The updated puzzle data is merged with the existing data.
     *
     * @param id The ID of the puzzle to update.
     * @param updatedPuzzle The updated puzzle data.
     * @return The updated puzzle.
     * @throws RuntimeException if the puzzle with the given ID does not exist.
     */
    @Override
    public Puzzle updatePuzzle(Long id, Puzzle updatedPuzzle) {
        return puzzleRepository.findById(id).map(existingPuzzle -> {
            // Update the puzzle fields with the new data
            if (updatedPuzzle.getPosition() != null) {
                existingPuzzle.setPosition(updatedPuzzle.getPosition());
            }
            if (updatedPuzzle.getSolutions() != null) {
                existingPuzzle.setSolutions(updatedPuzzle.getSolutions());
            }
            if (updatedPuzzle.getDescription() != null) {
                existingPuzzle.setDescription(updatedPuzzle.getDescription());
            }
            if (updatedPuzzle.getPublishDate() != null) {
                existingPuzzle.setPublishDate(updatedPuzzle.getPublishDate());
            }
            existingPuzzle.setDaily(updatedPuzzle.isDaily());

            return puzzleRepository.save(existingPuzzle);  // Save and return the updated puzzle.
        }).orElseThrow(() -> new RuntimeException("Puzzle not found with ID: " + id));
    }

    /**
     * Deletes a puzzle from the database by its ID.
     *
     * @param id The ID of the puzzle to delete.
     * @throws RuntimeException if the puzzle with the given ID does not exist.
     */
    @Override
    public void deletePuzzle(Long id) {
        if (!puzzleRepository.existsById(id)) {
            throw new RuntimeException("Puzzle not found with ID: " + id);
        }
        puzzleRepository.deleteById(id);  // Delete the puzzle from the repository.
    }
}
