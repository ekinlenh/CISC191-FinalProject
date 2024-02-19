package edu.sdccd.cisc191;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SceneController extends GUI {
    private final static double sceneWidth = 1000.0, sceneHeight = 700.0;

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
        warriorButton.setPrefSize(200, 75);
        warriorButton.setStyle("-fx-background-radius: 25; -fx-background-color: white;");
        warriorButton.setFont(new Font("Times New Roman", 32));
        warriorButton.setOnAction(e -> {
            adventurer = new Player("Warrior", 100, 90, 60);
            createMainScreen();
        });

        //tank class
        Button tankButton = new Button("Tank");
        tankButton.setPrefSize(165, 75);
        tankButton.setStyle("-fx-background-radius: 25; -fx-background-color: white;");
        tankButton.setFont(new Font("Times New Roman", 32));
        tankButton.setOnAction(e -> {
            adventurer = new Player("Tank", 135, 30, 85);
            createMainScreen();
        });

        //assassin class
        Button assassinButton = new Button("Assassin");
        assassinButton.setPrefSize(165, 75);
        assassinButton.setStyle("-fx-background-radius: 25; -fx-background-color: white;");
        assassinButton.setFont(new Font("Times New Roman", 32));
        assassinButton.setOnAction(e -> {
            adventurer = new Player("Assassin", 80, 125, 45);
            createMainScreen();
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
    }

    /**
     * creates the main menu screen of the game
     */
    private void createMainScreen() {
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
            TicTacToeGameScreen ticTacToeScreen = new TicTacToeGameScreen();
            currentStage.setScene(ticTacToeScreen.createTicTacToe());
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
    }

    /**
     * creates the profile screen
     */
    private void createProfile() {
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
    }
}
