package com.chessgg.chessapp.maven.serviceImpl;

import com.chessgg.chessapp.maven.model.Puzzle;
import com.chessgg.chessapp.maven.repository.PuzzleRepository;
import com.chessgg.chessapp.maven.service.PuzzleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PuzzleServiceImpl implements PuzzleService {

    @Autowired
    private PuzzleRepository puzzleRepository;

    @Override
    public Optional<Puzzle> getDailyPuzzle(LocalDate today) {
        Optional<Puzzle> dailyPuzzle = puzzleRepository.findByPublishDateAndIsDaily(today, true);

        if (dailyPuzzle.isEmpty()) {
            return findPreviousDayPuzzle(today);
        }
        return dailyPuzzle;
    }

    private Optional<Puzzle> findPreviousDayPuzzle(LocalDate date) {
        LocalDate searchDate = date.minusDays(1);

        while (searchDate.isAfter(LocalDate.now().minusYears(1))) {
            Optional<Puzzle> previousPuzzle = puzzleRepository.findByPublishDateAndIsDaily(searchDate, true);
            if (previousPuzzle.isPresent()) {
                return previousPuzzle;
            }
            searchDate = searchDate.minusDays(1);
        }

        return Optional.empty();
    }

    @Override
    public List<Puzzle> getAllPuzzles() {
        return puzzleRepository.findAll();
    }

    @Override
    public Puzzle getPuzzleById(Long id) {
        return puzzleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Puzzle not found with ID: " + id));
    }

    @Override
    public List<Puzzle> getPuzzlesByDateRange(LocalDate startDate, LocalDate endDate) {
        return puzzleRepository.findAll().stream()
                .filter(p -> !p.getPublishDate().isBefore(startDate) && !p.getPublishDate().isAfter(endDate))
                .toList();
    }

    @Override
    public Optional<Puzzle> getMostRecentPuzzleBeforeDate(LocalDate date) {
        return puzzleRepository.findFirstByPublishDateLessThanOrderByPublishDateDesc(date);
    }

    @Override
    public List<Puzzle> getDailyPuzzles() {
        return puzzleRepository.findAll().stream()
                .filter(Puzzle::isDaily)
                .toList();
    }

    @Override
    public Puzzle savePuzzle(Puzzle puzzle) {
        return puzzleRepository.save(puzzle);
    }

    @Override
    public Puzzle updatePuzzle(Long id, Puzzle updatedPuzzle) {
        return puzzleRepository.findById(id).map(existingPuzzle -> {
            if (updatedPuzzle.getPosition() != null) {
                existingPuzzle.setPosition(updatedPuzzle.getPosition());
            }
            if (updatedPuzzle.getSolutions() != null) {
                existingPuzzle.setSolutions(updatedPuzzle.getSolutions());
            }
            if (updatedPuzzle.getDescription() != null) {
                existingPuzzle.setDescription(updatedPuzzle.getDescription());
            }
            if (updatedPuzzle.getPublishDate() != null) {
                existingPuzzle.setPublishDate(updatedPuzzle.getPublishDate());
            }
            existingPuzzle.setDaily(updatedPuzzle.isDaily());

            return puzzleRepository.save(existingPuzzle);
        }).orElseThrow(() -> new RuntimeException("Puzzle not found with ID: " + id));
    }

    @Override
    public void deletePuzzle(Long id) {
        if (!puzzleRepository.existsById(id)) {
            throw new RuntimeException("Puzzle not found with ID: " + id);
        }
        puzzleRepository.deleteById(id);
    }
}
