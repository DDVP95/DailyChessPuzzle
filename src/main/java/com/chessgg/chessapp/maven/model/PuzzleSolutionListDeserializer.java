package com.chessgg.chessapp.maven.model;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

public class PuzzleSolutionListDeserializer extends JsonDeserializer<List<PuzzleSolution>> {
    @Override
    public List<PuzzleSolution> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        List<List<String>> jsonSolutions = mapper.readValue(jp, new TypeReference<List<List<String>>>() {});
        List<PuzzleSolution> solutions = new ArrayList<>();

        for (List<String> jsonSolution : jsonSolutions) {
            PuzzleSolution solution = new PuzzleSolution();
            List<PuzzleSolutionMove> moves = new ArrayList<>();
            int moveOrder = 1;

            for (String moveText : jsonSolution) {
                PuzzleSolutionMove move = new PuzzleSolutionMove();
                move.setMoveOrder(moveOrder++);
                move.setMoveText(moveText);
                move.setSolution(solution);
                moves.add(move);
            }

            solution.setMoves(moves);
            solutions.add(solution);
        }

        return solutions;
=======
public class PuzzleSolutionListDeserializer extends JsonDeserializer<List<PuzzleSolution>> {
    @Override
    public List<PuzzleSolution> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();  // Get the ObjectMapper to parse JSON
        List<List<String>> jsonSolutions = mapper.readValue(jp, new TypeReference<List<List<String>>>() {});  // Deserialize into List of List of Strings
        List<PuzzleSolution> solutions = new ArrayList<>();  // List to hold the solutions

        // Iterate through each list of moves (solutions)
        for (List<String> jsonSolution : jsonSolutions) {
            PuzzleSolution solution = new PuzzleSolution();  // Create a new solution
            List<PuzzleSolutionMove> moves = new ArrayList<>();  // List to hold the moves for this solution
            int moveOrder = 1;  // Move order starts at 1

            // Iterate through the move texts in the solution
            for (String moveText : jsonSolution) {
                PuzzleSolutionMove move = new PuzzleSolutionMove();  // Create a new move
                move.setMoveOrder(moveOrder++);  // Increment move order
                move.setMoveText(moveText);  // Set the move text (e.g., "e2e4")
                move.setSolution(solution);  // Set the solution for this move
                moves.add(move);  // Add the move to the list
            }

            solution.setMoves(moves);  // Set the list of moves in the solution
            solutions.add(solution);  // Add the solution to the list of solutions
        }

        return solutions;  // Return the list of solutions
>>>>>>> 295a1a5 (Documentation/Commenting final version)
    }
}
