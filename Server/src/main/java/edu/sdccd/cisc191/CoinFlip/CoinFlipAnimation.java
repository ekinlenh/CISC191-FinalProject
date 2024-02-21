package edu.sdccd.cisc191.CoinFlip;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.util.Random;

public class CoinFlipAnimation extends CoinFlipGameScreen{

    public void flipCoin() {
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            coinImage.setImage(new Image(heads));
            adventurer.addGold(bet * 2);
            goldLabel.setText("GOLD: " + adventurer.getGold());
            bet = 0;

        } else {
            coinImage.setImage(new Image(tails));
            goldLabel.setText("GOLD: " + adventurer.getGold());
            bet = 0;
        }
    } //end flipCoin()
}
