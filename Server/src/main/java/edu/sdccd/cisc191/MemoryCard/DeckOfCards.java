package edu.sdccd.cisc191.MemoryCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private ArrayList<Card> deck;

    public DeckOfCards() {
        this.deck = new ArrayList<>();
        List<String> suits = Card.getValidSuits();
        List<String> faceNames = Card.getValidFaceNames();

        for (String suit : suits)
        {
            for (String faceName : faceNames)
            {
                deck.add(new Card(suit,faceName));
            }
        }
    }

    /**
     * This method will shuffle the card objects
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    /**
     * This method will return the top card from the deck.
     * If the deck is empty, it will return null
     */
    public Card dealTopCard()
    {
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }

    /**
     * This returns the number of cards left in the deck
     */
    public int getNumOfCards()
    {
        return deck.size();
    }
}
