package edu.sdccd.cisc191.UNO;

import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class UnoGameScreen extends SceneController {

    public UnoDeck deck = new UnoDeck();
    public boolean keepPlaying = true;
    public int turn = 0; // 0=Player's turn, 1=NPC's turn

    public void createUNO() {

        AnchorPane root = new AnchorPane();
        int temp = games.indexOf("UNO");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        root.setBackground(new Background(bgImage));

        Button exitButton = new Button();
        exitButton.setLayoutX(14.0);
        exitButton.setLayoutY(324.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setPrefHeight(52.0);
        exitButton.setPrefWidth(92.0);
        exitButton.setText("Exit");
        exitButton.setOnAction(event -> createMainScreen());

        Button deckButton = new Button();
        deckButton.setLayoutX(370.0);
        deckButton.setLayoutY(259.0);
        deckButton.setMnemonicParsing(false);
        deckButton.setPrefHeight(182.0);
        deckButton.setPrefWidth(130.0);
        deckButton.setOnAction(event -> deck.drawCard(deck.playerHand));

        ImageView deckImage = new ImageView();
        deckImage.setFitHeight(182.0);
        deckImage.setFitWidth(130.0);
        deckImage.setPickOnBounds(true);
        deckImage.setPreserveRatio(true);
        deckImage.setImage(new Image("card_back.png"));
        deckButton.setGraphic(deckImage);

        HBox hBox1 = new HBox();
        hBox1.setLayoutX(27.0);
        hBox1.setLayoutY(463.0);
        hBox1.setPrefHeight(223.0);
        hBox1.setPrefWidth(947.0);

        HBox hBox2 = new HBox();
        hBox2.setLayoutX(14.0);
        hBox2.setLayoutY(14.0);
        hBox2.setPrefHeight(223.0);
        hBox2.setPrefWidth(979.0);

        //TEMP CODE
        Button winButton = new Button("WIN");
        winButton.setOnMouseClicked(e -> {
            gamesWon++;
            ProgressScenes.changeScene();
            createMainScreen();
        });

        root.getChildren().addAll(exitButton, deckButton, hBox1, hBox2, winButton);

        Scene scene = new Scene(root, 1000, 700);
        currentStage.setScene(scene);
        currentStage.show();
    }

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
}
