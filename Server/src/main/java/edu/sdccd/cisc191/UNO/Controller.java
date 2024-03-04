package edu.sdccd.cisc191.UNO;

import javafx.event.ActionEvent;

import java.util.ArrayList;

public class Controller extends UnoGameScreen{

    public UnoDeck deck = new UnoDeck();

    public void drawCard() {
        deck.drawCard(deck.playerHand);
    }

}
