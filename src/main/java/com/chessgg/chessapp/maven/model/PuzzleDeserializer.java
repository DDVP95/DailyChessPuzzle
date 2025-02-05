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
