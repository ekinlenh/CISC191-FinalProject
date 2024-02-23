package edu.sdccd.cisc191;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.Random;

public class SceneController extends GUI {
    private final static double sceneWidth = 1000.0, sceneHeight = 700.0;
    protected static Label goldLabel = new Label();
    protected static int debt = 0;


    /**
     * creates the intro of the game that asks player to choose class
     * @return the intro scene
     */
    public Scene createIntroScreen() {
        //introduction
        BorderPane root = new BorderPane();
        root.setPrefSize(sceneWidth, sceneHeight);
        root.setStyle("-fx-background-color: black;");

        //row container for class selection
        HBox hbox = new HBox();
        hbox.setPrefSize(sceneWidth/5, sceneHeight/7);
        hbox.setAlignment(javafx.geometry.Pos.CENTER);

        //warrior class
        Button warriorButton = new Button("Warrior");
        warriorButton.setPrefSize(165, 75);
        warriorButton.setStyle("-fx-background-radius: 25; -fx-background-color: white;");
        warriorButton.setFont(new Font("Times New Roman", 32));
        warriorButton.setOnAction(e -> {
            adventurer = new Player("Warrior", 100, 90, 60);
            createNamingScreen();
        });

        //tank class
        Button tankButton = new Button("Tank");
        tankButton.setPrefSize(165, 75);
        tankButton.setStyle("-fx-background-radius: 25; -fx-background-color: white;");
        tankButton.setFont(new Font("Times New Roman", 32));
        tankButton.setOnAction(e -> {
            adventurer = new Player("Tank", 135, 30, 85);
            createNamingScreen();
        });

        //assassin class
        Button assassinButton = new Button("Assassin");
        assassinButton.setPrefSize(165, 75);
        assassinButton.setStyle("-fx-background-radius: 25; -fx-background-color: white;");
        assassinButton.setFont(new Font("Times New Roman", 32));
        assassinButton.setOnAction(e -> {
            adventurer = new Player("Assassin", 80, 125, 45);
            createNamingScreen();
        });

        //add buttons to container
        hbox.getChildren().addAll(warriorButton, tankButton, assassinButton);

        //create label at center of screen
        Label label = new Label("Choose your class.");
        label.setPrefSize(250, 198);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Times New Roman", 32));

        root.setCenter(label);
        root.setBottom(hbox);
        return new Scene(root);
    } //end createIntroScreen

    /**
     * create the ask player name screen of the game
     */
    public void createNamingScreen() {
        Pane root = new Pane();
        root.setStyle("-fx-background-color: black;");
        root.setPrefSize(sceneWidth, sceneHeight);

        Label label = new Label("What is your name, adventurer?");
        label.setFont(new Font("Times New Roman", 24));
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setPrefSize(498, 78);
        label.setLayoutX(351);
        label.setLayoutY(210);

        TextField textField = new TextField();
        textField.setPrefSize(214, 27);
        textField.setLayoutX(351);
        textField.setLayoutY(289); // Offset for better positioning

        Button confirm = new Button("Confirm");
        confirm.setFont(new Font("Times New Roman", 16));
        confirm.setPrefSize(94, 27);
        confirm.setLayoutX(560);
        confirm.setLayoutY(288); // Offset for better positioning
        confirm.setOnAction(e -> {
            if (textField.getText().isEmpty()) {
                label.setText("Please enter an actual name.");
            }
            else if (textField.getText().length() > 15) {
                  label.setText("That name is too long. Try again.");
            } else {
                adventurer.setPlayerName(textField.getText());
                createMainScreen();
            }
        });

        root.getChildren().addAll(label, textField, confirm);
        currentStage.setScene(new Scene(root));
    } //end createNamingScreen()

