package edu.sdccd.cisc191;

import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

public class Module3Test extends Application {

    Pane pane = new Pane();

    //shows that our javafx works because SceneController.showLives() is transferring over the image correctly
    //and then shows it on this new scene we create
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = SceneController.showLives();
        pane.getChildren().add(gridPane);
        pane.setPrefSize(1000, 700);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
        primaryStage.setTitle("Module 3 Test");
    }

}
