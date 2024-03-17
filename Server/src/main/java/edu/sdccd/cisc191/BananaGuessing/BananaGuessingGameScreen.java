package edu.sdccd.cisc191.BananaGuessing;

import edu.sdccd.cisc191.Scenes.AlertBox;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;

public class BananaGuessingGameScreen extends SceneController {

    protected static ImageView boxImage = new ImageView(new Image("BananaGuessing/box.png"));
    protected static Label fatMonkeyText = new Label("ME KNOW BANANA!");
    protected static Label rockyText = new Label("Oh no! What do you think?");
    protected static TextField guessTextField = new TextField();
    protected static Button exitButton = new Button("EXIT");

    public void createBananaGuessScreen() {
        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        int temp = games.indexOf("BananaGuess");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        root.setBackground(new Background(bgImage));

        //rocky image
        ImageView rockyProfile = new ImageView(new Image("CharacterImages/rockyProfile.png"));
        rockyProfile.setFitWidth(277);
        rockyProfile.setFitHeight(338);
        rockyProfile.setLayoutY(362);
        root.getChildren().add(rockyProfile);

        //title of game
        Label titleLabel = new Label("How Many Bananas?");
        titleLabel.setPrefSize(551, 80);
        titleLabel.setLayoutX(225);
        titleLabel.setStyle("-fx-background-color: #4a6741;");
        titleLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);
        titleLabel.setFont(new Font("Elephant", 48));
        root.getChildren().add(titleLabel);

        //box that hides the bananas behind it
        boxImage.setFitWidth(683);
        boxImage.setFitHeight(412);
        boxImage.setLayoutX(159);
        boxImage.setLayoutY(127);
        root.getChildren().add(boxImage);

        //fat monkey enemy
        ImageView fatMonkey = new ImageView(new Image("CharacterImages/fatmonkey.png"));
        fatMonkey.setFitWidth(483);
        fatMonkey.setFitHeight(489);
        fatMonkey.setLayoutX(511);
        fatMonkey.setLayoutY(211);
        root.getChildren().add(fatMonkey);

        //rocky's text
        rockyText.setPrefSize(330, 69);
        rockyText.setLayoutX(256);
        rockyText.setLayoutY(591);
        rockyText.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 15%;");
        rockyText.setTextFill(javafx.scene.paint.Color.WHITE);
        rockyText.setAlignment(javafx.geometry.Pos.CENTER);
        rockyText.setFont(new Font("Elephant", 24));
        root.getChildren().add(rockyText);

        //rocky's speech bubble thingy
        Polygon polygon2 = new Polygon(35.0, -16.0, -14.0, -50.0, 2.0, -16.0);
        polygon2.setFill(javafx.scene.paint.Color.web("#4a6741"));
        polygon2.setLayoutX(260);
        polygon2.setLayoutY(616);
        root.getChildren().add(polygon2);

        //fat monkey text
        fatMonkeyText.setPrefSize(330, 69);
        fatMonkeyText.setLayoutX(664);
        fatMonkeyText.setLayoutY(127);
        fatMonkeyText.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 15%;");
        fatMonkeyText.setTextFill(javafx.scene.paint.Color.WHITE);
        fatMonkeyText.setAlignment(javafx.geometry.Pos.CENTER);
        fatMonkeyText.setFont(new Font("Elephant", 24));
        root.getChildren().add(fatMonkeyText);

        //fat monkey speech bubble thingy
        Polygon polygon1 = new Polygon(7.0, -34.0, 42.0, -49.0, 0.0, -49.0);
        polygon1.setFill(javafx.scene.paint.Color.web("#4a6741"));
        polygon1.setLayoutX(829);
        polygon1.setLayoutY(245);
        root.getChildren().add(polygon1);

        Label guessLabel = new Label("Guess:");
        guessLabel.setPrefSize(130, 51);
        guessLabel.setLayoutX(360);
        guessLabel.setLayoutY(405);
        guessLabel.setStyle("-fx-background-color: #4a6741;");
        guessLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        guessLabel.setAlignment(javafx.geometry.Pos.CENTER);
        guessLabel.setFont(new Font("Elephant", 24));
        root.getChildren().add(guessLabel);

        guessTextField.setPrefSize(96, 51);
        guessTextField.setLayoutX(490);
        guessTextField.setLayoutY(405);
        guessTextField.setAlignment(Pos.CENTER);
        guessTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                BananaGuessingLogic.checkGuess(guessTextField.getText());
            }
        });

        root.getChildren().add(guessTextField);

        exitButton.setStyle("-fx-background-color: #4a6741; -fx-text-fill: white; -fx-background-radius: 20%");
        exitButton.setPrefSize(150, 50);
        exitButton.setFont(new Font("Elephant", 24));
        exitButton.setLayoutX(850);
        exitButton.setLayoutY(650);
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> {
            createMainScreen();
            boxImage.setVisible(true);
        });
        root.getChildren().add(exitButton);

        currentStage.setScene(new Scene(root));
        AlertBox.display("Banana Guessing Instructions", "Pick a number 1-10. \n" +
                        "Within two numbers, you win. Else, you lose.");
    }

}
