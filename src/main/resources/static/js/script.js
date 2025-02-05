// main script.js
import { fetchPuzzleData } from './puzzle.js';
import { initializeBoard } from './board.js';
import { handlePawnPromotion } from './promotion.js';
import { displayErrorMessage } from './errorHandling.js';

document.addEventListener("DOMContentLoaded", function () {
    const username = window.username || 'Guest';
    console.log("Loaded username:", username);

    if (username === 'Guest') {
        displayErrorMessage("Log in to see the daily puzzle.");
        return;
    }

    // Fetch the puzzle data
    fetchPuzzleData()
        .then(data => {
            console.log("Puzzle Data Received:", data);

            const initialPuzzlePosition = data.puzzleData.position;
            const puzzleSolutions = data.puzzleSolutions;

            // Initialize the board with the puzzle position
            const { game, board } = initializeBoard(initialPuzzlePosition, data.puzzleData, handleMove);

            let currentMoveIndex = 0;

            // Handle the move logic (including pawn promotion)
            function handleMove(source, target) {
                let moveObj = { from: source, to: target };

                moveObj = handlePawnPromotion(game, source, target);  // Handle pawn promotion

                const attemptedMove = game.move(moveObj);
                
                if (!attemptedMove) {
                    console.error(`Invalid move made: ${source}-${target}`);
                    alert("Invalid move! Try again.");
                    game.load(initialPuzzlePosition);
                    board.position(game.fen());
                    currentMoveIndex = 0;
                    return 'snapback';
                }

                // Move validation and solution checking
                const moveSAN = attemptedMove.san;
                const expectedSolution = puzzleSolutions.find(solution => solution[currentMoveIndex] === moveSAN);

                if (expectedSolution) {
                    console.log("Correct move!");
                    board.position(game.fen());
                    currentMoveIndex++;
                    if (currentMoveIndex >= expectedSolution.length) {
                        setTimeout(() => alert('Puzzle solved!'), 500);
                    }
                } else {
                    console.error(`Incorrect move! Expected: ${expectedSolution[currentMoveIndex]}, Got: ${moveSAN}`);
                    alert("Incorrect move! Try again.");
                    game.load(initialPuzzlePosition);
                    board.position(game.fen());
                    currentMoveIndex = 0;
                    return 'snapback';
                }
            }
        })
        .catch(error => {
            console.error("Error loading the puzzle:", error);
            displayErrorMessage("Failed to load the puzzle. Please try again later.");
        });
});
