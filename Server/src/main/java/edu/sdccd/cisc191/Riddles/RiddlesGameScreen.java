package edu.sdccd.cisc191.Riddles;

import edu.sdccd.cisc191.GameButton;
import edu.sdccd.cisc191.GameLabel;
import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;

import java.util.Arrays;
import java.util.Collections;

public class RiddlesGameScreen extends SceneController {
    protected static String riddle, answer;
    protected GridPane gridPane = new GridPane();
    protected static GameLabel titleLabel = new GameLabel(null, 542, 79, 12);
    protected static GameButton exitButton = new GameButton("Exit", 125, 49, 24);

    /**
     * creates the riddle minigame screen
     */
    public void createRiddleScreen() {
        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        int temp = games.indexOf("Riddle");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        root.setBackground(new Background(bgImage));

        Ellipse ellipse = new Ellipse(505.0, 570.0, 482.0, 116.0);
        ellipse.setFill(javafx.scene.paint.Color.valueOf("#738d6b"));
        ellipse.setStroke(javafx.scene.paint.Color.BLACK);
        ellipse.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        VBox vBox = new VBox();
        vBox.setLayoutX(230.0);
        vBox.setLayoutY(14.0);
        vBox.setPrefHeight(400.0);
        vBox.setPrefWidth(540.0);
        vBox.setStyle("-fx-background-color: #6F4E37; -fx-border-width: 5px; -fx-border-color: #4a6741;");

        createMultipleChoice(RiddleSelection.chooseRandomRiddle());
        titleLabel.setText(riddle);

        Rectangle rectangle = new Rectangle(541.0, 125.0);
        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.TRANSPARENT);

        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(198.0);
        gridPane.setPrefWidth(541.0);

        exitButton.setLayoutX(861.0);
        exitButton.setLayoutY(637.0);
        exitButton.setVisible(false);
        exitButton.setOnMouseClicked(e -> {
            createMainScreen();
        });

        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(100.0);

        RowConstraints rowConstraints1 = new RowConstraints();
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        RowConstraints rowConstraints2 = new RowConstraints();
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        gridPane.getColumnConstraints().addAll(columnConstraints1, columnConstraints2);
        gridPane.getRowConstraints().addAll(rowConstraints1, rowConstraints2);

        vBox.getChildren().addAll(titleLabel, rectangle, gridPane);

        ImageView rocky = new ImageView(new Image("CharacterImages/rockyProfile.png"));
        rocky.setFitHeight(245.0);
        rocky.setFitWidth(185.0);
        rocky.setLayoutX(741.0);
        rocky.setLayoutY(209.0);

        Polyline polyline1 = new Polyline(107.0, -124.0, 174.0, 89.0, -73.0, 89.0, -24.0, -124.0);
        polyline1.setFill(javafx.scene.paint.Color.valueOf("#2c2109"));
        polyline1.setLayoutX(784.0);
        polyline1.setLayoutY(517.0);
        polyline1.setStroke(javafx.scene.paint.Color.valueOf("#2c2109"));
        polyline1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        ImageView oldmonkey = new ImageView(new Image("CharacterImages/oldmonkey.png"));
        oldmonkey.setFitHeight(163.0);
        oldmonkey.setFitWidth(159.0);
        oldmonkey.setLayoutX(89.0);
        oldmonkey.setLayoutY(245.0);

        Polyline polyline2 = new Polyline(107.0, -124.0, 174.0, 89.0, -73.0, 89.0, -24.0, -124.0);
        polyline2.setFill(javafx.scene.paint.Color.valueOf("#2c2109"));
        polyline2.setLayoutX(131.0);
        polyline2.setLayoutY(517.0);
        polyline2.setStroke(javafx.scene.paint.Color.valueOf("#2c2109"));

        polyline2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        QuadCurve quadCurve = new QuadCurve();
        quadCurve.setStartX(71.0);
        quadCurve.setStartY(-41.0);
        quadCurve.setEndX(82.0);
        quadCurve.setEndY(35.0);
        quadCurve.setControlX(103.0);
        quadCurve.setControlY(-4.0);
        quadCurve.setLayoutX(148.0);
        quadCurve.setLayoutY(367.0);
        quadCurve.setFill(javafx.scene.paint.Color.TRANSPARENT);
        quadCurve.setStroke(javafx.scene.paint.Color.BLACK);
        quadCurve.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        quadCurve.setStrokeWidth(5.0);

        Circle circle = new Circle();
        circle.setRadius(13.0);
        circle.setLayoutX(216.0);
        circle.setLayoutY(326.0);
        circle.setFill(javafx.scene.paint.Color.valueOf("#575656"));
        circle.setStroke(javafx.scene.paint.Color.valueOf("#575656"));
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        root.getChildren().addAll(ellipse, exitButton, vBox, rocky, polyline1, oldmonkey, polyline2, quadCurve, circle);
        currentStage.setScene(new Scene(root));
    } //end createRiddleScreen()

    /**
     * create the multiple choice buttons
     * @param answers takes in multiple choice answers
     */
    private void createMultipleChoice(String[] answers) {
        String realAnswer = answers[0];
        Collections.shuffle(Arrays.asList(answers));
        int index = 0;
        answer = answers[index];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                answer = answers[index];
                index++;
                Button button = new Button(answer);
                button.setAlignment(javafx.geometry.Pos.CENTER);
                button.setPrefHeight(123.0);
                button.setPrefWidth(273.0);
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: #6F4E37; -fx-font-size: 18; -fx-font-family: Elephant");
                button.setOnMouseClicked(e -> {
                    button.setStyle("-fx-background-color: #5E463F; -fx-font-size: 24; -fx-font-family: Elephant; -fx-font-weight: bold");
                    if (button.getText().equalsIgnoreCase(realAnswer)) {
                        ProgressScenes.changeScene();
                        gamesWon++;
                    } else {
                        updateLosses();
                    }
                    exitButton.setVisible(true);
                });
                gridPane.add(button, i, j);
            }
        }

        //show answer to console
        System.out.println(riddle);
        System.out.println(realAnswer);
    } //end createMultipleChoice()
}
