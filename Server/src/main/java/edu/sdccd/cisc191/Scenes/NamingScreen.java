package edu.sdccd.cisc191.Scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
public class NamingScreen extends SceneController {

    private final Pane root = new Pane();
    private static final ImageView background = new ImageView(new Image("Scenes/start.png"));
    private static final ImageView rockImage = new ImageView(new Image("CharacterImages/rockypoint.png"));
    private static final Label rockyText = new Label();
    private static final Label rockyName = new Label();
    private static final Button responseButton = new Button();
    private static final TextField textField = new TextField();

    private static final Pane pane = new Pane();
    private static int countLine = 0;

    /**
     * create the ask player name screen of the game
     */
    public void createScene() {

        background.setFitWidth(1000);
        background.setFitHeight(700);
        root.getChildren().add(background);

        rockImage.setFitWidth(386);
        rockImage.setFitHeight(491);
        rockImage.setLayoutX(316);
        root.getChildren().add(rockImage);

        rockyText.setText("Hey you!");
        rockyText.setLayoutX(272);
        rockyText.setLayoutY(468);
        rockyText.setPrefSize(457, 92);
        rockyText.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%;");
        rockyText.setTextFill(javafx.scene.paint.Color.WHITE);
        rockyText.setFont(new Font("Elephant", 18));
        rockyText.setAlignment(javafx.geometry.Pos.CENTER);
        root.getChildren().add(rockyText);

        rockyName.setText("???");
        rockyName.setLayoutX(370);
        rockyName.setLayoutY(14);
        rockyName.setPrefSize(261, 105);
        rockyName.setStyle("-fx-opacity: 0.5; -fx-background-color: #000000; -fx-background-radius: 15%;");
        rockyName.setTextFill(javafx.scene.paint.Color.WHITE);
        rockyName.setFont(new Font(72));
        rockyName.setAlignment(javafx.geometry.Pos.CENTER);
        root.getChildren().add(rockyName);

        responseButton.setText("Who...? Me?");
        responseButton.setLayoutX(391);
        responseButton.setLayoutY(568);
        responseButton.setPrefSize(219, 64);
        responseButton.setStyle("-fx-background-color: #6F4E37; -fx-background-radius: 15%;");
        responseButton.setTextFill(javafx.scene.paint.Color.WHITE);
        root.getChildren().add(responseButton);

        textField.setLayoutX(421);
        textField.setLayoutY(574);
        textField.setPrefSize(159, 53);
        textField.setPromptText("...");
        textField.setStyle("-fx-background-color: #6F4E37;");
        textField.setVisible(false);
        textField.setFont(new Font("Elephant", 18));
        textField.setCursor(javafx.scene.Cursor.S_RESIZE);
        root.getChildren().addAll(textField);

        pane.setLayoutX(318.0);
        pane.setLayoutY(254.0);
        pane.setPrefHeight(278.0);
        pane.setPrefWidth(365.0);
        pane.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%;");

        TextField nameField = new TextField();
        nameField.setAlignment(javafx.geometry.Pos.CENTER);
        nameField.setLayoutX(85.0);
        nameField.setLayoutY(114.0);
        nameField.setPrefHeight(50.0);
        nameField.setPrefWidth(196.0);
        nameField.setPromptText("...");
        nameField.setFont(new Font("Elephant", 18.0));
        pane.getChildren().add(nameField);

        Button enterName = new Button();
        enterName.setAlignment(javafx.geometry.Pos.CENTER);
        enterName.setLayoutX(85.0);
        enterName.setLayoutY(164.0);
        enterName.setPrefHeight(57.0);
        enterName.setPrefWidth(196.0);
        enterName.setStyle("-fx-background-color: #4a6741;");
        enterName.setText("ENTER");
        enterName.setTextFill(javafx.scene.paint.Color.WHITE);
        enterName.setFont(new Font("Elephant", 24.0));
        enterName.setOnAction(e -> {
            if (nameField.getText().length() > 15) {
                AlertBox.display("Name Error", "Name is too long. Try again.");
            } else if (nameField.getText().isEmpty()) {
                AlertBox.display("Name Error", "That's not your name Try again.");
            } else {
                adventurer.setPlayerName(nameField.getText());
                pane.setVisible(false);
                background.setEffect(null);
                rockImage.setEffect(null);
                rockyText.setEffect(null);
                rockyName.setEffect(null);
                responseButton.setEffect(null);
                rockyText.setText("I see! Okay well " + adventurer.getPlayerName() + ",\ncan you help me out?");
                responseButton.setText("Who even are you?");
                responseButton.setDisable(false);
            }
        });
        pane.setVisible(false);
        pane.getChildren().add(enterName);
        root.getChildren().add(pane);

        responseButton.setOnMouseClicked(e -> {
            createDialogue();
        });

        currentStage.setScene(new Scene(root));
    } //end createNamingScreen()

    /**
     * creates dialogue sequence
     */
    public void createDialogue() {

        switch (countLine) {
            case 0:
                rockyText.setText("Yes you! Who else is there? What's your name?");
                responseButton.setText("My name is...");
                responseButton.setOnAction(event -> {
                    pane.setVisible(true);
                    background.setEffect(new GaussianBlur(10));
                    rockImage.setEffect(new GaussianBlur(10));
                    rockyText.setEffect(new GaussianBlur(10));
                    rockyName.setEffect(new GaussianBlur(10));
                    responseButton.setEffect(new GaussianBlur(10));
                    responseButton.setDisable(true);
                    responseButton.setOpacity(1);
                });
                break;
            case 1:
                responseButton.setOnAction(e -> {
                    rockyText.setText("Who am I? I'm Rocky! But that's not \nwhat matters right now. ");
                    rockyName.setText("Rocky");
                    responseButton.setText("Okay...");
                });
                break;
            case 2:
                responseButton.setOnAction(e -> {
                    rockyText.setText("I need help saving my lover! \nMy dad kicked me out of the village \nand has kidnapped her! \nWill you help me save her?");
                    responseButton.setText("Yes");
                    responseButton.setOnAction(event -> {
                        createMainScreen();
                    });
                });
                break;
            default:
                break;
            }
        countLine++;
    } //end createDialogue()

}
