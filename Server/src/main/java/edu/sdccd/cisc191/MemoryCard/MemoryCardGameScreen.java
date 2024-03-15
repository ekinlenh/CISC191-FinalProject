package edu.sdccd.cisc191.MemoryCard;

import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
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
                Image image = new Image("card" + value + ".png"); // Load card image
                Card card = new Card(value, image); // Create a new card object
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
