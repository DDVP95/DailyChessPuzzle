package com.chessgg.chessapp.maven.model;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    }
}
