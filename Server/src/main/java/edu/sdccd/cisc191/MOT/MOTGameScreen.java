package edu.sdccd.cisc191.MOT;

import edu.sdccd.cisc191.Scenes.AlertBox;
import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.util.*;


public class MOTGameScreen extends SceneController {

    MOTLogic MOTLogic = new MOTLogic();
    Random rand = new Random();
    Button exitButton, deckButton;
    Button[] buttonList;
    ImageView middleCardImage, colorCard;
    ImageView[] npcCardList;

    public void createMOT() {

        AnchorPane root = new AnchorPane();
        int temp = games.indexOf("MOT");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        root.setBackground(new Background(bgImage));

        exitButton = new Button();
        exitButton.setLayoutX(14.0);
        exitButton.setLayoutY(324.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setPrefHeight(52.0);
        exitButton.setPrefWidth(92.0);
        exitButton.setText("Exit");
        exitButton.setOnAction(event -> createMainScreen());

        deckButton = new Button();
        deckButton.setLayoutX(370.0);
        deckButton.setLayoutY(259.0);
        deckButton.setMnemonicParsing(false);
        deckButton.setPrefHeight(182.0);
        deckButton.setPrefWidth(130.0);
        deckButton.setGraphic(new ImageView(new Image("MOTCards/card_back.png")));
        deckButton.setOnAction(event -> {
            MOTLogic.drawPlayerCard(); refreshCards();});

        middleCardImage = new ImageView();
        middleCardImage.setLayoutX(525.0);
        middleCardImage.setLayoutY(259.0);
        middleCardImage.setFitHeight(182.0);
        middleCardImage.setFitWidth(130.0);
        middleCardImage.setPickOnBounds(true);
        middleCardImage.setPreserveRatio(true);
        middleCardImage.setImage(new Image(MOTLogic.middleCard.image));

        // Color card in the middle displaying current color
        colorCard = new ImageView();
        colorCard.setLayoutX(665.0);
        colorCard.setLayoutY(259.0);
        colorCard.setFitHeight(182.0);
        colorCard.setFitWidth(130.0);
        colorCard.setPickOnBounds(true);
        colorCard.setPreserveRatio(false);

        ///////////////////////////////////////

        // Makes Player Hand Button Array
        buttonList = new Button[7];
        for (int j = 0; j < 7; j++) {
            buttonList[j] = new Button();
        }

        // Creates 7 Player Hand Button Objects in the Array
        for (int i = 0; i < 7; i++) {
            Button button = buttonList[i];
            button.setLayoutX(0.0 + (130.0*i));
            button.setLayoutY(518);
            button.setMnemonicParsing(false);
            button.setPrefHeight(182.0);
            button.setPrefWidth(130.0);
            int finalI = i;
            button.setOnAction(event -> {
                MOTLogic.playCard(finalI); refreshCards();});
        }

        //////////////////////////////

        // Makes NPC Card Array
        npcCardList = new ImageView[7];
        for (int j = 0; j < 7; j++) {
            npcCardList[j] = new ImageView();
        }

        // Creates 7 NPC Card Image Objects in the Array
        for (int k = 0; k < 7; k++) {
            ImageView imageView = npcCardList[k];
            imageView.setLayoutX(0.0 + (130.0*k));
            imageView.setFitHeight(182.0);
            imageView.setFitWidth(130.0);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);
        }

        //////////////////////////////

        //TEMP CODE
        Button winButton = new Button("WIN");
        winButton.setLayoutY(300.0);
        winButton.setOnMouseClicked(e -> {
            gamesWon++;
            ProgressScenes.changeScene();
            createMainScreen();
        });
        //TEMP CODE

        ///////////////////////////////////

        root.getChildren().addAll(
                exitButton,
                deckButton,
                middleCardImage,
                buttonList[0],
                buttonList[1],
                buttonList[2],
                buttonList[3],
                buttonList[4],
                buttonList[5],
                buttonList[6],
                npcCardList[0],
                npcCardList[1],
                npcCardList[2],
                npcCardList[3],
                npcCardList[4],
                npcCardList[5],
                npcCardList[6],
                colorCard,
                winButton
        );

        Scene scene = new Scene(root, 1000, 700);
        currentStage.setScene(scene);
        currentStage.show();

        refreshCards();
    }