    /**
     * creates the main menu screen of the game
     */
    public void createMainScreen() {
        //main menu
        BorderPane mainPane = new BorderPane();
        mainPane.setPrefSize(sceneWidth, sceneHeight);
        mainPane.setStyle("-fx-background-color: lightblue;");

        //container for player options
        HBox bottomBox = new HBox();
        bottomBox.setPrefSize(200, 100);
        bottomBox.setAlignment(javafx.geometry.Pos.CENTER);
        bottomBox.setStyle("-fx-background-color: #6F4E37;");

        //first player option fight
        Button fightBtn = new Button("Fight");
        fightBtn.setPrefSize(138, 61);
        fightBtn.setStyle("-fx-background-color: #6F4E37; -fx-font-weight: bold;");
        fightBtn.setFont(new Font("Times New Roman", 24));
        //temp code to show TicTacToe Game
        fightBtn.setOnAction(e -> {
            RandomEvent randomEvent = new RandomEvent();
            randomEvent.generateRandomEvent();
        });

        //second player option store
        Button storeBtn = new Button("Store");
        storeBtn.setPrefSize(138, 61);
        storeBtn.setStyle("-fx-background-color: #6F4E37; -fx-font-weight: bold;");
        storeBtn.setFont(new Font("Times New Roman", 24));

        //third player option bag
        Button bagBtn = new Button("Bag");
        bagBtn.setPrefSize(138, 61);
        bagBtn.setStyle("-fx-background-color: #6F4E37; -fx-font-weight: bold;");
        bagBtn.setFont(new Font("Times New Roman", 24));

        //fourth player option profile
        Button profileBtn = new Button("Profile");
        profileBtn.setPrefSize(138, 61);
        profileBtn.setStyle("-fx-background-color: #6F4E37; -fx-font-weight: bold;");
        profileBtn.setFont(new Font("Times New Roman", 24));
        profileBtn.setOnAction(e -> {
            createProfile();
        });

        bottomBox.getChildren().addAll(fightBtn, storeBtn, bagBtn, profileBtn);
        mainPane.setBottom(bottomBox);
        currentStage.setScene(new Scene(mainPane));
    } //end createMainScreen()

    /**
     * creates the profile screen
     */
    public void createProfile() {
        AnchorPane profileView = new AnchorPane();
        profileView.setPrefSize(sceneWidth, sceneHeight);
        profileView.setStyle("-fx-background-color: #6F4E37;");

        VBox leftVBox = new VBox();
        leftVBox.setPrefSize(265, 700);
        leftVBox.setPadding(new Insets(10));
        leftVBox.setStyle("-fx-background-color: #6F4E37;");
        AnchorPane.setLeftAnchor(leftVBox, 10.0);

        Label healthLabel = new Label("Health: " + adventurer.getHealth());
        healthLabel.setStyle("-fx-font-weight: bold;");
        healthLabel.setFont(new Font("Times New Roman", 36));

        Label strengthLabel = new Label("Strength: " + adventurer.getStrength());
        strengthLabel.setStyle("-fx-font-weight: bold;");
        strengthLabel.setFont(new Font("Times New Roman", 36));

        Label defenseLabel = new Label("Defense: " + adventurer.getDefense());
        defenseLabel.setStyle("-fx-font-weight: bold;");
        defenseLabel.setFont(new Font("Times New Roman", 36));

        Label goldLabel = new Label("Gold: " + adventurer.getGold());
        goldLabel.setStyle("-fx-font-weight: bold;");
        goldLabel.setFont(new Font("Times New Roman", 36));

        leftVBox.getChildren().addAll(healthLabel, strengthLabel, defenseLabel, goldLabel);

        VBox rightVBox = new VBox();
        rightVBox.setPrefSize(265, 700);
        rightVBox.setAlignment(javafx.geometry.Pos.CENTER);
        AnchorPane.setRightAnchor(rightVBox, 10.0);

        Label adventurerLabel = new Label(adventurer.getPlayerName());
        adventurerLabel.setStyle("-fx-font-weight: bold;");
        adventurerLabel.setFont(new Font("Times New Roman", 44));

        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(276, 122);
        exitButton.setStyle("-fx-font-weight: bold; -fx-background-color: #6F4E37;");
        exitButton.setFont(new Font("Times New Roman", 24));
        exitButton.setOnAction(e -> {
            createMainScreen();
        });

        ImageView profileImage = new ImageView(new Image("Stick_Figure.svg.png"));
        profileImage.setFitWidth(400);
        profileImage.setFitHeight(565);

        rightVBox.getChildren().addAll(adventurerLabel, profileImage, exitButton);
        profileView.getChildren().addAll(leftVBox, rightVBox);

        currentStage.setScene(new Scene(profileView));
    } //end createProfile()

    /**
     * set up gold label for minigame screens
     */
    public void updateGoldLabel() {
        if (adventurer.getGold() < 0) {
            adventurer.setGold(0);
        }
        goldLabel.setText("GOLD: " + adventurer.getGold());
        goldLabel.setFont(new Font("Times New Roman", 42));
        goldLabel.setLayoutX(14);
        goldLabel.setLayoutY(620);
        goldLabel.setPrefSize(215, 76);
        goldLabel.setTextFill(javafx.scene.paint.Color.valueOf("#eaf86c"));
    } //end setUpGoldLabel()
}