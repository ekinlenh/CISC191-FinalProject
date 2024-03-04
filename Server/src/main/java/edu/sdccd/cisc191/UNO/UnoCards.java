package edu.sdccd.cisc191.UNO;

import javafx.scene.Parent;
import java.util.*;

public class UnoCards {

    public ArrayList<String> unoCards;

    public UnoCards() {

        unoCards = new ArrayList<String>();

        // iterate color of the cards
        for (int i = 0; i <= 3; i++) {

            String[] colorList = {"blue_", "green_", "red_", "yellow_"};

            String color = colorList[i];

            // add number 0 card to ArrayList
            unoCards.add(color + "0");

            // iterate number of the cards #1 and add to ArrayList
            // Example: blue_5_#1
            for (int j = 1; j <= 9; j++) {
                unoCards.add(color + j + "_#1");
            }

            // iterate number of the cards #2 and add to ArrayList
            // Example: blue_5_#2
            for (int j = 1; j <= 9; j++) {
                unoCards.add(color + j + "_#2");
            }

            // add +2 cards to ArrayList
            unoCards.add(color + "picker" + "_#1");
            unoCards.add(color + "picker" + "_#2");

            // add reverse cards to ArrayList
            unoCards.add(color + "reverse" + "_#1");
            unoCards.add(color + "reverse" + "_#2");

            // add skip cards to ArrayList
            unoCards.add(color + "skip" + "_#1");
            unoCards.add(color + "skip" + "_#2");
        }

        // adds 4 wild cards to ArrayList
        for (int i = 1; i <= 4; i++) {
            unoCards.add("wild_color_changer" + "_#" + i);
        }

        // adds 4 wild draw 4 cards to ArrayList
        for (int i = 1; i <= 4; i++) {
            unoCards.add("wild_pick_four" + "_#" + i);
        }

        // Shuffle Deck of cards
        Collections.shuffle(unoCards);
    }
}
