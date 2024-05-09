package edu.sdccd.cisc191.Scenes;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.Collections;

public class ProgressScenes extends SceneController {

    /**
     * randomizes the game order
     */
    public static void randomizeGameOrder() {
        games.add("TicTacToe");
        games.add("CoinFlip");
        games.add("BananaGuessing");
        games.add("BlackJack");
        games.add("RockPaperScissors");
        games.add("Wordish");
        games.add("Riddle");
        games.add("MOT");
        games.add("Snake");
//        games.add("MemoryCards");

        Collections.shuffle(games);
    } //end randomizeGameOrder()

    public static void setBackground() {
        backgrounds.add(new Image("Scenes/start.png"));
        backgrounds.add(new Image("Scenes/scene1.png"));
        backgrounds.add(new Image("Scenes/scene2.png"));
        backgrounds.add(new Image("Scenes/scene3.png"));
        backgrounds.add(new Image("Scenes/scene4.png"));
        backgrounds.add(new Image("Scenes/scene5.png"));
        backgrounds.add(new Image("Scenes/scene6.png"));
        backgrounds.add(new Image("Scenes/scene7.png"));
        backgrounds.add(new Image("Scenes/scene8.png"));
        backgrounds.add(new Image("Scenes/scene9.png"));

    } //end setBackground()

    /**
     * when player wins a game, the game will progress the scene
     */
    public static void changeScene() {
        count++;
        progressBar = new ProgressBar(original + 0.1);
        original = original + 0.1;
        backgrounds.head = backgrounds.head.next;
    } //end changeScene()

    public static Background getBackground() {
        BackgroundImage bgImage = new BackgroundImage(backgrounds.head.data, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        return new Background(bgImage);
    }
}
