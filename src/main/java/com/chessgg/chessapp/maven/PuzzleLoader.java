package com.chessgg.chessapp.maven;

import com.chessgg.chessapp.maven.model.Puzzle;
import com.chessgg.chessapp.maven.model.PuzzleSolution;
import com.chessgg.chessapp.maven.model.PuzzleSolutionMove;
import com.chessgg.chessapp.maven.repository.PuzzleRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Component  // Indicates that this is a Spring-managed component.
@Order(1)  // Ensures that this task runs first when the application starts.
public class PuzzleLoader implements CommandLineRunner {

    private static final Logger LOGGER = Logger.getLogger(PuzzleLoader.class.getName());
    private final PuzzleRepository puzzleRepository;
    private final ObjectMapper objectMapper;

    @Autowired  // Constructor-based dependency injection for PuzzleRepository and ObjectMapper
    public PuzzleLoader(PuzzleRepository puzzleRepository, ObjectMapper objectMapper) {
        this.puzzleRepository = puzzleRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * This method is automatically called after the application starts.
     * It reads the puzzle data from `puzzles.json` and saves each puzzle to the database.
     *
     * @param args Command-line arguments (not used here)
     */
    @Override
    public void run(String... args) {
        LOGGER.info("Starting PuzzleLoader...");

        try (InputStream is = new ClassPathResource("puzzles.json").getInputStream()) {
            // Deserialize the JSON file into a list of Puzzle objects.
            List<Puzzle> puzzles = objectMapper.readValue(is, new TypeReference<List<Puzzle>>() {});

            // Iterate over the puzzles and save them to the database, if they don't already exist.
            for (Puzzle puzzle : puzzles) {
                savePuzzleIfNotExists(puzzle);
            }

            LOGGER.info("PuzzleLoader completed successfully!");
        } catch (IOException e) {
            LOGGER.severe("Error loading puzzles.json: " + e.getMessage());  // Log any errors that occur while loading the file.
        }
    }

    /**
     * Checks if a puzzle already exists in the database by its position.
     * If the puzzle does not exist, it is saved to the database along with its solutions.
     * 
     * @param puzzle The puzzle to check and save.
     */
    private void savePuzzleIfNotExists(Puzzle puzzle) {
        // Check if a puzzle with the same position already exists in the database.
        Optional<Puzzle> existingPuzzleOpt = puzzleRepository.findByPosition(puzzle.getPosition());

        if (existingPuzzleOpt.isEmpty()) {  // If the puzzle doesn't exist, save it.
            // Iterate through each solution and associate it with the puzzle.
            for (PuzzleSolution solution : puzzle.getSolutions()) {
                solution.setPuzzle(puzzle);  // Set the puzzle reference for each solution.
                // For each move in the solution, associate it with the solution.
                for (PuzzleSolutionMove move : solution.getMoves()) {
                    move.setSolution(solution);
                }
            }
            puzzleRepository.save(puzzle);  // Save the puzzle and its solutions to the database.
            LOGGER.info("Saved new puzzle ID: " + puzzle.getId());
        }
    }
}
