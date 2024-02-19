package edu.sdccd.cisc191;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

    protected static Player adventurer = new Player();
    protected static Stage currentStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        currentStage = primaryStage;
        SceneController scenes = new SceneController();
        currentStage.setScene(scenes.createIntroScreen());
        currentStage.setResizable(true);
        currentStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
