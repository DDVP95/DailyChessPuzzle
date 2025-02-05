package com.chessgg.chessapp.maven.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PuzzleSolutionDeserializer extends JsonDeserializer<List<PuzzleSolution>> {
    @Override
    public List<PuzzleSolution> deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        List<PuzzleSolution> solutions = new ArrayList<>();

        for (JsonNode solutionNode : node) {
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
            solutions.add(solution);
        }

        return solutions;
    }
}
