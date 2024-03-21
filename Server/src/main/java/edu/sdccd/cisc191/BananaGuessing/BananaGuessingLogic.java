package edu.sdccd.cisc191.BananaGuessing;

import edu.sdccd.cisc191.Scenes.AlertBox;
import edu.sdccd.cisc191.Scenes.ProgressScenes;
import javafx.scene.image.Image;

import java.util.Random;

import static java.lang.Math.abs;

public class BananaGuessingLogic extends BananaGuessingGameScreen {

    private static final Random random = new Random();

    /**
     * checks player's guess
     */
    public static void checkGuess() {
        try {
            int answer = random.nextInt(10) + 1;
            int guess = Integer.parseInt(guessTextField.getText());
            int difference = answer - guess;

            //check to make sure guess is valid
            if (guess > 10 || guess < 1) {
                AlertBox.display("Invalid Number", "That's not a valid number. Try again.");
            } else {
                guessTextField.setDisable(true);
                exitButton.setVisible(true);
                boxImage.setImage(new Image("BananaGuessing/banana"+answer+".png"));
                if (abs(difference) >= 7) {
                    fatMonkeyText.setText("HAHA SO FAR OFF");
                    rockyText.setText("Maybe next time...");
                    updateLosses();
                } else if (abs(difference) >= 3) {
                    fatMonkeyText.setText("HAHA ALMOST LOSER");
                    rockyText.setText("We were so close!");
                    updateLosses();
                } else if (abs(difference) >= 1) {
                    fatMonkeyText.setText("HOW!!!");
                    rockyText.setText("We did it!");
                    gamesWon++;
                    ProgressScenes.changeScene();
                } else {
                    fatMonkeyText.setText("YOU CHEATED!!!");
                    rockyText.setText("Way to go!");
                    gamesWon++;
                    ProgressScenes.changeScene();
                }
            }
        } catch (Exception e) {
            AlertBox.display("Error", "We could not process that. Try again.");
        }
    } //end checkGuess()
}
