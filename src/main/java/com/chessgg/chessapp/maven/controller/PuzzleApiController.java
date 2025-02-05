package com.chessgg.chessapp.maven.controller;

import com.chessgg.chessapp.maven.model.Puzzle;
import com.chessgg.chessapp.maven.service.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class PuzzleApiController {

    @Autowired
    private PuzzleService puzzleService;

    /**
     * Endpoint to get the daily puzzle as JSON data.
     */
    @GetMapping("/daily-puzzle/view")
    public ResponseEntity<Puzzle> getDailyPuzzle() {
        // Pass the current date to the service method
        LocalDate today = LocalDate.now();
        return puzzleService.getDailyPuzzle(today)
                .map(ResponseEntity::ok) // If present, return HTTP 200 with the puzzle
                .orElse(ResponseEntity.notFound().build()); // If empty, return HTTP 404
    }
}
