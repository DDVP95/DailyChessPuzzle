package com.chessgg.chessapp.maven.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
public class PuzzleDeserializer extends JsonDeserializer<Puzzle> {
    @Override
    public Puzzle deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
<<<<<<< HEAD
        JsonNode node = p.getCodec().readTree(p);
        Puzzle puzzle = new Puzzle();

        // Set simple fields
        puzzle.setId(node.get("id").asLong());
        puzzle.setPosition(node.get("position").asText());
        puzzle.setDescription(node.get("description").asText());
        puzzle.setRating(node.get("rating").asInt());
        puzzle.setTitle(node.get("title").asText());
        puzzle.setThemes(node.get("themes").asText());
        puzzle.setPgn(node.get("pgn").asText());
        puzzle.setRatingDeviation(node.get("ratingDeviation").asInt());
        puzzle.setPopularity(node.get("popularity").asInt());
        puzzle.setNbPlays(node.get("nbPlays").asInt());
        puzzle.setGameUrl(node.get("gameUrl").asText());
        puzzle.setVideo(node.get("video").asText());
        puzzle.setOpeningTags(node.get("openingTags").asText());
        puzzle.setDaily(node.get("daily").asBoolean());
        puzzle.setPublishDate(LocalDate.parse(node.get("publishDate").asText()));

        // Deserialize solutions
        List<PuzzleSolution> solutions = new ArrayList<>();
        for (JsonNode solutionNode : node.get("solutions")) {
            PuzzleSolution solution = new PuzzleSolution();
            List<PuzzleSolutionMove> moves = new ArrayList<>();
            int moveOrder = 1;
            for (JsonNode moveNode : solutionNode) {
                PuzzleSolutionMove move = new PuzzleSolutionMove();
                move.setMoveOrder(moveOrder++);
                move.setMoveText(moveNode.asText());
                move.setSolution(solution);
                moves.add(move);
            }
            solution.setMoves(moves);
            solution.setPuzzle(puzzle);
            solutions.add(solution);
        }
        puzzle.setSolutions(solutions);

        return puzzle;
    }
}
=======
        JsonNode node = p.getCodec().readTree(p);  // Read the JSON tree from the parser
        Puzzle puzzle = new Puzzle();  // Create a new Puzzle object

        // Set simple fields from the JSON
        puzzle.setId(node.get("id").asLong());  // Set puzzle's ID
        puzzle.setPosition(node.get("position").asText());  // Set puzzle's board position (FEN notation)
        puzzle.setDescription(node.get("description").asText());  // Set description of the puzzle
        puzzle.setRating(node.get("rating").asInt());  // Set the puzzle rating
        puzzle.setTitle(node.get("title").asText());  // Set the title of the puzzle
        puzzle.setThemes(node.get("themes").asText());  // Set the themes of the puzzle (e.g., checkmate)
        puzzle.setPgn(node.get("pgn").asText());  // Set the PGN (game notation)
        puzzle.setRatingDeviation(node.get("ratingDeviation").asInt());  // Set rating deviation
        puzzle.setPopularity(node.get("popularity").asInt());  // Set popularity score
        puzzle.setNbPlays(node.get("nbPlays").asInt());  // Set number of plays
        puzzle.setGameUrl(node.get("gameUrl").asText());  // Set the URL to the game related to the puzzle
        puzzle.setVideo(node.get("video").asText());  // Set the URL for the video explanation
        puzzle.setOpeningTags(node.get("openingTags").asText());  // Set chess opening tags
        puzzle.setDaily(node.get("daily").asBoolean());  // Set whether the puzzle is a daily puzzle
        puzzle.setPublishDate(LocalDate.parse(node.get("publishDate").asText()));  // Set the publish date of the puzzle

        // Deserialize the solutions (nested JSON array)
        List<PuzzleSolution> solutions = new ArrayList<>();
        for (JsonNode solutionNode : node.get("solutions")) {
            PuzzleSolution solution = new PuzzleSolution();  // Create a new solution object
            List<PuzzleSolutionMove> moves = new ArrayList<>();  // List to store the moves for this solution
            int moveOrder = 1;  // Move order starts at 1

            // Loop through the move nodes in the solution
            for (JsonNode moveNode : solutionNode) {
                PuzzleSolutionMove move = new PuzzleSolutionMove();  // Create a new move
                move.setMoveOrder(moveOrder++);  // Increment move order
                move.setMoveText(moveNode.asText());  // Set the move text (e.g., "e2e4")
                move.setSolution(solution);  // Set the solution that this move belongs to
                moves.add(move);  // Add the move to the list
            }
            solution.setMoves(moves);  // Set the list of moves for this solution
            solution.setPuzzle(puzzle);  // Set the puzzle that this solution belongs to
            solutions.add(solution);  // Add this solution to the solutions list
        }
        puzzle.setSolutions(solutions);  // Set the list of solutions for the puzzle

        return puzzle;  // Return the fully populated Puzzle object
    }
}

>>>>>>> 295a1a5 (Documentation/Commenting final version)
