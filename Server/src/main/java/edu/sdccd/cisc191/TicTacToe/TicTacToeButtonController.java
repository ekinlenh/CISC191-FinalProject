package edu.sdccd.cisc191.TicTacToe;

import edu.sdccd.cisc191.Scenes.ProgressScenes;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class TicTacToeButtonController extends TicTacToeGameScreen{
    protected static TicTacToeNPCController npcController = new TicTacToeNPCController();
    protected static boolean gameOver = false;

    /**
     * creates buttons for the TicTacToe board
     */
    public void createButtons() {
        formatButton(buttons);
        npcController.makeNPCMove();
        for (Button[] button: buttons) {
            for (Button b : button) {
                b.setOnMouseClicked(e -> {
                    b.setText("X");
                    b.setDisable(true);
                    b.setOpacity(1);
                    checkGameOver();
                    if (!gameOver) {
                        npcController.makeNPCMove();
                        checkGameOver();
                    }
                });
            }
        } //end for-each loop
    } //end createButtons()

    /**
     * format buttons
     *
     * @param buttonsList takes in buttons array to format
     */
    public static void formatButton(Button[][] buttonsList) {
        for (Button[] buttons: buttonsList) {
            for (Button button: buttons) {
                button.setPrefWidth(170);
                button.setPrefHeight(170);
                button.setFont(new Font("Elephant", 48));
                button.setStyle("-fx-background-color: #4a6741; -fx-text-fill: white");
            }
        }
    } //end formatButton()

    /**
     * checks to see if game is over
     */
    public void checkGameOver(){
        for (int i=0; i<buttons.length; i++) {
            boolean rows = (buttons[i][0].getText().equals(buttons[i][1].getText())) &&
                    (buttons[i][1].getText().equals(buttons[i][2].getText())) && (!buttons[i][0].getText().isEmpty());
            boolean cols = (buttons[0][i].getText().equals(buttons[1][i].getText())) &&
                    (buttons[1][i].getText().equals(buttons[2][i].getText())) && (!buttons[0][i].getText().isEmpty());

            if (rows) {
                if (buttons[i][1].getText().equals("X")) {
                    label.setText("You won!");
                    gamesWon++;
                    ProgressScenes.changeScene();
                } else {
                    label.setText("You lost!");
                    adventurer.subtractGold(5);
                    updateLosses();
                }
                gameOver = true;
                endGame();
            } //end rows condition

            else if (cols) {
                if (buttons[1][i].getText().equals("X")) {
                    label.setText("You won!");
                    gamesWon++;
                    ProgressScenes.changeScene();
                } else {
                    label.setText("You lost!");
                    adventurer.subtractGold(5);
                    updateLosses();
                }
                gameOver = true;
                endGame();
            } //end cols condition
        } //end for loop

        boolean topLeftDiagonal = (buttons[0][0].getText().equals(buttons[1][1].getText())) &&
                (buttons[1][1].getText().equals(buttons[2][2].getText())) && (!buttons[1][1].getText().isEmpty());
        boolean topRightDiagonal = (buttons[0][2].getText().equals(buttons[1][1].getText())) &&
                (buttons[1][1].getText().equals(buttons[2][0].getText())) && (!buttons[1][1].getText().isEmpty());

        if (topLeftDiagonal || topRightDiagonal) {
            if (buttons[1][1].getText().equals("X")) {
                label.setText("You won!");
                gamesWon++;
                ProgressScenes.changeScene();
            } else {
                label.setText("You lost!");
                updateLosses();
            }
            gameOver = true;
            endGame();
        }

        checkDraw();
    }

    /**
     * checks for a draw
     */
    private void checkDraw() {
        int count=0;
        for (Button[] button : buttons) {
            for (Button b: button) {
                if (!(b.getText().isEmpty() || gameOver)) {
                    count++;
                }
            }
        }

        if (count == 9) {
            label.setText("It's a draw!");
            endGame();
        }
    } //end checkDraw()

    /**
     * if someone won/if there's a draw, end game by disabling all buttons
     */
    private static void endGame() {
        for (Button[] button: buttons) {
            for (Button b: button) {
                b.setDisable(true);
            }
        }
        exitGame.setVisible(true);
    } //end endGame()

}