package edu.sdccd.cisc191.CoinFlip;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.util.Random;

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
            } else {
                adventurer.subtractGold(5);
            }
        }

        else {
            coinImage.setImage(tailsImage);
            titleLabel.setText("TAILS");
            if (tails) {
                adventurer.addGold(bet * 2);
            } else {
                adventurer.subtractGold(5);
            }
        }
        updateGoldLabel();
        bet = 0;
    } //end flipCoin()
}
