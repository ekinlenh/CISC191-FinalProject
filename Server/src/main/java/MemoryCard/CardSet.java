package MemoryCard;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

/**
 * The CardSet class is responsible for managing sets of cards, including their image URLs and values.
 * It provides a convenient way to organize and access the sets of cards used in the game.
 */
public class CardSet {

    private List<Pair<String, Integer>> cards;

    /**
     * Constructs a CardSet object with a list of pairs representing image URLs and their corresponding values.
     * Initializes the list of cards with placeholder values.
     */
    public CardSet() {
        cards = new ArrayList<>();
        // haven't added the PNGs yet, these are placeholders
        cards.add(new Pair<>("apple.png", 1));
        cards.add(new Pair<>("banana.png", 2));
        cards.add(new Pair<>("orange.png", 3));
        cards.add(new Pair<>("Grape.png", 4));
        cards.add(new Pair<>("strawberry.png", 5));
        cards.add(new Pair<>("watermelon.png", 6));
        cards.add(new Pair<>("pineapple.png", 7));
        cards.add(new Pair<>("kiwi.png", 8));
    }

    /**
     * Retrieves the list of pairs representing image URLs and their corresponding values.
     *
     * @return The list of pairs representing image URLs and their corresponding values.
     */
    public List<Pair<String, Integer>> getCards() {
        return cards;
    }
}
