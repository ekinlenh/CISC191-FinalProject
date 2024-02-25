package edu.sdccd.cisc191.TicTacToe;

import javafx.scene.control.Button;

import java.util.Random;

public class TicTacToeNPCController extends TicTacToeButtonController {

    private static final Random random = new Random();

    /**
     * lets NPC move
     */
    public void makeNPCMove() {
        int row, col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
            //finds a random slot
        } while(!buttons[row][col].getText().isEmpty()); //checks to see if slot is open or not

        Button selectedButton = buttons[row][col];
        selectedButton.setText("O");
        selectedButton.setDisable(true);
        selectedButton.setOpacity(1);
    } //end makeNPCMove()
}
