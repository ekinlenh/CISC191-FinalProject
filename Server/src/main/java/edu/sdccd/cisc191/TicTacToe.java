package edu.sdccd.cisc191;

import java.util.*;

/**
 * TicTacToe game
 */
public class TicTacToe extends RandomEvent {
    private final char[][] ticTacToe = new char[3][3];
    private boolean gameEnd = false;

    /**
     * sets up TicTacToe board
     */
    public void drawBoard() {
        //for loop for initializing board
        for (char[] chars : ticTacToe) {
            Arrays.fill(chars, '-');
        }
    } //end drawBoard()

    /**
     * shows board placements
     */
    public void showBoard() {
        for (char[] chars : ticTacToe) {
            System.out.println(Arrays.toString(chars));
        }
    } //end showBoard()

    /**
     * asks player for where they want to place
     */
    public void askPlayerPosition() {
        Scanner keyboard = new Scanner(System.in);
        int row, col;
        boolean turnDone = false;

        while (!turnDone) {
            boolean outOfBounds;
            System.out.print("Enter your row number: ");
            row = keyboard.nextInt() - 1;
            System.out.print("Enter your col number: ");
            col = keyboard.nextInt() - 1;

            // Check if the position is out of bounds
            if (row < 0 || row >= ticTacToe.length || col < 0 || col >= ticTacToe.length) {
                outOfBounds = true;
            } else {
                outOfBounds = false;
            }

            //if user input wasn't out of bounds/position wasn't taken, we can end turn
            if (!outOfBounds && ticTacToe[row][col] == '-') {
                ticTacToe[row][col] = 'X';
                turnDone = true;
            } else {
                System.out.println("Sorry, that place is taken/out of bounds. Try again.");
            }
        }
    } //end askPlayerPosition()

    /**
     * asks NPC for where they want to place
     */
    public void askNPCPosition() {
        int row, col;
        boolean turnDone = false;

        while(!turnDone) {
            boolean outOfBounds;
            row = (int)(Math.random() * 3);
            col = (int)(Math.random() * 3);

            if (row < 0 || row >= ticTacToe.length || col < 0 || col >= ticTacToe.length) {
                outOfBounds = true;
            } else {
                outOfBounds = false;
            }

            if (!outOfBounds && ticTacToe[row][col] == '-') {
                ticTacToe[row][col] = 'O';
                turnDone = true;
            }
        } //end turn
    } //end askNPCPosition()

    /**
     * checks if the game is a draw
     * @return true if there's a draw and false is there isn't
     */
    public boolean checkDraw() {
        boolean draw = false;
        int count = 0;
        for (int i = 0; i < ticTacToe.length; i++) {
            for (int j = 0; j < ticTacToe[i].length; j++) {
                if (ticTacToe[i][j] != '-') {
                    count++;
                }
            }
        }
        if (count == 9) {
            draw = true;
        }
        return draw;
    } //end checkDraw()

    /**
     * check who won
     * @return if someone won or not
     */
    public boolean checkWinner() {
        //loop through board to see if someone won
        for (int i = 0; i < ticTacToe.length; i++) {
            //check rows to see if there's 3 in a row
            boolean rows = (ticTacToe[i][0] == ticTacToe[i][1]) && (ticTacToe[i][1] == ticTacToe[i][2]) && (ticTacToe[i][0] != '-');
            boolean cols = (ticTacToe[0][i] == ticTacToe[1][i]) && (ticTacToe[1][i] == ticTacToe[2][i]) && (ticTacToe[0][i] != '-');

            if (rows) {
                if (ticTacToe[i][0] == 'X') {
                    System.out.println();
                    showBoard();
                    winGame();
                }
                else {
                    System.out.println();
                    showBoard();
                    loseGame();
                }
                return true;
            }
            //check cols to see if there's 3 in a col
            else if (cols){
                if (ticTacToe[0][i] == 'X') {
                    System.out.println();
                    showBoard();
                    winGame();
                }
                else {
                    System.out.println();
                    showBoard();
                    loseGame();
                }
                return true;
            }
        }

        //check top left diagonal and top right diagonal to see if one is true
        boolean topLeftDiagonal = (ticTacToe[0][0] == ticTacToe[1][1]) && (ticTacToe[1][1] == ticTacToe[2][2] && ticTacToe[0][0] != '-');
        boolean topRightDiagonal = (ticTacToe[0][2] == ticTacToe[1][1]) && (ticTacToe[1][1] == ticTacToe[2][0] && ticTacToe[0][2] != '-');
        if ((topLeftDiagonal) || (topRightDiagonal)) {
            if (ticTacToe[1][1] == 'X') {
                System.out.println();
                showBoard();
                winGame();
            }
            else {
                System.out.println();
                showBoard();
                loseGame();
            }
            return true;
        }
        if (checkDraw()) {
            showBoard();
            System.out.println("It's a draw! You will lose nothing, but will gain nothing." );
            return true;
        }

        //if no cases were true, game has not ended yet
        return false;
    } //end checkWinner()

    /**
     * begins game
     */
    public void beginGame() {

        //loop through game till someone wins
        do {
            //showing board
            showBoard();

            // player's turn and checks if they won
            System.out.println("\nPlayer's turn:");
            askPlayerPosition();
            if (checkWinner()) {
                gameEnd = true;
                break;
            }

            // NPC's turn and checks if they won
            System.out.println("\nNPC's turn:");
            askNPCPosition();
            if (checkWinner()) {
                gameEnd = true;
                break;
            }

            // Check for a draw
            if (checkDraw()) {
                System.out.println("It's a draw! You will lose nothing, but will gain nothing." );
                gameEnd = true;
            }
        } while(!gameEnd);
    } //end beginGame()
} //end class
