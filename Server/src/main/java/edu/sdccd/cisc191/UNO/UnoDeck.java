package edu.sdccd.cisc191.UNO;

import javafx.scene.Parent;

import javax.swing.*;
import java.util.*;

public class UnoDeck extends UnoCards {

    public String middleCard;
    public ArrayList<String> playerHand;
    public ArrayList<String> npcHand;

    public UnoDeck() {

        // random card in the middle
        middleCard = unoCards.get(0);
        unoCards.remove(0);

        // randomized playerHand
        for (int i = 1; i <= 7; i++) {
            playerHand.add(unoCards.get(0));
            unoCards.remove(0);
        }

        // randomized npcHand
        for (int i = 1; i <= 7; i++) {
            npcHand.add(unoCards.get(0));
            unoCards.remove(0);
        }
    }

    public ArrayList<String> drawCard(ArrayList<String> hand) {

        hand.add(unoCards.get(0));
        unoCards.remove(0);

        return hand;
    }

    public void wildCard() {


    }

    public void drawFour() {
        wildCard();

    }
}
