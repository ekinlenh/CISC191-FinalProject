package edu.sdccd.cisc191;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GUI extends Application {

    protected static Player adventurer = new Player();
    protected static Stage currentStage;
    protected static int gamesWon = 0;
    protected static Label timerLabel = new Label();
    protected static Timeline timer;


    @Override
    public void start(Stage primaryStage) throws Exception{
        currentStage = primaryStage;
        SceneController scenes = new SceneController();
        scenes.updateGoldLabel();
        currentStage.setScene(scenes.createIntroScreen());
        currentStage.setResizable(false);
        currentStage.show();
        GameTimer timer = new GameTimer();
        timer.runTimer();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
