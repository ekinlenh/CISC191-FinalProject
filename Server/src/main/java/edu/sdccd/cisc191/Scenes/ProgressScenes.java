package edu.sdccd.cisc191.Scenes;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class ProgressScenes extends SceneController {

    /**
     * randomizes game order
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
       // games.add("MemoryCards");

        Collections.shuffle(temp);
        return temp;
    } //end randomizeGameOrder()

    public static void setBackground() {
        backgrounds = new Image[]{new Image("Scenes/start.png"), new Image("Scenes/scene1.png"), new Image("Scenes/scene2.png"),
                                  new Image("Scenes/scene3.png"), new Image("Scenes/scene4.png"),
                                  new Image("Scenes/scene5.png"), new Image("Scenes/scene6.png"),
                                  new Image("Scenes/scene7.png"), new Image("Scenes/scene8.png")};
    } //end setBackground()

    /**
     * when player wins a game, the game will progress the scene
     */
    public static void changeScene() {
        count++;
        progressBar = new ProgressBar(original + 0.1);
        original = original + 0.1;
    } //end changeScene()
}
