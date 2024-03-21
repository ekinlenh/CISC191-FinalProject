package edu.sdccd.cisc191.MemoryCard;


import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class Card {
    private String suit;
    private String faceName;

    public Card(String suit, String faceName) {
        setSuit(suit);
        setFaceName(faceName);
    }

    public String getSuit() {
        return suit;
    }

    public static List<String> getValidSuits()
    {
        return Arrays.asList("hearts","diamonds","clubs","spades");
    }

    /**
     * valid suits are "hearts","diamonds","clubs","spades"
     * @param suit
     */
    public void setSuit(String suit) {
        suit = suit.toLowerCase();
        if (getValidSuits().contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException(suit + " invalid, must be one of "+getValidSuits());
    }

    public String getFaceName() {
        return faceName;
    }

    public static List<String> getValidFaceNames()
    {
        return Arrays.asList("2","3","4","5","6","7","8","9","10","jack","queen","king","ace");
    }

    /**
     * valid face names are "2","3","4","5","6","7","8","9","10","jack","queen","king","ace"
     * @param faceName
     */
    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();
        if (getValidFaceNames().contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException(faceName + " is invalid, must be one of "+getFaceName());
    }

    public String toString()
    {
        return faceName + " of " + suit;
    }

    public String getColour()
    {
        if (suit.equals("hearts") || suit.equals("diamonds"))
            return "red";
        else
            return "black";
    }

    /**
     * This method will return the value of the card
     * [ "2","3","4","5","6","7","8","9","10","jack","queen","king","ace" ]
     *   0    1   2   3   4  ....                              11    12
     *   +2
     *
     */
    public int getValue()
    {
        return getValidFaceNames().indexOf(faceName) + 2;
    }

    /**
     * This method will return an Image that represents the Card
     */
    public Image getImage()
    {
        String pathName = "MemoryCardImages/"+faceName+"_of_"+suit+".png";
        return new Image((pathName));
    }

    public Image getBackOfCardImage()
    {
        return new Image(("images/back_of_card.png"));
    }
}