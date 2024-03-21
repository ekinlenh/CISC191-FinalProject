package edu.sdccd.cisc191.MOT;

import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class MOTGameScreen extends SceneController {

    PlayerLogic playerLogic = new PlayerLogic();
    NPCLogic npcLogic = new NPCLogic();
    Button exitButton, deckButton, card1Button, card2Button, card3Button, card4Button, card5Button, card6Button, card7Button;
    ImageView middleCardImage, npcCard1, npcCard2, npcCard3, npcCard4, npcCard5, npcCard6, npcCard7;
    public boolean keepPlaying = true;
    public int turn = 0; // 0=Player's turn, 1=NPC's turn

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
        deckButton.setOnAction(event -> {playerLogic.drawPlayerCard(); refreshCards();});

        middleCardImage = new ImageView();
        middleCardImage.setLayoutX(525.0);
        middleCardImage.setLayoutY(259.0);
        middleCardImage.setFitHeight(182.0);
        middleCardImage.setFitWidth(130.0);
        middleCardImage.setPickOnBounds(true);
        middleCardImage.setPreserveRatio(true);
        middleCardImage.setImage(new Image(playerLogic.middleCard.image));

        ///////////////////////////////////////

        card1Button = new Button();
        card1Button.setLayoutX(0.0);
        card1Button.setLayoutY(518.0);
        card1Button.setMnemonicParsing(false);
        card1Button.setPrefHeight(182.0);
        card1Button.setPrefWidth(130.0);
        card1Button.setOnAction(event -> {playerLogic.playCard(0); refreshCards();});

        card2Button = new Button();
        card2Button.setLayoutX(130.0);
        card2Button.setLayoutY(518.0);
        card2Button.setMnemonicParsing(false);
        card2Button.setPrefHeight(182.0);
        card2Button.setPrefWidth(130.0);
        card2Button.setOnAction(event -> {playerLogic.playCard(1); refreshCards();});

        card3Button = new Button();
        card3Button.setLayoutX(260.0);
        card3Button.setLayoutY(518.0);
        card3Button.setMnemonicParsing(false);
        card3Button.setPrefHeight(182.0);
        card3Button.setPrefWidth(130.0);
        card3Button.setOnAction(event -> {playerLogic.playCard(2); refreshCards();});

        card4Button = new Button();
        card4Button.setLayoutX(390.0);
        card4Button.setLayoutY(518.0);
        card4Button.setMnemonicParsing(false);
        card4Button.setPrefHeight(182.0);
        card4Button.setPrefWidth(130.0);
        card4Button.setOnAction(event -> {playerLogic.playCard(3); refreshCards();});

        card5Button = new Button();
        card5Button.setLayoutX(520.0);
        card5Button.setLayoutY(518.0);
        card5Button.setMnemonicParsing(false);
        card5Button.setPrefHeight(182.0);
        card5Button.setPrefWidth(130.0);
        card5Button.setOnAction(event -> {playerLogic.playCard(4); refreshCards();});

        card6Button = new Button();
        card6Button.setLayoutX(650.0);
        card6Button.setLayoutY(518.0);
        card6Button.setMnemonicParsing(false);
        card6Button.setPrefHeight(182.0);
        card6Button.setPrefWidth(130.0);
        card6Button.setOnAction(event -> {playerLogic.playCard(5); refreshCards();});

        card7Button = new Button();
        card7Button.setLayoutX(780.0);
        card7Button.setLayoutY(518.0);
        card7Button.setMnemonicParsing(false);
        card7Button.setPrefHeight(182.0);
        card7Button.setPrefWidth(130.0);
        card7Button.setOnAction(event -> {playerLogic.playCard(6); refreshCards();});

        //////////////////////////////

        npcCard1 = new ImageView();
        npcCard1.setLayoutX(0.0);
        npcCard1.setFitHeight(182.0);
        npcCard1.setFitWidth(130.0);
        npcCard1.setPickOnBounds(true);
        npcCard1.setPreserveRatio(true);

        npcCard2 = new ImageView();
        npcCard2.setLayoutX(130.0);
        npcCard2.setFitHeight(182.0);
        npcCard2.setFitWidth(130.0);
        npcCard2.setPickOnBounds(true);
        npcCard2.setPreserveRatio(true);

        npcCard3 = new ImageView();
        npcCard3.setLayoutX(260.0);
        npcCard3.setFitHeight(182.0);
        npcCard3.setFitWidth(130.0);
        npcCard3.setPickOnBounds(true);
        npcCard3.setPreserveRatio(true);

        npcCard4 = new ImageView();
        npcCard4.setLayoutX(390.0);
        npcCard4.setFitHeight(182.0);
        npcCard4.setFitWidth(130.0);
        npcCard4.setPickOnBounds(true);
        npcCard4.setPreserveRatio(true);

        npcCard5 = new ImageView();
        npcCard5.setLayoutX(520.0);
        npcCard5.setFitHeight(182.0);
        npcCard5.setFitWidth(130.0);
        npcCard5.setPickOnBounds(true);
        npcCard5.setPreserveRatio(true);

        npcCard6 = new ImageView();
        npcCard6.setLayoutX(650.0);
        npcCard6.setFitHeight(182.0);
        npcCard6.setFitWidth(130.0);
        npcCard6.setPickOnBounds(true);
        npcCard6.setPreserveRatio(true);

        npcCard7 = new ImageView();
        npcCard7.setLayoutX(780.0);
        npcCard7.setFitHeight(182.0);
        npcCard7.setFitWidth(130.0);
        npcCard7.setPickOnBounds(true);
        npcCard7.setPreserveRatio(true);

        ///////////////////////////////


        // Color card in the middle displaying current color
        ImageView colorCard = new ImageView();
        colorCard.setLayoutX(780.0);
        colorCard.setFitHeight(182.0);
        colorCard.setFitWidth(130.0);
        colorCard.setPickOnBounds(true);
        colorCard.setPreserveRatio(true);

        //////////////////////////////

        //TEMP CODE
        Button winButton = new Button("WIN");
        winButton.setLayoutY(250.0);
        winButton.setOnMouseClicked(e -> {
            gamesWon++;
            ProgressScenes.changeScene();
            createMainScreen();
        });

        root.getChildren().addAll(
                exitButton,
                deckButton,
                middleCardImage,
                card1Button,
                card2Button,
                card3Button,
                card4Button,
                card5Button,
                card6Button,
                card7Button,
                npcCard1,
                npcCard2,
                npcCard3,
                npcCard4,
                npcCard5,
                npcCard6,
                npcCard7,
                winButton
        );

        Scene scene = new Scene(root, 1000, 700);
        currentStage.setScene(scene);
        currentStage.show();

        refreshCards();
    }

    public void refreshCards() {
        try {
            // Update middle card image
            middleCardImage.setImage(new Image(playerLogic.middleCard.image));

            // Update player's hand cards
            for (int i = 0; i < playerLogic.playerHand.size(); i++) {
                Button button = getPlayerCardButton(i);
                button.setGraphic(new ImageView(new Image(playerLogic.playerHand.get(i).image)));
            }

            // Set remaining Player cards to back if the hand is not full
            for (int i = playerLogic.playerHand.size(); i < 7; i++) {
                Button button = getPlayerCardButton(i);
                button.setGraphic(new ImageView(new Image("MOTCards/card_back_alt.png")));
            }

            // Update NPC's hand cards
            for (int i = 0; i < playerLogic.npcHand.size(); i++) {
                ImageView npcCard = getNpcCardImage(i);
                npcCard.setImage(new Image("MOTCards/card_back.png"));
            }

            // Set remaining NPC cards to back if the hand is not full
            for (int i = playerLogic.npcHand.size(); i < 7; i++) {
                ImageView npcCard = getNpcCardImage(i);
                npcCard.setImage(new Image("MOTCards/card_back_alt.png"));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds: " + e.getMessage());
        }
    }

    // Helper method to get player's card button by index
    private Button getPlayerCardButton(int index) {
        switch (index) {
            case 0: return card1Button;
            case 1: return card2Button;
            case 2: return card3Button;
            case 3: return card4Button;
            case 4: return card5Button;
            case 5: return card6Button;
            case 6: return card7Button;
            default: throw new IndexOutOfBoundsException("Invalid player card index: " + index);
        }
    }

    // Helper method to get NPC card image by index
    private ImageView getNpcCardImage(int index) {
        switch (index) {
            case 0: return npcCard1;
            case 1: return npcCard2;
            case 2: return npcCard3;
            case 3: return npcCard4;
            case 4: return npcCard5;
            case 5: return npcCard6;
            case 6: return npcCard7;
            default: throw new IndexOutOfBoundsException("Invalid NPC card index: " + index);
        }
    }


    public void callCard1() {
        System.out.println("callCard1");
        npcCard7.setImage(new Image("MOTCards/red_0.png"));
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
