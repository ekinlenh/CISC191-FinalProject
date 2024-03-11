package edu.sdccd.cisc191;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class SceneController extends GUI{
    private final static double sceneWidth = 1000.0, sceneHeight = 700.0;
    protected static Label goldLabel = new Label();
    protected static Button gameEnd = new Button("You Have Won.");
    protected static double original = 0.05;
    protected static ProgressBar progressBar = new ProgressBar(original);


    /**
     * creates the intro of the game that asks player to choose class*/
    public void createIntroScreen() {
        //introduction
        Pane root = new Pane();

        ImageView background = new ImageView(new Image("Scenes/start.png"));
        background.setFitWidth(1000);
        background.setFitHeight(700);
        root.getChildren().add(background);

        Button playButton = new Button("Play");
        playButton.setLayoutX(414);
        playButton.setLayoutY(430);
        playButton.setPrefSize(172, 72);
        playButton.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%");
        playButton.setTextFill(javafx.scene.paint.Color.WHITE);
        playButton.setFont(new Font("Elephant", 18));
        playButton.setOnMouseClicked(e -> {
            createNamingScreen();
            timer.play();

        });
        root.getChildren().add(playButton);

        Button leaderboardButton = new Button("Leaderboard");
        leaderboardButton.setLayoutX(398);
        leaderboardButton.setLayoutY(596);
        leaderboardButton.setPrefSize(204, 72);
        leaderboardButton.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%;");
        leaderboardButton.setTextFill(javafx.scene.paint.Color.WHITE);
        leaderboardButton.setFont(new Font("Elephant", 18));
        root.getChildren().add(leaderboardButton);

        Button exitButton = new Button("Exit");
        exitButton.setLayoutX(414);
        exitButton.setLayoutY(513);
        exitButton.setPrefSize(172, 72);
        exitButton.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%;");
        exitButton.setTextFill(javafx.scene.paint.Color.WHITE);
        exitButton.setFont(new Font("Elephant", 18));
        exitButton.setOnMouseClicked(e -> Platform.exit());
        root.getChildren().add(exitButton);

        ImageView monkeyImage = new ImageView(new Image("CharacterImages/rocky.png"));
        monkeyImage.setFitWidth(375);
        monkeyImage.setFitHeight(331);
        monkeyImage.setLayoutY(369);
        root.getChildren().add(monkeyImage);

        Label titleLabel = new Label("Monkey Rush");
        titleLabel.setLayoutX(254);
        titleLabel.setLayoutY(23);
        titleLabel.setPrefSize(492, 100);
        titleLabel.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 15%;");
        titleLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        titleLabel.setFont(new Font("Elephant", 64));
        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);
        root.getChildren().add(titleLabel);

        currentStage.setScene(new Scene(root));
    } //end createIntroScreen

    /**
     * create the ask player name screen of the game
     */
    public void createNamingScreen() {
        NamingScreen namingScreen = new NamingScreen();
        namingScreen.createScene();
    } //end createNamingScreen()

    /**
     * creates the main menu screen of the game
     */
    public void createMainScreen() {
        Pane root = new Pane();
        root.setPrefSize(sceneWidth, sceneHeight);
        // ImageView 1
        ImageView imageView1 = new ImageView(backgrounds[count]);
        imageView1.setFitWidth(1000.0);
        imageView1.setFitHeight(700.0);
        root.getChildren().add(imageView1);

        // ImageView 2
        ImageView imageView2 = new ImageView(new Image("rockyProfile.png"));
        imageView2.setFitWidth(332.0);
        imageView2.setFitHeight(385.0);
        imageView2.setLayoutY(315.0);

        // Label
        Button progress = new Button("Progress");
        progress.setFont(new Font("Elephant", 24.0));
        progress.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%;");
        progress.setPrefWidth(223.0);
        progress.setPrefHeight(74.0);
        progress.setAlignment(javafx.geometry.Pos.CENTER);
        progress.setLayoutX(389.0);
        progress.setLayoutY(377.0);
        progress.setTextFill(javafx.scene.paint.Color.WHITE);
        progress.setOnMouseClicked(e -> {
            RandomEvent randomEvent = new RandomEvent();
            randomEvent.generateRandomEvent();
        });

        // ProgressBar
        progressBar.setPrefWidth(365.0);
        progressBar.setPrefHeight(39.0);
        progressBar.setLayoutX(318.0);
        progressBar.setLayoutY(14.0);
        progressBar.setStyle("-fx-border-radius: 30%; -fx-control-inner-background: #6F4E37; -fx-accent: #4a6741; -fx-border-color: #4a6741;");

        // ImageView 3
        ImageView imageView3 = new ImageView(new Image("goldenPalace.png"));
        imageView3.setFitWidth(113.0);
        imageView3.setFitHeight(93.0);
        imageView3.setLayoutX(677.0);
        imageView3.setLayoutY(-7.0);

        // ImageView 4
        ImageView imageView4 = new ImageView(new Image("bridge.png"));
        imageView4.setFitWidth(132.0);
        imageView4.setFitHeight(74.0);
        imageView4.setLayoutX(185.0);
        imageView4.setLayoutY(-3.0);

        /* WIP
        Button label2 = new Button("Start Screen");
        label2.setFont(new Font("Elephant", 14.0));
        label2.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%;");
        label2.setPrefWidth(114.0);
        label2.setPrefHeight(39.0);
        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setLayoutX(872.0);
        label2.setLayoutY(647.0);
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setOnMouseClicked(e -> createIntroScreen());
        */

        // Add all children to the root pane
        root.getChildren().addAll(imageView2, progress, progressBar, imageView3, imageView4);
        currentStage.setScene(new Scene(root));
    } //end createMainScreen()

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


    /**
     * once player wins 9 games, lets them end the game
     */
    private void openGameEnd() {
        gameEnd.setAlignment(Pos.CENTER);
        gameEnd.setVisible(true);
        gameEnd.setPrefSize(500, 350);
        gameEnd.setFont(new Font("Times New Roman", 42));
        gameEnd.setStyle("-fx-font-weight: bold; -fx-background-color: #6F4E37; -fx-background-radius: 20%");
        gameEnd.setOnMouseClicked(e -> {
            createEndingScreen();
            timer.stop();
        });
    }

    /**
     * creates ending screen of game
     */
    public void createEndingScreen() {
        Pane pane = new Pane();
        pane.setPrefSize(sceneWidth, sceneHeight);
        pane.setStyle("-fx-background-color: #6F4E37;");

        Label titleLabel = new Label("NO SPOILERS");
        titleLabel.setPrefSize(443, 75);
        titleLabel.setLayoutX(10); // Center horizontally
        titleLabel.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        titleLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        titleLabel.setFont(new Font("Elephant", 48));

        Label completedTimeLabel = new Label("Completed Time: " + timerLabel.getText());
        completedTimeLabel.setPrefSize(sceneWidth, 100);
        completedTimeLabel.setLayoutY(598);
        completedTimeLabel.setAlignment(Pos.BOTTOM_LEFT);
        completedTimeLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        completedTimeLabel.setFont(new Font("Elephant", 48));

        pane.getChildren().addAll(titleLabel, completedTimeLabel);

        currentStage.setScene(new Scene(pane));
    } //end createEndingScreen()
}