package edu.sdccd.cisc191.MOT;

import edu.sdccd.cisc191.Scenes.AlertBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.*;

public class PlayerLogic {

    Deck motDeck = new Deck();
    Card middleCard;
    ArrayList<Card> playerHand = new ArrayList<>();
    ArrayList<Card> npcHand = new ArrayList<>();

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

        if (playerHand.get(i).color.equals(middleCard.color) || playerHand.get(i).value.equals(middleCard.value) || playerHand.get(i).value.equals("wild")) {
            switch (playerHand.get(i).value) {
                case "draw2":
                    drawNPCCard();
                    drawNPCCard();
                    break;
                case "skip":
                    skipTurn();
                    break;
                case "reverse":
                    reverseTurn();
                    break;
                case "wild":
                    playWild();
                    break;
                case "wildDraw4":
                    playWild();
                    drawNPCCard();
                    drawNPCCard();
                    drawNPCCard();
                    drawNPCCard();
                    break;
            }
            middleCard = playerHand.get(i);
            playerHand.remove(i);
        }

        System.out.println("card" + i);
    }

    public void playWild() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(200);
        window.setMinHeight(100);
        window.setResizable(false);

        Button red = new Button();
        red.setLayoutX(0.0);
        red.setLayoutY(0.0);
        red.setMnemonicParsing(false);
        red.setPrefHeight(100.0);
        red.setPrefWidth(100.0);
        red.setGraphic(new ImageView(new Image("MOTCards/red_card.png")));
        red.setOnAction(event -> {middleCard.setColor("red"); window.close();});

        Button yellow = new Button();
        yellow.setLayoutX(100.0);
        yellow.setLayoutY(0.0);
        yellow.setMnemonicParsing(false);
        yellow.setPrefHeight(100.0);
        yellow.setPrefWidth(100.0);
        yellow.setGraphic(new ImageView(new Image("MOTCards/yellow_card.png")));
        yellow.setOnAction(event -> {middleCard.setColor("yellow"); window.close();});

        Button green = new Button();
        green.setLayoutX(0.0);
        green.setLayoutY(100.0);
        green.setMnemonicParsing(false);
        green.setPrefHeight(100.0);
        green.setPrefWidth(100.0);
        green.setGraphic(new ImageView(new Image("MOTCards/green_card.png")));
        green.setOnAction(event -> {middleCard.setColor("green"); window.close();});

        Button blue = new Button();
        blue.setLayoutX(100.0);
        blue.setLayoutY(100.0);
        blue.setMnemonicParsing(false);
        blue.setPrefHeight(100.0);
        blue.setPrefWidth(100.0);
        blue.setGraphic(new ImageView(new Image("MOTCards/blue_card.png")));
        blue.setOnAction(event -> {middleCard.setColor("blue"); window.close();});

        BorderPane layout = new BorderPane();
        HBox close = new HBox();
        close.getChildren().addAll(red, yellow, green, blue);
        close.setAlignment(Pos.CENTER);
        layout.setBottom(close);
        layout.setStyle("-fx-background-color: #6F4E37");

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public void skipTurn() {

    }

    public void reverseTurn() {

    }
}
