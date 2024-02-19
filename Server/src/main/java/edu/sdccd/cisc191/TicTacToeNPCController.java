package edu.sdccd.cisc191;

import javafx.scene.control.Button;

import java.util.Random;

public class TicTacToeNPCController extends TicTacToeButtonController {

    private static final Random random = new Random();

    /**
     * lets NPC do his turn
     */
    public void makeMove() {
        int randomIndex;

        do {
            randomIndex = random.nextInt(9); //finds a random slot
        } while(!buttons[randomIndex].getText().isEmpty()); //checks to see if slot is open or not

        Button selectedButton = buttons[randomIndex];
        selectedButton.setText("O");
        selectedButton.setDisable(true);
        selectedButton.setOpacity(1);
    } //end makeMove()

}
