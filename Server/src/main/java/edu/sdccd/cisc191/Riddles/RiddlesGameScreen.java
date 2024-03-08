package edu.sdccd.cisc191.Riddles;

import edu.sdccd.cisc191.AlertBox;
import edu.sdccd.cisc191.SceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class RiddlesGameScreen extends SceneController {
    protected String riddle, answer;
    protected static Label titleLabel = new Label("RIDDLES");
    protected static String guess;
    public void createRiddleScreen() {

        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        root.setStyle("-fx-background-color: #6F4E37;");

        //sets title of game
        titleLabel.setFont(new Font("Times New Roman", 72));
        titleLabel.setPrefSize(1000, 100);
        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);

        riddle = RiddleSelection.chooseRandomRiddle();
        ImageView riddleImage = new ImageView(new Image(riddle));

        //riddle image
        riddleImage.setFitHeight(376);
        riddleImage.setFitWidth(430);
        riddleImage.setLayoutX(285);
        riddleImage.setLayoutY(150);

        //exit button
        Button exitButton = new Button("Exit");
        exitButton.setFont(new Font("Times New Roman", 24));
        exitButton.setLayoutX(450);
        exitButton.setLayoutY(636);
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> {
            riddleImage.setImage(new Image(riddle));
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
                    } else {
                        try {
                            guess = textField.getText();
                            answer = RiddleSelection.findRiddleAnswer();
                            if (answer == guess) {
                                titleLabel.setText("Correct");
                                adventurer.addGold(10);
                                goldLabel.setText("GOLD: " + adventurer.getGold());
                                textField.setDisable(true);
                                guessButton.setDisable(true);
                                updateGoldLabel();
                            } else {
                                titleLabel.setText("Wrong. The answer was " + answer);
                                adventurer.subtractGold(10);
                                goldLabel.setText("GOLD: " + adventurer.getGold());
                                textField.setDisable(true);
                                guessButton.setDisable(true);
                                updateGoldLabel();
                            }
                        } catch (Exception exception) {
                            AlertBox.display("Error", "Sorry, try again.");
                        }
                    }
        });


        root.getChildren().addAll(titleLabel, riddleImage, goldLabel, textField, exitButton, guessButton);
        currentStage.setScene(new Scene(root));
        AlertBox.display("Riddle Instructions", "Read the riddle. \n" +
                "If you guess the answer correctly, you win 10 gold" + "\nIf you guess wrong, you lose 10 gold.");
    }
}
