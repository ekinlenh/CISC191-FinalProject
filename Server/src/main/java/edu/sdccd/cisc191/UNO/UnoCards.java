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

            // iterate 2 times
            for (int k = 1; k <= 2; k++) {

                // iterate number of the cards and add to ArrayList
                for (int j = 1; j <= 9; j++) {
                    unoCards.add(color + j);
                }

                // add +2 cards to ArrayList
                unoCards.add(color + "picker");

                // add reverse cards to ArrayList
                unoCards.add(color + "reverse");

                // add skip cards to ArrayList
                unoCards.add(color + "skip");
            }
        }

        // adds 4 wild cards to ArrayList
        for (int i = 1; i <= 4; i++) {
            unoCards.add("wild_color_changer");
            unoCards.add("wild_pick_four");
        }

        // Shuffle Deck of cards
        Collections.shuffle(unoCards);
    }
}
