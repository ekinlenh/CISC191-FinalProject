package edu.sdccd.cisc191.MachingCards;

public class Card {
    private char symbol;
    private boolean isMatched;
    private boolean isFaceUp;

    public Card(char symbol) {
        this.symbol = symbol;
        this.isMatched = false;
        this.isFaceUp = false;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }
}



