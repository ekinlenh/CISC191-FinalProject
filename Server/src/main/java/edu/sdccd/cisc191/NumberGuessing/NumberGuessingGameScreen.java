package edu.sdccd.cisc191.NumberGuessing;

import edu.sdccd.cisc191.AlertBox;
import edu.sdccd.cisc191.SceneController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.util.Random;

public class NumberGuessingGameScreen extends SceneController {
    private static final Random random = new Random();
    private int answer=0, difference=0;
    protected static ImageView boxImage = new ImageView(new Image("MysteryBox.png"));
    protected static Label titleLabel = new Label("NUMBER GUESSING");
    protected static int guess = 0;
    public void createNumberGuessingScreen() {

        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        root.setStyle("-fx-background-color: #6F4E37;");

        //sets title of game
        titleLabel.setFont(new Font("Times New Roman", 72));
        titleLabel.setPrefSize(1000, 100);
        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);

        //coin image
        boxImage.setFitHeight(376);
        boxImage.setFitWidth(430);
        boxImage.setLayoutX(285);
        boxImage.setLayoutY(150);

        //exit button
        Button exitButton = new Button("Exit");
        exitButton.setFont(new Font("Times New Roman", 24));
        exitButton.setLayoutX(450);
        exitButton.setLayoutY(636);
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> {
            boxImage.setImage(new Image("MysteryBox.png"));
            titleLabel.setText("NUMBER GUESSING");
            createMainScreen();
        });

        //lets user's guess
        TextField textField = new TextField();
        textField.setAlignment(javafx.geometry.Pos.CENTER);
        textField.setLayoutX(748);
        textField.setLayoutY(636);
        textField.setPrefSize(107, 44);

        Label randomNumber = new Label();
        randomNumber.setLayoutX(430);
        randomNumber.setLayoutY(200);
        randomNumber.setFont(new Font("Times New Roman", 300));
        randomNumber.setAlignment(Pos.CENTER);

        //Guessing button
        Button guessButton = new Button("Guess #");
        guessButton.setFont(new Font("Times New Roman", 24));
        guessButton.setLayoutX(854);
        guessButton.setLayoutY(636);
        guessButton.setOnAction(e -> {
            boxImage.setImage(null);
            try {
                answer = random.nextInt(10)+1;
                randomNumber.setText(Integer.toString(answer));
                guess = Integer.parseInt(textField.getText());
                difference = answer-guess;
                if (guess > 10 || guess < 1) {
                    AlertBox.display("Invalid Number", "That's not a valid choice. Choose again from 1 to 10");
                }
                else if (difference >= 7 || difference <= -7) {
                    titleLabel.setText("You lost badly!");
                    adventurer.subtractGold(10);
                    textField.setDisable(true);
                    guessButton.setDisable(true);
                    updateGoldLabel();
                }
                else if (difference >= 3 || difference <= -3){
                    titleLabel.setText("You lost!");
                    adventurer.subtractGold(5);
                    textField.setDisable(true);
                    guessButton.setDisable(true);
                    updateGoldLabel();
                }
                else if (difference >= 1 || difference <= -1){
                    titleLabel.setText("You won!");
                    adventurer.addGold(5);
                    textField.setDisable(true);
                    guessButton.setDisable(true);
                    updateGoldLabel();
                }
                else {
                    titleLabel.setText("EXACT GUESS!");
                    adventurer.addGold(10);
                    goldLabel.setText("GOLD: " + adventurer.getGold());
                    textField.setDisable(true);
                    guessButton.setDisable(true);
                    updateGoldLabel();
                }
                exitButton.setVisible(true);
                updateGoldLabel();
            } catch (Exception exception) {
                AlertBox.display("Error", "Sorry, try again.");
            }
        });


        root.getChildren().addAll(titleLabel, boxImage, goldLabel, textField, exitButton, guessButton, randomNumber);
        currentStage.setScene(new Scene(root));
        AlertBox.display("Number Guessing Instructions", "Pick a number 1-10. \n" +
                "If you are within 2 numbers, you win 5 gold." + "\nIf you guess correctly, you win 10 gold.");
    }

}
