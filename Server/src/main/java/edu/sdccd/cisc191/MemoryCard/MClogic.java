package edu.sdccd.cisc191.MemoryCard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;


public class MClogic extends Application {

    private Label correctGuessesLabel;
    private Label guessLabel;
    private FlowPane imagesFlowPane;

    private ArrayList<MemoryCard> cardsInGame;
    private MemoryCard firstCard, secondCard;
    private int numOfGuess;
    private int numOfMatches;

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        correctGuessesLabel = new Label("Correct Guesses: ");
        guessLabel = new Label("Guesses: ");
        imagesFlowPane = new FlowPane();

        // Set up the layout
        FlowPane root = new FlowPane();
        root.getChildren().addAll(correctGuessesLabel, guessLabel, imagesFlowPane);

        // Create a scene
        Scene scene = new Scene(root, 800, 600);

        // Set up the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Memory Card Game");
        primaryStage.show();

        // Initialize game
        playAgain();
    }

    void playAgain() {
        firstCard = null;
        secondCard = null;
        numOfGuess = 0;
        numOfMatches = 0;

        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        cardsInGame = new ArrayList<>();

        for (int i = 0; i < imagesFlowPane.getChildren().size() / 2; i++) {
            Card cardDealt = deck.dealTopCard();
            cardsInGame.add(new MemoryCard(cardDealt.getSuit(), cardDealt.getFaceName()));
            cardsInGame.add(new MemoryCard(cardDealt.getSuit(), cardDealt.getFaceName()));
        }
        Collections.shuffle(cardsInGame);
        flipAllCards();
        updateLabels();
    }

    private void initializeImageView() {
        for (int i = 0; i < imagesFlowPane.getChildren().size(); i++) {
            // Create an ImageView for the card
            ImageView cardImageView = new ImageView();
            cardImageView.setImage(new Image(getClass().getResourceAsStream("images/back_of_card.png")));
            cardImageView.setUserData(i);
            cardImageView.setOnMouseClicked(event -> flipCard((int) cardImageView.getUserData()));
            imagesFlowPane.getChildren().add(cardImageView);

            // Create an ImageView for the cover image (initially invisible)
            ImageView coverImageView = new ImageView();
            coverImageView.setImage(new Image(getClass().getResourceAsStream("images/back_of_card.png")));
            coverImageView.setVisible(false);
            coverImageView.setUserData(i); // Store the index of the card it covers
            coverImageView.setOnMouseClicked(event -> {
                int index = (int) coverImageView.getUserData();
                flipCard(index); // Flip the card when the cover image is clicked
                coverImageView.setVisible(false); // Hide the cover image after flipping
            });
            imagesFlowPane.getChildren().add(coverImageView);
        }
    }


    private void flipAllCards() {
        for (int i = 0; i < cardsInGame.size(); i++) {
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            MemoryCard card = cardsInGame.get(i);

            if (card.isMatched())
                imageView.setImage(card.getImage());
            else
                imageView.setImage(card.getBackOfCardImage());
        }
    }

    private void flipCard(int indexOfCard) {
        ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(indexOfCard);

        if (firstCard == null) {
            firstCard = cardsInGame.get(indexOfCard);
            imageView.setImage(firstCard.getImage());
        } else if (secondCard == null) {
            numOfGuess++;
            secondCard = cardsInGame.get(indexOfCard);
            imageView.setImage(secondCard.getImage());
            checkForMatch();
            if (!firstCard.isSameCard(secondCard)) {
                // If the cards don't match, flip them back after a short delay
                imageView.setDisable(true); // Disable clicking during the delay
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                // Flip back the cards
                                ImageView firstImageView = (ImageView) imagesFlowPane.getChildren().get(cardsInGame.indexOf(firstCard));
                                firstImageView.setImage(firstCard.getBackOfCardImage());
                                imageView.setImage(secondCard.getBackOfCardImage());
                                imageView.setDisable(false); // Re-enable clicking after flipping back
                            }
                        },
                        1000 // 1 second delay
                );
                coverUnmatchedCards();
            }
            updateLabels();
        }
    }


    private void updateLabels() {
        correctGuessesLabel.setText(Integer.toString(numOfMatches));
        guessLabel.setText(Integer.toString(numOfGuess));
    }

    private void checkForMatch() {
        if (firstCard.isSameCard(secondCard)) {
            numOfMatches++;
            firstCard.setMatched(true);
            secondCard.setMatched(true);
        }
        firstCard = null;
        secondCard = null;
    }

    private void coverUnmatchedCards() {
        for (MemoryCard card : cardsInGame) {
            if (!card.isMatched() && card.isFlipped()) {
                int index = cardsInGame.indexOf(card);
                ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(index);
                imageView.setImage(new Image("images/back_of_card.png"));
            }
        }
    }
}

