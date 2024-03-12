package edu.sdccd.cisc191.CoinFlip;

import edu.sdccd.cisc191.Scenes.ProgressScenes;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;

import java.util.Random;

import static edu.sdccd.cisc191.Scenes.ProgressScenes.changeScene;

public class CoinFlipAnimation extends CoinFlipGameScreen{

    /**
     * flips coin
     */
    public void flipCoin() {
        Random random = new Random();
        Image headsImage = new Image("heads.png");
        Image tailsImage = new Image("tails.png");

        if (random.nextInt(2)==1) {
            coinImage.setImage(headsImage);
            titleLabel.setText("HEADS");
            if (heads) {
                adventurer.addGold(bet * 2);
                gamesWon++;
                ProgressScenes.changeScene();
            } else {
                adventurer.subtractGold(5);
                updateLosses();
            }
        }

        else {
            coinImage.setImage(tailsImage);
            titleLabel.setText("TAILS");
            if (tails) {
                adventurer.addGold(bet * 2);
                gamesWon++;
                ProgressScenes.changeScene();
            } else {
                adventurer.subtractGold(5);
                updateLosses();
            }
        }
        updateGoldLabel();
        bet = 0;
    } //end flipCoin()
}
