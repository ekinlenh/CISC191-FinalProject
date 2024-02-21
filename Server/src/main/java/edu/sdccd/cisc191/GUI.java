package edu.sdccd.cisc191;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUI extends Application {

    protected static Player adventurer = new Player();
    protected static Stage currentStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        currentStage = primaryStage;
        SceneController scenes = new SceneController();
        scenes.updateGoldLabel();
        currentStage.setScene(scenes.createIntroScreen());
        currentStage.setResizable(false);
        currentStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
