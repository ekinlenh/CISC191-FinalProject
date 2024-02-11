package edu.sdccd.cisc191.template;

import java.util.*;

public class TicTacToe extends Player {
    private final char[][] ticTacToe = new char[3][3];
    private boolean gameEnd = false;

    private String playerWinner;

    /*
     * sets up TicTacToe board
     */
    public void drawBoard() {
        //for loop for initializing board
        for (char[] chars : ticTacToe) {
            Arrays.fill(chars, '-');
        }
    } //end drawBoard()

    /*
     * asks player for where they want to place
     */
    public void askPlayerPosition() {
        Scanner keyboard = new Scanner(System.in);
        int row, col;
        boolean turnDone = false;

        while (!turnDone) {
            boolean outOfBounds;
            System.out.println("Enter your row number: ");
            row = keyboard.nextInt() - 1;
            System.out.println("Enter your col number: ");
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
        if (checkWinner()) {
            gameEnd = true;
        }
    } //end askPlayerPosition()

    public void askNPCPosition() {
        if (checkWinner()) {
            gameEnd = true;
        }

        if (!gameEnd) {
            int row, col;
            boolean turnDone = false;

            while (!turnDone) {
                boolean outOfBounds;
                row = (int) (Math.random() * 3);
                col = (int) (Math.random() * 3);

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
        }
    } //end askNPCPosition()

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

    /*
     * check who won
     * @param takes in player's name
     * @return if someone won or not
     */
    public boolean checkWinner() {
        //loop through board to see if someone won
        for (int i = 0; i < ticTacToe.length - 1; i++) {

            //check rows to see if there's 3 in a row
            if (ticTacToe[i][0] == ticTacToe[i][1] && ticTacToe[i][1] == ticTacToe[i][2] && ticTacToe[i][0] != '-') {
                if (ticTacToe[i][0] == 'X') {
                    playerWinner = "Yes";
                } else if (ticTacToe[i][0] == 'O') {
                    playerWinner = "No";
                }
                return true;
            }
            //check cols to see if there's 3 in a col
            if (ticTacToe[0][i] == ticTacToe[1][i] && ticTacToe[1][i] == ticTacToe[2][i] && ticTacToe[0][i] != '-') {
                if (ticTacToe[0][i] == 'X') {
                    playerWinner = "Yes";
                } else if (ticTacToe[0][i] == 'O') {
                    playerWinner = "No";
                }
                return true;
            }
        }

        //check top left diagonal and top right diagonal to see if one is true
        boolean topLeftDiagonal = (ticTacToe[0][0] == ticTacToe[1][1]) && (ticTacToe[1][1] == ticTacToe[2][2] && ticTacToe[0][0] != '-');
        boolean topRightDiagonal = (ticTacToe[0][2] == ticTacToe[1][1]) && (ticTacToe[1][1] == ticTacToe[2][0] && ticTacToe[0][2] != '-');
        if ((topLeftDiagonal) || (topRightDiagonal)) {
            if (ticTacToe[1][1] == 'X') {
                playerWinner = "Yes";
            } else if (ticTacToe[1][1] == 'O') {
                playerWinner = "No";
            }
            return true;
        }

        // Check for a draw
        if (checkDraw()) {
            playerWinner = "Draw";
        }

        //if no cases were true, game has not ended yet
        return false;
    } //end checkWinner()

    /*
     * begins game
     */
    public void beginGame() {

        //loop through game till someone wins
        do {
            //showing board
            for (char[] chars : ticTacToe) {
                System.out.println(Arrays.toString(chars));
            }

            //player's turn and checks if they won
            askPlayerPosition();

            //NPC's turn and checks if they won
            askNPCPosition();

        } while (!gameEnd);

        //show game board once ended
        for (char[] chars : ticTacToe) {
            System.out.println(Arrays.toString(chars));
        }

        if (playerWinner.equalsIgnoreCase("Yes")) {
            System.out.println("Congratulations! " + "Adventurer" + ", you won!");
        } else if (playerWinner.equalsIgnoreCase("No")) {
            System.out.println("Ouch! Better luck next time.");
        } else {
            System.out.println("It's a draw!");
        }
    } //end beginGame()

} //end class