    public void refreshCards() {
        try {

            // If Wildcard 1st Card
            String[] colors = {"blue", "green", "red", "yellow"};
            if (MOTLogic.middleCard.value.contains("wild") && MOTLogic.middleColor == null) {
                MOTLogic.middleColor = colors[rand.nextInt(4)];
            }

            // Update middle card image
            middleCardImage.setImage(new Image(MOTLogic.middleCard.image));

            // Update middle Color Image
            if (MOTLogic.middleColor == null) {
                MOTLogic.middleColor = MOTLogic.middleCard.color;
            }
            checkColor(MOTLogic.middleColor);

            // Update player's hand cards
            for (int i = 0; i < MOTLogic.playerHand.size(); i++) {
                Button button = buttonList[i];
                button.setGraphic(new ImageView(new Image(MOTLogic.playerHand.get(i).image)));
            }

            // Set remaining Player cards to back if the hand is not full
            for (int i = MOTLogic.playerHand.size(); i < 7; i++) {
                Button button = buttonList[i];
                button.setGraphic(new ImageView(new Image("MOTCards/card_back_alt.png")));
            }

//            // Update NPC's hand cards
//            for (int i = 0; i < MOTLogic.npcHand.size(); i++) {
//                ImageView npcCard = npcCardList[i];
//                npcCard.setImage(new Image("MOTCards/card_back.png"));
//            }

            //TESTING
            for (int i = 0; i < MOTLogic.npcHand.size(); i++) {
                ImageView npcCard = npcCardList[i];
                npcCard.setImage(new Image(MOTLogic.npcHand.get(i).image));
            }


            // Set remaining NPC cards to back if the hand is not full
            for (int i = MOTLogic.npcHand.size(); i < 7; i++) {
                ImageView npcCard = npcCardList[i];
                npcCard.setImage(new Image("MOTCards/card_back_alt.png"));
            }

            // Check End Game
            if (MOTLogic.playerHand.isEmpty() || MOTLogic.npcHand.isEmpty()) {
                if (MOTLogic.playerHand.isEmpty()) {
                    gamesWon++;
                    ProgressScenes.changeScene();
                    AlertBox.display("WINNER", "YOU WON !!! YAYY!!!");
                } else {
                    updateLosses();
                    AlertBox.display("LOSER", "YOU LOST !!! NOOO!!!");
                }
            }
            else if (MOTLogic.playerHand.size() == 7 || MOTLogic.npcHand.size() == 7) {
                //AlertBox.display("????", "PLAY AGAIN?");
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds: " + e.getMessage());
        }
    }

    public void checkColor(String color) {
        try {
            switch (color) {
                case "blue":
                    colorCard.setImage(new Image("MOTCards/blue_card.png"));
                    break;
                case "green":
                    colorCard.setImage(new Image("MOTCards/green_card.png"));
                    break;
                case "red":
                    colorCard.setImage(new Image("MOTCards/red_card.png"));
                    break;
                case "yellow":
                    colorCard.setImage(new Image("MOTCards/yellow_card.png"));
                    break;
            }
        } catch (NullPointerException e) {
            System.out.print("");
        }
    }

    public void npcPlayCard() {

    }

    /*
    public void gaming() {
        do {
            if (turn == 0) {
                askPlayer();
                checkWin();
            }
            else {
                askNPC();
                checkWin();
            }
        } while (keepPlaying == true);
    }

    public void askPlayer() {

    }

    public void askNPC() {
        for (int i = 0; i < deck.npcHand.size(); i++) {
            if (deck.npcHand.contains("blue")) {
                deck.middleCard = deck.npcHand.get(i);
                deck.npcHand.remove(i);
            }
        }
    }

    public void checkWin() {

        if (deck.playerHand.isEmpty()) {
            keepPlaying = false;
        }
        if (deck.npcHand.isEmpty()) {
            keepPlaying = false;
        }
    }

    public void cycleTurn() {
        if (turn == 0) {
            turn++;
        }
        else {
            turn--;
        }
    }

    public void checkMiddleCardColor() {
        if (deck.middleCard.contains("blue")) {

        }
        else if(deck.middleCard.contains("green")) {

        }
        else if (deck.middleCard.contains("red")) {

        }
        else if (deck.middleCard.contains("yellow")) {

        }
        else if (deck.middleCard.contains("wild_color")) {

        }
        else if (deck.middleCard.contains("wild_pick_four")) {

        }
    }
     */
}
