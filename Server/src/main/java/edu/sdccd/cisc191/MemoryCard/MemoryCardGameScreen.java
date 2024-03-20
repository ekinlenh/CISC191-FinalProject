package edu.sdccd.cisc191.MemoryCard;

import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The MemoryCardGameScreen class represents the controller for the memory card game screen.
 * It manages the game logic, including initializing the game board and handling card clicks.
 */
public class MemoryCardGameScreen extends SceneController {
    @FXML
    private GridPane gridPane; // Grid pane to display the cards

    private static final int BOARD_SIZE = 4; // Size of the game board
    private static final int TOTAL_CARDS = BOARD_SIZE * BOARD_SIZE; // Total number of cards on the board
    private static final int CARD_WIDTH = 100; // Width of each card
    private static final int CARD_HEIGHT = 140; // Height of each card
    private List<Card> cards = new ArrayList<>(); // List to store the card objects
    private Card flippedCard = null; // Currently flipped card
    private int matchedCount = 0; // Number of matched pairs

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;


    public void createGameScreen(){
        FlowPane board = new FlowPane();
        AnchorPane layout = new AnchorPane();
        layout.setPrefSize(1000, 700);
        int temp = games.indexOf("MemoryCard");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        layout.setBackground(new Background(bgImage));

        /*
        button1 = new Button();
        button1.setLayoutX(0.0);
        button1.setLayoutY(518.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(182.0);
        button1.setPrefWidth(130.0);
        button1.setOnAction(event -> flip);

        button2 = new Button();
        button2.setLayoutX(130.0);
        button2.setLayoutY(518.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(182.0);
        button2.setPrefWidth(130.0);
        button2.setOnAction();

        button3 = new Button();
        button3.setLayoutX(260.0);
        button3.setLayoutY(518.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(182.0);
        button3.setPrefWidth(130.0);
        button3.setOnAction();

        button4 = new Button();
        button4.setLayoutX(390.0);
        button4.setLayoutY(518.0);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(182.0);
        button4.setPrefWidth(130.0);
        button4.setOnAction();

        button5 = new Button();
        button5.setLayoutX(520.0);
        button5.setLayoutY(518.0);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(182.0);
        button5.setPrefWidth(130.0);
        button5.setOnAction();

        button6 = new Button();
        button6.setLayoutX(650.0);
        button6.setLayoutY(518.0);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(182.0);
        button6.setPrefWidth(130.0);
        button6.setOnAction();

       button7 = new Button();
       button7.setLayoutX(780.0);
       button7.setLayoutY(518.0);
       button7.setMnemonicParsing(false);
       button7.setPrefHeight(182.0);
       button7.setPrefWidth(130.0);
       button7.setOnAction();

        button8 = new Button();
        button8.setLayoutX(0.0);
        button8.setLayoutY(518.0);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(182.0);
        button8.setPrefWidth(130.0);
        button8.setOnAction();

        button9 = new Button();
        button9.setLayoutX(130.0);
        button9.setLayoutY(518.0);
        button9.setMnemonicParsing(false);
        button9.setPrefHeight(182.0);
        button9.setPrefWidth(130.0);
        button9.setOnAction();

        button10 = new Button();
        button10.setLayoutX(260.0);
        button10.setLayoutY(518.0);
        button10.setMnemonicParsing(false);
        button10.setPrefHeight(182.0);
        button10.setPrefWidth(130.0);
        button10.setOnAction();

        button11 = new Button();
        button11.setLayoutX(390.0);
        button11.setLayoutY(518.0);
        button11.setMnemonicParsing(false);
        button11.setPrefHeight(182.0);
        button11.setPrefWidth(130.0);
        button11.setOnAction();

        button12 = new Button();
        button12.setLayoutX(520.0);
        button12.setLayoutY(518.0);
        button12.setMnemonicParsing(false);
        button12.setPrefHeight(182.0);
        button12.setPrefWidth(130.0);
        button12.setOnAction();

        button13 = new Button();
        button13.setLayoutX(650.0);
        button13.setLayoutY(518.0);
        button13.setMnemonicParsing(false);
        button13.setPrefHeight(182.0);
        button13.setPrefWidth(130.0);
        button13.setOnAction();

        button14 = new Button();
        button14.setLayoutX(780.0);
        button14.setLayoutY(518.0);
        button14.setMnemonicParsing(false);
        button14.setPrefHeight(182.0);
        button14.setPrefWidth(130.0);
        button14.setOnAction();

        button15 = new Button();
        button15.setLayoutX(650.0);
        button15.setLayoutY(518.0);
        button15.setMnemonicParsing(false);
        button15.setPrefHeight(182.0);
        button15.setPrefWidth(130.0);
        button15.setOnAction();

        button16 = new Button();
        button16.setLayoutX(780.0);
        button16.setLayoutY(518.0);
        button16.setMnemonicParsing(false);
        button16.setPrefHeight(182.0);
        button16.setPrefWidth(130.0);
        button16.setOnAction();

        board.setLayoutX(490);
        board.setLayoutY(119);
        board.setStyle("-fx-pref-height: 510; -fx-pref-width: 510;");

        layout.getChildren().addAll(board);
        currentStage.setScene(new Scene(layout));


         */
    }

    public void flipCard(){
        List<Card> cards = new ArrayList<>();
        boolean isFaceUp;
        //this.isFaceUp = false;

    }


    /**
     * Initializes the memory card game screen.
     * Sets up the game board, creates and shuffles the cards, and adds them to the grid pane.
     */
    @FXML
    public void initialize() {
        List<Integer> values = new ArrayList<>(); // List to store card values
        for (int i = 1; i <= TOTAL_CARDS; i++) {
            values.add(i);
            values.add(i); // Adding pairs of values for matching cards
        }
        Collections.shuffle(values); // Shuffle the card values

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                int value = values.get(i * BOARD_SIZE + j); // Get the value for the current card
                Card card = new Card(value, "MemoryCardImages/card" + value + ".png"); // Create a new card object
                card.setOnMouseClicked(event -> handleCardClick(card)); // Set event handler for card click
                cards.add(card); // Add card to the list
                gridPane.add(card, j, i); // Add card to the grid pane
            }
        }
    }

    /**
     * Handles the click event on a card.
     * Flips the card and checks for matches with the previously flipped card.
     *
     * @param card The card that was clicked.
     */
    private void handleCardClick(Card card) {
        if (!card.isFaceUp() && flippedCard != card) {
            card.flip(); // Flip the clicked card
            if (flippedCard == null) {
                flippedCard = card; // Set flipped card if it's the first card flipped
            } else {
                if (flippedCard.getValue() == card.getValue()) {
                    matchedCount++; // Increment matched count if the cards match
                    if (matchedCount == TOTAL_CARDS / 2) {
                        System.out.println("Game Over! All cards matched!"); // Print game over message
                        // Add game over logic here
                    }
                    flippedCard = null; // Reset flipped card if matched
                } else {
                    // Not matched, flip both cards back after a short delay
                    new Thread(() -> {
                        try {
                            Thread.sleep(1000); // Delay for 1 second
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        flippedCard.flip(); // Flip back the first card
                        card.flip(); // Flip back the second card
                        flippedCard = null; // Reset flipped card
                    }).start();
                }
            }
        }
    }
}
