package edu.sdccd.cisc191.MOT;

import edu.sdccd.cisc191.Scenes.AlertBox;

import java.util.*;

public class PlayerLogic {

    Deck motDeck = new Deck();
    Card middleCard;
    ArrayList<Card> playerHand = new ArrayList<Card>();
    ArrayList<Card> npcHand = new ArrayList<Card>();

    public PlayerLogic() {

        // Sets the middleCard
        middleCard = motDeck.deck.get(0);
        motDeck.deck.remove(0);

        // Adds 4 cards to playerHand from deck
        for (int i = 0; i < 4; i++) {
            playerHand.add(motDeck.deck.get(0));
            motDeck.deck.remove(0);
        }

        // Adds 4 cards to npcHand from deck
        for (int i = 0; i < 4; i++) {
            npcHand.add(motDeck.deck.get(0));
            motDeck.deck.remove(0);
        }
    }

    public void drawPlayerCard() {
        if (playerHand.size() < 7) {
            playerHand.add(motDeck.deck.get(0));
            motDeck.deck.remove(0);
        }
        else {
            AlertBox.display("Card out of bounds", "You cannot draw a card when at max.");
        }
    }

    public void drawNPCCard() {
        if (npcHand.size() < 7) {
            npcHand.add(motDeck.deck.get(0));
            motDeck.deck.remove(0);
        }
        else {
            AlertBox.display("Card out of bounds", "the NPC brokey ;(");
        }
    }

    public void playCard(int i) {

        if (playerHand.get(i).color.equals(middleCard.color)) {
            middleCard = playerHand.get(i);
            playerHand.remove(i);
        }
        else if (playerHand.get(i).name.equals(middleCard.name)) {
            middleCard = playerHand.get(i);
            playerHand.remove(i);
        }
        else if (playerHand.get(i).name.equals("draw2")) {
            drawNPCCard();
            drawNPCCard();
        }
        else if (playerHand.get(i).name.equals("wildDraw4")) {
            drawNPCCard();
            drawNPCCard();
            drawNPCCard();
            drawNPCCard();
        }
        System.out.println("card" + i);
    }

    public void playWild() {

    }

    public void skipTurn() {

    }
}
