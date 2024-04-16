package edu.sdccd.cisc191.Scenes;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class ProgressScenes extends SceneController {

    /**
     * randomizes the game order
     */
    public static ArrayList<String> randomizeGameOrder() {
        ArrayList<String> temp = new ArrayList<>();
        temp.add("TicTacToe");
        temp.add("CoinFlip");
        temp.add("BananaGuessing");
        temp.add("BlackJack");
        temp.add("RockPaperScissors");
        temp.add("Wordish");
        temp.add("Riddle");
        temp.add("MOT");
        temp.add("Snake");
        //temp.add("MemoryCards");

        Collections.shuffle(temp);
        return temp;
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
     * gets the background for the scene
     * @return the background of the scene
     */
    public static Background getBackground() {
        BackgroundImage bgImage = new BackgroundImage(backgrounds.head.data, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        return new Background(bgImage);
    } //end getBackground()

    /**
     * when player wins a game, the game will progress the scene
     */
    public static void changeScene() {
        backgrounds.head = backgrounds.head.next;
        count++;
        progressBar = new ProgressBar(original + 0.1);
        original = original + 0.1;
    } //end changeScene()
}
