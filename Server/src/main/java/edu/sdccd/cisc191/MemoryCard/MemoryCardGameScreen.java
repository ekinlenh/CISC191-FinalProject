package edu.sdccd.cisc191.MemoryCard;

import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * The MemoryCardGameScreen class represents the controller for the memory card game screen.
 *
 */
public class MemoryCardGameScreen extends SceneController {

    /**
     * creates the scene to play MemoryCard
     */
    public void createMemoryCard() {
        FlowPane board = new FlowPane();
        AnchorPane layout = new AnchorPane();
        layout.setPrefSize(1000, 700);
        int temp = games.indexOf("MemoryCard");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        layout.setBackground(new Background(bgImage));

        board.setLayoutX(490);
        board.setLayoutY(119);
        board.setStyle("-fx-pref-height: 510; -fx-pref-width: 510;");
        layout.getChildren().addAll(board);
        currentStage.setScene(new Scene(layout));
    }
}





