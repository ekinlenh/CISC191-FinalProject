package edu.sdccd.cisc191.MemoryCard;

public class MemoryCard extends Card{
    private boolean matched;

    public MemoryCard(String suit, String faceName) {
        super(suit, faceName);
        this.matched = false;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    /**
     * This method returns true if the 2 MemoryCard objects
     * have the same suit and faceName
     */
    public boolean isSameCard(MemoryCard otherCard)
    {
        return (this.getSuit().equals(otherCard.getSuit()) &&
                (this.getFaceName().equals(otherCard.getFaceName())));
    }
}
