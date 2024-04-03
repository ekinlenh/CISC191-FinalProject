package edu.sdccd.cisc191.MonkeySnake;

import edu.sdccd.cisc191.GameButton;
import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;

public class MonkeySnakeGameScreen extends SceneController {

    public static Label monkeyLabel = new Label("I'll let you pass if you \ncan beat my high score of 30!");
    public static GameButton exitButton = new GameButton("Exit", 100,50, 20);

    /**
     * creates the game screen
     */
    public void createGameScreen() {
        Snake snake = new Snake();
        Pane game = snake.createGameScreen();
        game.setLayoutX(488);

        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        BackgroundImage bgImage = new BackgroundImage(backgrounds[count], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        root.setBackground(new Background(bgImage));

        ImageView monkeyEnemy = new ImageView(new Image("CharacterImages/monkeyTree.png"));
        monkeyEnemy.setFitWidth(488);
        monkeyEnemy.setFitHeight(700);

        monkeyLabel.setPrefSize(259, 117);
        monkeyLabel.setLayoutX(200);
        monkeyLabel.setLayoutY(500);
        monkeyLabel.setAlignment(Pos.CENTER);
        monkeyLabel.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%; -fx-text-fill: white;");
        monkeyLabel.setFont(Font.font("Elephant", 16));

        exitButton.setVisible(false);
        exitButton.setLayoutX(10);
        exitButton.setLayoutY(650);
        exitButton.setOnAction(e -> {
            if (snake.checkScore()) {
                ProgressScenes.changeScene();
                gamesWon++;
            } else {
                updateLosses();
            }
            snake.resetGame();
            createMainScreen();
        });

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(-61.0, 40.0, 1.0, 40.0, -50.0, -72.0);
        polygon.setLayoutX(420);
        polygon.setLayoutY(460);
        polygon.setFill(Color.web("#4a6741"));
        polygon.setStroke(Color.web("#4a6741"));
        polygon.setStrokeType(StrokeType.INSIDE);

        root.getChildren().addAll(monkeyEnemy, monkeyLabel, polygon, game, exitButton);
        currentStage.setScene(new Scene(root));
    } //end createGameScreen()
}
