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

@Component
@Order(1)
public class PuzzleLoader implements CommandLineRunner {

    private static final Logger LOGGER = Logger.getLogger(PuzzleLoader.class.getName());
    private final PuzzleRepository puzzleRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public PuzzleLoader(PuzzleRepository puzzleRepository, ObjectMapper objectMapper) {
        this.puzzleRepository = puzzleRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) {
        LOGGER.info("Starting PuzzleLoader...");

        try (InputStream is = new ClassPathResource("puzzles.json").getInputStream()) {
            List<Puzzle> puzzles = objectMapper.readValue(is, new TypeReference<List<Puzzle>>() {});

            for (Puzzle puzzle : puzzles) {
                savePuzzleIfNotExists(puzzle);
            }

            LOGGER.info("PuzzleLoader completed successfully!");
        } catch (IOException e) {
            LOGGER.severe("Error loading puzzles.json: " + e.getMessage());
        }
    }

    private void savePuzzleIfNotExists(Puzzle puzzle) {
        Optional<Puzzle> existingPuzzleOpt = puzzleRepository.findByPosition(puzzle.getPosition());

        if (existingPuzzleOpt.isEmpty()) {
            // Ensure solutions are properly associated with the puzzle
            for (PuzzleSolution solution : puzzle.getSolutions()) {
                solution.setPuzzle(puzzle);
                for (PuzzleSolutionMove move : solution.getMoves()) {
                    move.setSolution(solution);
                }
            }
            puzzleRepository.save(puzzle);
            LOGGER.info("Saved new puzzle ID: " + puzzle.getId());
        }
    }
}
