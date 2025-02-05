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
        JsonNode node = p.getCodec().readTree(p);  // Read the JSON tree
        List<PuzzleSolution> solutions = new ArrayList<>();  // List to hold the solutions

        // Iterate through each solution in the JSON array
        for (JsonNode solutionNode : node) {
            PuzzleSolution solution = new PuzzleSolution();  // Create a new solution
            List<PuzzleSolutionMove> moves = new ArrayList<>();  // List to hold the moves for this solution
            int moveOrder = 1;  // Move order starts at 1

            // Iterate through each move in the solution
            for (JsonNode moveNode : solutionNode) {
                PuzzleSolutionMove move = new PuzzleSolutionMove();  // Create a new move
                move.setMoveOrder(moveOrder++);  // Increment move order
                move.setMoveText(moveNode.asText());  // Set the move text
                move.setSolution(solution);  // Set the solution for this move
                moves.add(move);  // Add the move to the list of moves
            }

            solution.setMoves(moves);  // Set the list of moves in the solution
            solutions.add(solution);  // Add the solution to the list of solutions
        }

        return solutions;  // Return the list of solutions
    }
}

