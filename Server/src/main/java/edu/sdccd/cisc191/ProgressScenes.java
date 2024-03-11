package edu.sdccd.cisc191;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;

import java.util.Collections;

public class ProgressScenes extends SceneController {

    /**
     * randomizes game order
     */
    public void randomizeGameOrder() {
        games.add("TicTacToe");
        games.add("CoinFlip");
        games.add("NumberGuessing");
        games.add("BlackJack");
        games.add("RockPaperScissors");
        games.add("Wordish");
        games.add("Riddle");
        games.add("UNO");

        Collections.shuffle(games);
    } //end randomizeGameOrder()

    public void setBackground() {
        backgrounds = new Image[]{new Image("Scenes/start.png"), new Image("Scenes/scene1.png"), new Image("Scenes/scene2.png"),
                                  new Image("Scenes/scene3.png"), new Image("Scenes/scene3.png"),
                                  new Image("Scenes/scene3.png"), new Image("Scenes/scene3.png"),
                                  new Image("Scenes/scene3.png"), new Image("Scenes/scene3.png")};
    } //end setBackground()

    /**
     * when player wins a game, the game will progress the scene
     */
    public void changeScene() {
        count++;
        progressBar = new ProgressBar(original + 0.1);
        original = original + 0.1;
        backGroundImage++;
    } //end changeScene()
}
