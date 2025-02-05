<<<<<<< HEAD
document.addEventListener("DOMContentLoaded", function () {
    // Get the username from the global variable
=======
// main script.js
import { fetchPuzzleData } from './puzzle.js';
import { initializeBoard } from './board.js';
import { handlePawnPromotion } from './promotion.js';
import { displayErrorMessage } from './errorHandling.js';

document.addEventListener("DOMContentLoaded", function () {
>>>>>>> 295a1a5 (Documentation/Commenting final version)
    const username = window.username || 'Guest';
    console.log("Loaded username:", username);

    if (username === 'Guest') {
        displayErrorMessage("Log in to see the daily puzzle.");
        return;
    }

<<<<<<< HEAD
    fetch("/api/daily-puzzle")
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            console.log("Puzzle Data Received:", data);

            if (!data || typeof data.position !== 'string' || !Array.isArray(data.solutions)) {
                throw new Error("Invalid puzzle data received from the server.");
            }

            // Extract solutions properly
            const puzzleSolutions = data.solutions.map(solution =>
                Array.isArray(solution) ? solution.map(move => move.trim()) : []
            );

            if (puzzleSolutions.length === 0) {
                throw new Error("No valid moves found in puzzle solutions.");
            }

            const boardElement = document.getElementById("board");
            if (!boardElement) {
                console.error("Chessboard container element (#board) not found.");
                return;
            }

            const game = new Chess();
            if (!game.load(data.position)) {
                throw new Error(`Invalid FEN string: ${data.position}`);
            }

            const board = Chessboard(boardElement, {
                position: data.position,
                draggable: true,
                onDrop: handleMove
            });

            console.log("Chessboard and game initialized.");

            // Initialize the current move index
            let currentMoveIndex = 0;

            // Save the initial puzzle position from the FEN string
            const initialPuzzlePosition = data.position;

            function handleMove(source, target) {
                let moveObj = { from: source, to: target };

                // **Check for Pawn Promotion**
                if (
                    (game.turn() === 'w' && target[1] === '8') || 
                    (game.turn() === 'b' && target[1] === '1')
                ) {
                    // Check if the piece is already promoted (no need to ask again)
                    let piece = game.get(source); // Get the piece at the starting position
                    if (piece && piece.type === 'p') { // It's a pawn
                        if (game.get(target) && game.get(target).type !== 'p') {
                            // If the target already has a promoted piece, no need to prompt again
                            return;
                        }
                        
                        let promotion = prompt("Promote to (Q, R, B, N)?", "Q").toUpperCase();
                        if (!['Q', 'R', 'B', 'N'].includes(promotion)) {
                            alert("Invalid choice, defaulting to Queen.");
                            promotion = 'Q';
                        }
                        moveObj.promotion = promotion.toLowerCase(); // chess.js requires lowercase letters
                    }
                }

                const attemptedMove = game.move(moveObj);

                // If the move is invalid (either illegal or not part of the solution)
                if (!attemptedMove) {
                    console.error(`Invalid move made: ${source}-${target}`);
                    alert("Invalid move! Try again.");
                    game.load(initialPuzzlePosition); // Reset to the initial puzzle position (FEN)
                    board.position(game.fen()); // Update the board to the initial puzzle position
                    currentMoveIndex = 0; // Reset the move index
                    return 'snapback'; // Return the piece to its original position
                }

                // Handle move validation
=======
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
>>>>>>> 295a1a5 (Documentation/Commenting final version)
                const moveSAN = attemptedMove.san;
                const expectedSolution = puzzleSolutions.find(solution => solution[currentMoveIndex] === moveSAN);

                if (expectedSolution) {
                    console.log("Correct move!");
<<<<<<< HEAD
                    board.position(game.fen()); // Update board
                    currentMoveIndex++;

                    // Handle automatic opponent move
                    if (currentMoveIndex < expectedSolution.length) {
                        setTimeout(() => {
                            const opponentMove = expectedSolution[currentMoveIndex];
                            game.move(opponentMove);
                            board.position(game.fen());
                            currentMoveIndex++;
                        }, 500); // Delay to simulate opponent move
                    }

                    // Check if the puzzle is solved
=======
                    board.position(game.fen());
                    currentMoveIndex++;
>>>>>>> 295a1a5 (Documentation/Commenting final version)
                    if (currentMoveIndex >= expectedSolution.length) {
                        setTimeout(() => alert('Puzzle solved!'), 500);
                    }
                } else {
                    console.error(`Incorrect move! Expected: ${expectedSolution[currentMoveIndex]}, Got: ${moveSAN}`);
                    alert("Incorrect move! Try again.");
<<<<<<< HEAD
                    game.load(initialPuzzlePosition); // Reset to the initial puzzle position (FEN)
                    board.position(game.fen()); // Update the board to the initial puzzle position
                    currentMoveIndex = 0; // Reset the move index
                    return 'snapback'; // Return the piece to its original position
                }
            }

            // **Fix for pawn promotion visual issue**
            function updateBoardAfterPromotion() {
                board.position(game.fen()); // Ensure board updates visually
            }

            setInterval(updateBoardAfterPromotion, 100); // Keep checking for updates
=======
                    game.load(initialPuzzlePosition);
                    board.position(game.fen());
                    currentMoveIndex = 0;
                    return 'snapback';
                }
            }
>>>>>>> 295a1a5 (Documentation/Commenting final version)
        })
        .catch(error => {
            console.error("Error loading the puzzle:", error);
            displayErrorMessage("Failed to load the puzzle. Please try again later.");
        });
<<<<<<< HEAD

    function displayErrorMessage(message) {
        const errorElement = document.getElementById("error-message");
        errorElement.innerText = message;
        errorElement.style.display = "block";
    }
=======
>>>>>>> 295a1a5 (Documentation/Commenting final version)
});
