package com.chessgg.chessapp.maven;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.chessgg.chessapp.maven.model.Puzzle;
import com.chessgg.chessapp.maven.model.PuzzleSolution;
import com.chessgg.chessapp.maven.model.PuzzleSolutionMove;
import com.chessgg.chessapp.maven.repository.PuzzleRepository;
import com.chessgg.chessapp.maven.service.PuzzleService;

@SpringBootTest
class MavenApplicationTests {

    @Autowired
    private PuzzleService puzzleService;

    @MockBean
    private PuzzleRepository puzzleRepository;

    @Test
    public void testGetDailyPuzzle() {
        // Arrange: Set up today's date and mock puzzle
        LocalDate today = LocalDate.now();
        Puzzle dailyPuzzle = new Puzzle();
        dailyPuzzle.setPosition("test-fen");
        dailyPuzzle.setDescription("test-description");
        dailyPuzzle.setPublishDate(today);
        dailyPuzzle.setDaily(true);

        // Create PuzzleSolution and PuzzleSolutionMove to match the required type
        PuzzleSolution solution = new PuzzleSolution();
        solution.setPuzzle(dailyPuzzle);

        PuzzleSolutionMove move = new PuzzleSolutionMove();
        move.setSolution(solution);
        move.setMoveOrder(1);
        move.setMoveText("test-solution");

        List<PuzzleSolutionMove> moves = new ArrayList<>();
        moves.add(move);
        solution.setMoves(moves);

        List<PuzzleSolution> solutions = new ArrayList<>();
        solutions.add(solution);

        dailyPuzzle.setSolutions(solutions); // Ensure solutions are correctly set

        // Mock repository behavior to return the expected puzzle
        Mockito.when(puzzleRepository.findByPublishDateAndIsDaily(today, true))

                .thenReturn(Optional.of(dailyPuzzle));

        // Act: Call the service with today's date
        Optional<Puzzle> result = puzzleService.getDailyPuzzle(today);

        // Assert: Validate the result
        assertTrue(result.isPresent(), "The result should not be empty");
        assertEquals("test-fen", result.get().getPosition(), "The position should match the expected value");
        assertEquals("test-description", result.get().getDescription(), "The description should match the expected value");
        assertEquals(today, result.get().getPublishDate(), "The publish date should match today's date");
        assertTrue(result.get().isDaily(), "The puzzle should be marked as daily");

        // Check that the solutions contain the correct move text
        assertEquals(1, result.get().getSolutions().size(), "There should be one solution");
        assertEquals(1, result.get().getSolutions().get(0).getMoves().size(), "The solution should have one move");
        assertEquals("test-solution", result.get().getSolutions().get(0).getMoves().get(0).getMoveText(),
                "The move text should match the expected value");
    }
}
