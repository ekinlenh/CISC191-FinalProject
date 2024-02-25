package edu.sdccd.cisc191.NumberGuessing;

import edu.sdccd.cisc191.SceneController;
import javafx.scene.Scene;
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
     protected int answer = 0;
     protected int difference = 0;
    protected static ImageView boxImage = new ImageView(new Image("tails.png"));
    protected static Label titleLabel = new Label("NUMBER GUESSING");
    protected static int guess = 0;
    public void createNumberGuessingScreen() {

        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        root.setStyle("-fx-background-color: #6F4E37;");

        //sets title of game
        titleLabel.setFont(new Font("Times New Roman", 72));
        titleLabel.setLayoutX(193);
        titleLabel.setLayoutY(14);
        titleLabel.setPrefSize(614, 102);
        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);

        //coin image
        boxImage.setFitHeight(376);
        boxImage.setFitWidth(430);
        boxImage.setLayoutX(285);
        boxImage.setLayoutY(150);

        //exit button
        Button exitButton = new Button("EXIT");
        exitButton.setFont(new Font("Times New Roman", 24));
        exitButton.setLayoutX(450);
        exitButton.setLayoutY(636);
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> {
            boxImage.setImage(new Image("heads.png"));
            createMainScreen();
        });

        //lets user's guess
        TextField textField = new TextField();
        textField.setAlignment(javafx.geometry.Pos.CENTER);
        textField.setLayoutX(748);
        textField.setLayoutY(636);
        textField.setPrefSize(107, 44);

        //Guessing button
        Button guessButton = new Button("GUESS #");
        guessButton.setFont(new Font("Times New Roman", 24));
        guessButton.setLayoutX(854);
        guessButton.setLayoutY(636);
        guessButton.setOnAction(e -> {
            answer = random.nextInt(10)+1;
            guess = Integer.parseInt(textField.getText());
            difference = answer-guess;
            if (guess > 10 || guess < 1) {
                //temp code
                System.out.println("That's not a valid choice. Choose again from 1 to 10");
            }
            if (difference >= 7 || difference <= -7) {
                /*temp code
                System.out.println("You lost badly!");*/
                titleLabel.setText("You lost badly!");
                adventurer.subtractGold(10);
            }
            else if (difference >= 4 || difference <= -4){
                /*temp code
                System.out.println("You lost!");*/
                titleLabel.setText("You lost!");
                adventurer.subtractGold(5);
            }else if (difference >= 1 || difference <= -1){
                /*temp code
                System.out.println("You won!");*/
                titleLabel.setText("You won!");
                adventurer.addGold(5);
            }else {
                titleLabel.setText("You won with an EXACT GUESS!");
                adventurer.addGold(10);
                goldLabel.setText("GOLD: " + adventurer.getGold());
                textField.setDisable(true);
                guessButton.setDisable(true);
            }
            exitButton.setVisible(true);
        });

        root.getChildren().addAll(titleLabel, boxImage, goldLabel, guessButton, textField, exitButton);

        currentStage.setScene(new Scene(root));
    }




}
