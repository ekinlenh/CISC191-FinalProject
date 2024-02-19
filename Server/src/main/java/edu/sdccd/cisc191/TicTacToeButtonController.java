package edu.sdccd.cisc191;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class TicTacToeButtonController extends TicTacToeGameScreen{

    protected static Button button1 = new Button();
    protected static Button button2 = new Button();
    protected static Button button3 = new Button();
    protected static Button button4 = new Button();
    protected static Button button5 = new Button();
    protected static Button button6 = new Button();
    protected static Button button7 = new Button();
    protected static Button button8 = new Button();
    protected static Button button9 = new Button();
    protected static Button[] buttons = {button1, button2, button3, button4, button5, button6, button7, button8, button9};
    protected static TicTacToeNPCController npcController = new TicTacToeNPCController();
    protected boolean gameOver = false;

    /**
     * creates buttons for the TicTacToe board
     */
    public void createButtons() {
        formatButton(buttons);

        npcController.makeMove();
        for (Button button: buttons) {
            button.setOnMouseClicked(e -> {
                button.setText("X");
                button.setDisable(true);
                button.setOpacity(1);
                checkGameOver();
                if (!gameOver) {
                    npcController.makeMove();
                }
                checkGameOver();
            });
        }

        board.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7, button8, button9);
    } //end createButtons()

    /**
     * format buttons
     * @param buttons takes in buttons array to format
     */
    private void formatButton(Button[] buttons) {
        for (Button button: buttons) {
            button.setPrefWidth(170);
            button.setPrefHeight(170);
            button.setFont(new Font("Times New Roman", 48));
        }
    } //end formatButton()

    /**
     * checks to see if game is over
     */
    public void checkGameOver(){
        for (int i=0; i<3; i++) {
            boolean rows = (buttons[i * 3].getText().equals(buttons[i * 3 + 1].getText())) &&
                    (buttons[i * 3 + 1].getText().equals(buttons[i * 3 + 2].getText())) && (!buttons[i * 3].getText().isEmpty());
            boolean cols = (buttons[i].getText().equals(buttons[i + 3].getText())) &&
                    (buttons[i + 3].getText().equals(buttons[i + 6].getText())) && (!buttons[i].getText().isEmpty());

            if (rows) {
                if (buttons[i].getText().equals("X")) {
                    label.setText("You won!");
                } else {
                    label.setText("You lost!");
                }
                gameOver = true;
                endGame();
            }

            else if (cols) {
                if (buttons[i+3].getText().equals("X")) {
                    label.setText("You won!");
                } else {
                    label.setText("You lost!");
                }
                gameOver = true;
                endGame();
            }

            boolean topLeftDiagonal = ((buttons[0].getText().equals(buttons[4].getText())) && (buttons[4].getText().equals(buttons[8].getText())) && (!buttons[4].getText().isEmpty()));
            boolean topRightDiagonal = ((buttons[2].getText().equals(buttons[4].getText())) && (buttons[4].getText().equals(buttons[6].getText())) && (!buttons[4].getText().isEmpty()));
            if (topLeftDiagonal || topRightDiagonal) {
                if (buttons[4].getText().equals("X")) {
                    label.setText("You won!");
                } else {
                    label.setText("You lost!");
                }
                gameOver = true;
                endGame();
            }
        }
        checkDraw();
    }

    /**
     * checks for a draw
     */
    private void checkDraw() {
        int count=0;
        for (Button button : buttons) {
            if (!(button.getText().isEmpty() || gameOver)) {
                count++;
            }
        }

        if (count == 9) {
            label.setText("It's a draw!");
            endGame();
        }
    }

    //if someone won/if there's a draw, end game by disabling all buttons
    private void endGame() {
        for (Button button: buttons) {
            button.setDisable(true);
        }
    }
}
