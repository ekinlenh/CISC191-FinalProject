package edu.sdccd.cisc191.MOT;

import javafx.scene.image.*;
import java.util.*;

class Deck {

    ArrayList<Card> deck;

    Deck() {

        deck = new ArrayList<Card>();

        String[] colors = {"blue", "green", "red", "yellow"};
        int num = 1;

        // Add each color (red, blue, green, yellow)
        for (int i = 0; i <= 3; i++) {

            // Add 0 card
            deck.add(new Card(colors[i], String.valueOf(0), "MOTCards/" + colors[i] + "_0" + ".png"));

            // Add 2 of each 1-9 cards (18 total)
            for (int j = 0; j < 2; j++) {
                // Add 1-9 cards
                for (int k = 0; k < 9; k++) {
                    deck.add(new Card(colors[i], String.valueOf(k), "MOTCards/" + colors[i] + "_" + String.valueOf(k) + ".png"));
                }
            }

            // Add 2 draw2 cards
//            for (int j = 0; j < 2; j++) {
//                deck.add(new Card(colors[i], "draw2", "MOTCards/" + colors[i] + "_picker" + ".png"));
//            }

            // Add 2 Reverse cards
            for (int j = 0; j < 2; j++) {
                deck.add(new Card(colors[i], "reverse", "MOTCards/" + colors[i] + "_reverse" + ".png"));
            }

            // Add 2 skip cards
            for (int j = 0; j < 2; j++) {
                deck.add(new Card(colors[i], "skip", "MOTCards/" + colors[i] + "_skip" + ".png"));
            }

            // Add Wild card
            deck.add(new Card("wild", "wild", "MOTCards/" + "wild_color_changer" + ".png"));

            // Add wildDraw4 card
//            deck.add(new Card("wild", "wildDraw4", "MOTCards/" + "wild_pick_four" + ".png"));
        }

        Collections.shuffle(deck);
    }
}
