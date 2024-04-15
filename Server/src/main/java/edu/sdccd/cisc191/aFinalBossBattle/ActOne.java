package edu.sdccd.cisc191.aFinalBossBattle;

import edu.sdccd.cisc191.GameButton;
import edu.sdccd.cisc191.GameLabel;
import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class ActOne extends SceneController {

    /**
     * creates the screen for the final boss battle
     */
    public void createScreen() {
        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        BackgroundImage bgImage = new BackgroundImage(backgrounds.head.data, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        root.setBackground(new Background(bgImage));

        ImageView rockyProfile = new ImageView(new Image("CharacterImages/rockyProfile.png"));
        rockyProfile.setFitWidth(332.0);
        rockyProfile.setFitHeight(385.0);
        rockyProfile.setLayoutY(315.0);

        progressBar = new ProgressBar(1.0);
        progressBar.setPrefWidth(365.0);
        progressBar.setPrefHeight(39.0);
        progressBar.setLayoutX(318.0);
        progressBar.setLayoutY(14.0);
        progressBar.setStyle("-fx-border-radius: 30%; -fx-control-inner-background: #6F4E37; -fx-accent: #4a6741; -fx-border-color: #4a6741;");

        GameButton begin = new GameButton("Begin", 200, 100, 18);
        begin.setLayoutY(350);
        begin.setLayoutX(400);
        begin.setOnMouseClicked(e -> createActOne());

        ImageView goldenPalace = new ImageView(new Image("goldenPalace.png"));
        goldenPalace.setFitWidth(113.0);
        goldenPalace.setFitHeight(93.0);
        goldenPalace.setLayoutX(677.0);
        goldenPalace.setLayoutY(-7.0);

        ImageView bridge = new ImageView(new Image("bridge.png"));
        bridge.setFitWidth(132.0);
        bridge.setFitHeight(74.0);
        bridge.setLayoutX(185.0);
        bridge.setLayoutY(-3.0);

        gameEnd.setVisible(false);
        root.getChildren().addAll(rockyProfile, gameEnd, progressBar, goldenPalace, bridge, showLives(), begin);
        currentStage.setScene(new Scene(root));
    } //end createScreen()

    /**
     * creates the intro dialogue once player reaches the place
     */
    private void createActOne() {
        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        root.setBackground(ProgressScenes.getBackground());

        VBox vBox = new VBox();
        vBox.setLayoutX(267);
        vBox.setLayoutY(422);
        vBox.setPrefWidth(467);
        vBox.setPrefHeight(209);
        vBox.setStyle("-fx-background-color: #4a6741;");
        vBox.setPadding(new Insets(10));

        GameLabel label = new GameLabel("ROCKY", 484, 20, 18);

        GameLabel textField = new GameLabel("We made it " + adventurer.getPlayerName() + "! Thank you so much for guiding \n" +
                                    "me back home. However, the battle isn't over yet. \nAt any moment, my dad could-", 447, 100, 18);
        textField.setAlignment(javafx.geometry.Pos.TOP_LEFT);

        GameButton button = new GameButton("-->", 69, 35, 18);
        button.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        button.setOnMouseClicked(e -> createActTwo());

        vBox.getChildren().addAll(label, textField, button);

        ImageView characterImage = new ImageView(new Image("CharacterImages/rockyProfile.png"));
        characterImage.setLayoutX(332);
        characterImage.setLayoutY(14);
        characterImage.setFitWidth(336);
        characterImage.setFitHeight(412);

        gameEnd.setVisible(false);
        root.getChildren().addAll(vBox, characterImage, gameEnd);
        currentStage.setScene(new Scene(root));
    } //end createActOne()

    /**
     * creates the dialogue where player encounters Rocky's dad
     */
    private void createActTwo() {
        ActTwo actTwo = new ActTwo();
        actTwo.createScene();
    } //end createActTwo()

    /**
     * fade in screen that appears between acts for transition
     */
    private void fadeInScreen() {

    } //end fadeInScreen()

}
