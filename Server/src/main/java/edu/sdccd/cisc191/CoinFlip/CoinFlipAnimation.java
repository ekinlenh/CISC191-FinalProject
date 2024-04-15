package edu.sdccd.cisc191.CoinFlip;

import edu.sdccd.cisc191.Scenes.ProgressScenes;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.Random;

import static edu.sdccd.cisc191.Scenes.ProgressScenes.changeScene;

public class CoinFlipAnimation extends CoinFlipGameScreen {

    /**
     * flips coin
     */
    public static void flipCoin() {
        Random random = new Random();
        Image headsImage = new Image("heads.png");
        Image tailsImage = new Image("tails.png");

        // Create a rotate transition for the coin flip animation
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.5), coinImage);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setCycleCount(5);

        rotateTransition.play();
        rotateTransition.setOnFinished(e -> {
            if (random.nextInt(2) == 1) {
                coinImage.setImage(headsImage);
                titleLabel.setText("HEADS");
                if (heads) {
                    ProgressScenes.changeScene();
                    rockyText.setText("I knew I could count \non you " + adventurer.getPlayerName() + "!");
                    businessText.setText("..no..how can this be?");
                } else {
                    updateLosses();
                    rockyText.setText("I'm sorry, " + adventurer.getPlayerName() + " I failed you.");
                    businessText.setText("Hah! You chose wrong. \nA disgrace you are.");
                }
            } else {
                coinImage.setImage(tailsImage);
                titleLabel.setText("TAILS");
                if (tails) {
                    ProgressScenes.changeScene();
                    rockyText.setText("I knew I could count \non you " + adventurer.getPlayerName() + "!");
                    businessText.setText("..no..how can this be?");
                } else {
                    updateLosses();
                    rockyText.setText("I'm sorry, " + adventurer.getPlayerName() + " I failed you.");
                    businessText.setText("Hah! You chose wrong. \nA disgrace you are.");
                }
            }

            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> exitButton.setVisible(true));
            pause.play();
        });

    } //end flipCoin()
}
