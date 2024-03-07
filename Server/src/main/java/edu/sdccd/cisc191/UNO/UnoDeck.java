package edu.sdccd.cisc191.UNO;

import javafx.scene.Parent;
import javax.swing.*;
import java.util.*;

public class UnoDeck {

    public UnoCards cards = new UnoCards();
    public String middleCard;
    public ArrayList<String> playerHand = new ArrayList<String>();
    public ArrayList<String> npcHand = new ArrayList<String>();

    public UnoDeck() {

        // random card in the middle
        middleCard = cards.unoCards.get(0);
        cards.unoCards.remove(0);

        // randomized playerHand
        for (int i = 1; i <= 7; i++) {
            playerHand.add(cards.unoCards.get(0));
            cards.unoCards.remove(0);
        }

        // randomized npcHand
        for (int i = 1; i <= 7; i++) {
            npcHand.add(cards.unoCards.get(0));
            cards.unoCards.remove(0);
        }
    }

    public ArrayList<String> drawCard(ArrayList<String> hand) {

        hand.add(cards.unoCards.get(0));
        cards.unoCards.remove(0);

        return hand;
    }

    public void wildCard() {


    }

    /**
     * Draws 4 cards to the inputted hand
     * @param hand
     * @return
     */
    public ArrayList<String> drawFour(ArrayList<String> hand) {  //will fix all these methods at a later date

        wildCard();

        for (int i = 1; i <= 4; i++) {
        hand.add(cards.unoCards.get(0));
        cards.unoCards.remove(0);
        }

        return hand;
    }
}
