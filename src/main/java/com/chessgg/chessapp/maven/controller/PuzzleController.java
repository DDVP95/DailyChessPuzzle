package com.chessgg.chessapp.maven.controller;

import com.chessgg.chessapp.maven.model.Puzzle;
import com.chessgg.chessapp.maven.service.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api") 
public class PuzzleController {

    @Autowired
    private PuzzleService puzzleService;

    @GetMapping("/puzzles")
    public ResponseEntity<List<Puzzle>> getAllPuzzles() {
        List<Puzzle> puzzles = puzzleService.getAllPuzzles();
        return ResponseEntity.ok(puzzles);
    }

    @GetMapping("/daily-puzzle")
    public ResponseEntity<?> getDailyPuzzle() {
        LocalDate today = LocalDate.now();
        Optional<Puzzle> dailyPuzzle = puzzleService.getDailyPuzzle(today);

        if (dailyPuzzle.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "No daily puzzle found."));
        }

        Puzzle puzzle = dailyPuzzle.get();
        List<List<String>> solutions = new ArrayList<>();

        if (puzzle.getSolutions() != null) {
            for (var solution : puzzle.getSolutions()) {
                List<String> moves = new ArrayList<>();
                solution.getMoves().forEach(move -> moves.add(move.getMoveText()));
                solutions.add(moves);
            }
        }

        // ✅ Fix: Use HashMap instead of Map.of() because we have more than 10 key-value pairs.
        Map<String, Object> response = new HashMap<>();
        response.put("id", puzzle.getId());
        response.put("position", puzzle.getPosition());
        response.put("description", puzzle.getDescription());
        response.put("rating", puzzle.getRating());
        response.put("title", puzzle.getTitle());
        response.put("themes", puzzle.getThemes());
        response.put("pgn", puzzle.getPgn());
        response.put("ratingDeviation", puzzle.getRatingDeviation());
        response.put("popularity", puzzle.getPopularity());
        response.put("nbPlays", puzzle.getNbPlays());
        response.put("gameUrl", puzzle.getGameUrl());
        response.put("video", puzzle.getVideo());
        response.put("openingTags", puzzle.getOpeningTags());
        response.put("daily", puzzle.isDaily());
        response.put("publishDate", puzzle.getPublishDate());
        response.put("solutions", solutions); // ✅ Ensure solutions are included

        return ResponseEntity.ok(response);
    }
}
