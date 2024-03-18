package edu.sdccd.cisc191.BlackJack;


import edu.sdccd.cisc191.BlackJack.Cards.Rank;
import edu.sdccd.cisc191.BlackJack.Cards.Suit;

public class CardsDeck {

    private Cards[] cards = new Cards[52];

    public CardsDeck() {
        refill();
    }

    /**
     * refills cards
     */
    public final void refill() {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[i++] = new Cards(suit, rank);
            }
        }
    }

    /**
     * draws card
     * @return the drawn card
     */
    public Cards drawCard() {
        Cards card = null;
        while (card == null) {
            int index = (int)(Math.random()*cards.length);
            card = cards[index];
            cards[index] = null;
        }
        return card;
    }
}