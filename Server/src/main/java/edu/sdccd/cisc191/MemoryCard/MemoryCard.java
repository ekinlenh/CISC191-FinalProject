package edu.sdccd.cisc191.MemoryCard;

import javafx.scene.image.Image;

public class MemoryCard extends Card {
    private boolean matched;
    private boolean flipped;

    public MemoryCard(String suit, String faceName) {
        super(suit, faceName);
        this.matched = false;
        this.flipped = false;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {

        this.matched = matched;
    }

    public boolean isFlipped() {
        return flipped; // Return the flipped state of the card
    }

    public void flip() {
        flipped = !flipped; // Toggle the flipped state of the card
    }

    public Image getBackOfCardImage() {
        String pathName = "images/back_of_card.png";
        return null;
    }
        /**
         * This method returns true if the 2 MemoryCard objects
         * have the same suit and faceName
         */
        public boolean isSameCard (MemoryCard otherCard)
        {
            return (this.getSuit().equals(otherCard.getSuit()) &&
                    (this.getFaceName().equals(otherCard.getFaceName())));
        }
    }
