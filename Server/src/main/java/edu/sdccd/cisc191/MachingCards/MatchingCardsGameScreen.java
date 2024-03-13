package edu.sdccd.cisc191.MachingCards;

import edu.sdccd.cisc191.Scenes.SceneController;

public class MatchingCardsGameScreen extends SceneController {
    public static void createMatchingCards() {
        Board board = new Board(4, 4); // Adjust board size as needed
        board.startGame();
    }
}


