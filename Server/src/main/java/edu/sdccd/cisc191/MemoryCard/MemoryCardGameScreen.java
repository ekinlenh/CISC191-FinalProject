package edu.sdccd.cisc191.MemoryCard;

import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javax.swing.text.Element;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.image.ImageView;


public class MemoryCardGameScreen extends SceneController {
    private MemoryCard firstCard;
    private MemoryCard secondCard;
    private ArrayList<MemoryCard> cardsInGame;
    private FlowPane board;
    private AnchorPane layout;
    private Button playAgainButton;
    private Button exitButton;

    /**
     * creates the scene to play MemoryCard
     */
    public void createMemoryCard() {
        // Initialize layout and set background
        layout = new AnchorPane();
        layout.setPrefSize(1000, 700);
        int temp = games.indexOf("MemoryCards");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        layout.setBackground(new Background(bgImage));

        // Initialize board (FlowPane) to hold cards
        board = new FlowPane();
        board.setLayoutX(490);
        board.setLayoutY(119);
        board.setStyle("-fx-pref-height: 510; -fx-pref-width: 510;");

        // Initialize and add cards to the board
        initializeCards();

        // Initialize "Play Again" button
        playAgainButton = new Button("Play Again");
        playAgainButton.setOnAction(event -> playAgain());
        playAgainButton.setLayoutX(20);
        playAgainButton.setLayoutY(20);

        // Initialize "Exit" button
        exitButton = new Button("Exit");
        exitButton.setOnAction(event -> exit());
        exitButton.setLayoutX(100);
        exitButton.setLayoutY(20);

        // Add components to layout
        layout.getChildren().addAll(board, playAgainButton, exitButton);

        // Set scene
        currentStage.setScene(new Scene(layout));
    }

    // Method to initialize and add cards to the board
    private void initializeCards() {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        cardsInGame = new ArrayList<>();
        int rowIndex = 0;
        int colIndex = 0;

        for (int i = 0; i < 3; i++) { // Adjust the number of cards as needed
            Card cardDealt = deck.dealTopCard();
            //add two of the same cards
            cardsInGame.add(new MemoryCard(cardDealt.getSuit(), cardDealt.getFaceName()));
            cardsInGame.add(new MemoryCard(cardDealt.getSuit(), cardDealt.getFaceName()));
        }
        Collections.shuffle(cardsInGame);

        for (MemoryCard card : cardsInGame) {
            ImageView imageView;
            imageView = new ImageView(card.getBackOfCardImage());
            imageView.setOnMouseClicked(event -> flipCard(imageView, card));
            imageView.setImage(new Image("MemoryCardImages/back_of_card.png"));
            imageView.setFitHeight(182.0);
            imageView.setFitWidth(130.0);
            board.getChildren().add(imageView);

        }


// Create two HBox containers to hold cards, one for the top row and one for the bottom row
        HBox topRow = new HBox();
        HBox bottomRow = new HBox();

// Set spacing between cards in each row
        topRow.setSpacing(10);
        bottomRow.setSpacing(10);

// Create a VBox to hold the top and bottom rows vertically
        VBox vbox = new VBox(20); // Set vertical spacing between rows
        vbox.getChildren().addAll(topRow, bottomRow);

// Add the VBox to the board
        board.getChildren().add(vbox);

    }

    private void playAgain() {
        // Reset game state
        firstCard = null;
        secondCard = null;
        cardsInGame.clear(); // Clear the list of cards

        // Clear the board
        board.getChildren().clear();

        // Initialize cards again
        initializeCards();
    }

    // Method to handle "Exit" button click
    private void exit() {
        // Close the application
        currentStage.close();
    }


    // Method to flip a card
    private void flipCard(ImageView imageView, MemoryCard card) {
        if (!card.isMatched()) {
            if (!card.isFlipped()) {
                imageView.setImage(card.getImage());
                if (firstCard == null) {
                    firstCard = card;
                } else if (secondCard == null) {
                    secondCard = card;
                    checkForMatch();
                }
            } else {
                // If the card is already flipped, do nothing
                return;
            }
            card.flip();
        }
    }


    private void checkForMatch() {
        if (firstCard.isSameCard(secondCard)) {
            firstCard.setMatched(true);
            secondCard.setMatched(true);
            firstCard = null;
            secondCard = null;
        } else {
            // Cover unmatched cards after a short delay
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            // Flip back the unmatched cards
                            flipBackUnmatchedCards();
                            // Reset firstCard and secondCard
                            firstCard = null;
                            secondCard = null;
                        }
                    },
                    1000 // 1 second delay
            );
        }
    }

    private void flipBackUnmatchedCards() {
        // Flip back only the selected cards (firstCard and secondCard)
        if (firstCard != null) {
            ImageView firstImageView = findImageViewForCard(firstCard);
            if (firstImageView != null) {
                firstImageView.setImage(new Image("MemoryCardImages/back_of_card.png"));
            }
            firstCard.flip(); // Reset the flipped state
        }
        if (secondCard != null) {
            ImageView secondImageView = findImageViewForCard(secondCard);
            if (secondImageView != null) {
                secondImageView.setImage(new Image("MemoryCardImages/back_of_card.png"));
            }
            secondCard.flip(); // Reset the flipped state
        }

        // Reset firstCard and secondCard after 1 second
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        firstCard = null;
                        secondCard = null;
                    }
                },
                1000 // 1 second delay
        );
    }

    // Helper method to find the ImageView associated with a MemoryCard
    private ImageView findImageViewForCard(MemoryCard card) {
        for (Node node : board.getChildren()) {
            if (node instanceof ImageView) {
                ImageView imageView = (ImageView) node;
                MemoryCard currentCard = cardsInGame.get(board.getChildren().indexOf(node));
                if (currentCard == card) {
                    return imageView;
                }
            }
        }
        return null;
    }
}
