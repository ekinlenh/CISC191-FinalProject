package MemoryCard;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import java.util.Objects;

/**
 * The Card class represents an individual card in the game.
 * Each card has an image, a value, and can be flipped.
 */
public class Card extends Parent {

    private int value;            // The value of the card
    private boolean isFaceUp;     // Indicates whether the card is face-up or face-down
    private Image image;          // The image associated with the card
    private ImageView imageView;  // The ImageView for displaying the image
    private static final int CARD_WIDTH = 100;   // Width of the card
    private static final int CARD_HEIGHT = 140;  // Height of the card

    /**
     * Constructs a new Card object with the specified value and image URL.
     *
     * @param value    The value of the card.
     * @param imageUrl The URL of the image to be displayed on the card.
     */
    public Card(int value, String imageUrl) {
        this.value = value;
        this.isFaceUp = false;

        // Load image from URL
        this.image = new Image(imageUrl);
        this.imageView = new ImageView(image);
        this.imageView.setFitWidth(CARD_WIDTH);
        this.imageView.setFitHeight(CARD_HEIGHT);

        getChildren().add(imageView);

        setOnMouseClicked(event -> flip());
    }

    /**
     * Flips the card, changing its face-up status.
     * If the card is face-down, it will be flipped face-up. If it is face-up, it will be flipped face-down.
     */
    public void flip() {
        if (!isFaceUp) {
            imageView.setRotate(180); // Rotate image when flipping
            isFaceUp = true;
        }
    }

    /**
     * Hides the card by resetting its rotation and setting it to face-down.
     */
    public void hide() {
        imageView.setRotate(0); // Reset rotation
        isFaceUp = false;
    }

    /**
     * Returns the value of the card.
     *
     * @return The value of the card.
     */
    public int getValue() {
        return value;
    }

    /**
     * Checks if the card is face-up.
     *
     * @return True if the card is face-up, false otherwise.
     */
    public boolean isFaceUp() {
        return isFaceUp;
    }

    // Override equals method to compare cards based on image URLs
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(image.getUrl(), card.image.getUrl());
    }

    /**
     * Returns a hash code value for the card based on its image URL.
     *
     * @return The hash code value for the card.
     */
    @Override
    public int hashCode() {
        return Objects.hash(image.getUrl());
    }
}