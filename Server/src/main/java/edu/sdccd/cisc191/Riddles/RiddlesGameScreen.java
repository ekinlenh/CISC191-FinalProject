package edu.sdccd.cisc191.Riddles;

import edu.sdccd.cisc191.Scenes.AlertBox;
import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class RiddlesGameScreen extends SceneController {
    protected static String riddle, answer;
    protected static Label titleLabel = new Label("RIDDLES");
    protected static String guess;

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

        //sets title of game
        titleLabel.setFont(new Font("Times New Roman", 72));
        titleLabel.setPrefSize(1000, 100);
        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);
        titleLabel.setStyle("-fx-background-color: #355E3B");

        riddle = RiddleSelection.chooseRandomRiddle();
        Label riddleImage = new Label(riddle);

        //riddle image
        riddleImage.setLayoutX(285);
        riddleImage.setLayoutY(150);
        riddleImage.setStyle("-fx-background-color: #355E3B");

        //exit button
        Button exitButton = new Button("Exit");
        exitButton.setFont(new Font("Times New Roman", 24));
        exitButton.setLayoutX(450);
        exitButton.setLayoutY(636);
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> {
            riddle = RiddleSelection.chooseRandomRiddle();
            riddleImage.setText(riddle);
            titleLabel.setText("RIDDLES");
            createMainScreen();
        });

        //lets user's guess
        TextField textField = new TextField();
        textField.setAlignment(javafx.geometry.Pos.CENTER);
        textField.setLayoutX(748);
        textField.setLayoutY(636);
        textField.setPrefSize(107, 44);

        //Guessing button
        Button guessButton = new Button("Your Answer");
        guessButton.setFont(new Font("Times New Roman", 24));
        guessButton.setLayoutX(854);
        guessButton.setLayoutY(636);
        guessButton.setOnAction(e -> {
                    if (textField.getText().isEmpty()) {
                        AlertBox.display("Error", "Don't try that.");
                    }
                        guess = textField.getText();
                        if (guess.equalsIgnoreCase(answer)) {
                            titleLabel.setText("Correct");
                            textField.setDisable(true);
                            guessButton.setDisable(true);
                            exitButton.setVisible(true);
                            gamesWon++;
                            ProgressScenes.changeScene();
                        } else {
                            titleLabel.setText("Wrong. The answer was " + answer);
                            textField.setDisable(true);
                            guessButton.setDisable(true);
                            exitButton.setVisible(true);
                            updateLosses();
                        }
        });


        root.getChildren().addAll(titleLabel, riddleImage, textField, exitButton, guessButton);
        currentStage.setScene(new Scene(root));
        AlertBox.display("Riddle Instructions", "Read the riddle.");
    } //end createRiddleScreen()
}
