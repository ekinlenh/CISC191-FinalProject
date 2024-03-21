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
            // Create an ImageView
            ImageView imageView = new ImageView();
            // Set the image to be the back of a Card
            imageView.setImage(new Image(getClass().getResourceAsStream("images/back_of_card.png")));
            // Set user data to store the index
            imageView.setUserData(i);
            // Register a click listener
            imageView.setOnMouseClicked(event -> {
                flipCard((int) imageView.getUserData());
            });
            // Add the ImageView to the imagesFlowPane
            imagesFlowPane.getChildren().add(imageView);
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
        if (firstCard == null && secondCard == null)
            flipAllCards();

        ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(indexOfCard);

        if (firstCard == null) {
            firstCard = cardsInGame.get(indexOfCard);
            imageView.setImage(firstCard.getImage());
        } else if (secondCard == null) {
            numOfGuess++;
            secondCard = cardsInGame.get(indexOfCard);
            imageView.setImage(secondCard.getImage());
            checkForMatch();
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
}

