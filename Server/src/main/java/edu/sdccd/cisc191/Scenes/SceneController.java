package edu.sdccd.cisc191.Scenes;

import edu.sdccd.cisc191.Leaderboard;
import edu.sdccd.cisc191.Player;
import edu.sdccd.cisc191.Server;
import edu.sdccd.cisc191.aFinalBossBattle.FinalBossBattle;
import edu.sdccd.cisc191.GUI;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SceneController extends GUI {

    private final static double sceneWidth = 1000.0, sceneHeight = 700.0;

    protected static Label goldLabel = new Label();

    protected static Button gameEnd = new Button("You Have Won.");

    protected static double original = 0.05;

    protected static ProgressBar progressBar = new ProgressBar(original);

    protected static int losses = 0;

    protected static ImageView heart1 = new ImageView(new Image("CharacterImages/heart.png")),
                    heart2 = new ImageView(new Image("CharacterImages/heart.png")),
                    heart3 = new ImageView(new Image("CharacterImages/heart.png"));


    /**
     * creates the intro of the game that asks player to choose class
    */
    public static void createIntroScreen() {
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
    public static void createNamingScreen() {
        NamingScreen namingScreen = new NamingScreen();
        namingScreen.createScene();
    } //end createNamingScreen()

    /**
     * creates the main menu screen of the game
     */
    public void createMainScreen() {
        if (count == 8) {
            FinalBossBattle.createScreen();
        } else {
            Pane root = new Pane();
            root.setPrefSize(sceneWidth, sceneHeight);
            BackgroundImage bgImage = new BackgroundImage(backgrounds[count], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    new BackgroundSize(1000, 700, false, false, false, false));
            root.setBackground(new Background(bgImage));

            // ImageView 2
            ImageView imageView2 = new ImageView(new Image("CharacterImages/rockyProfile.png"));
            imageView2.setFitWidth(332.0);
            imageView2.setFitHeight(385.0);
            imageView2.setLayoutY(315.0);

            // Button
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

            gameEnd.setVisible(false);

            // Add all children to the root pane
            root.getChildren().addAll(imageView2, progress, progressBar, imageView3, imageView4, showLives(), gameEnd);
            currentStage.setScene(new Scene(root));

            if (losses == 3) {
                heart3.setImage(new Image("CharacterImages/brokenheart.png"));
                createGameOver();
            }
        }
    } //end createMainScreen()

    /**
     * show lives of player
     */
    public static GridPane showLives() {
        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(85.0);
        gridPane.setLayoutY(343.0);
        gridPane.setPrefHeight(50.0);
        gridPane.setPrefWidth(150.0);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        col1.setMinWidth(10.0);
        col1.setPrefWidth(100.0);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        col2.setMinWidth(10.0);
        col2.setPrefWidth(100.0);

        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        col3.setMinWidth(10.0);
        col3.setPrefWidth(100.0);

        gridPane.getColumnConstraints().addAll(col1, col2, col3);

        RowConstraints row1 = new RowConstraints();
        row1.setMinHeight(10.0);
        row1.setPrefHeight(30.0);
        row1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        gridPane.getRowConstraints().add(row1);

        heart1.setFitHeight(51.0);
        heart1.setFitWidth(51.0);
        heart1.setPreserveRatio(true);
        GridPane.setColumnIndex(heart1, 0);

        heart2.setFitHeight(51.0);
        heart2.setFitWidth(51.0);
        heart2.setPreserveRatio(true);
        GridPane.setColumnIndex(heart2, 1);

        heart3.setFitHeight(51.0);
        heart3.setFitWidth(51.0);
        heart3.setPreserveRatio(true);
        GridPane.setColumnIndex(heart3, 2);

        gridPane.getChildren().addAll(heart1, heart2, heart3);
        return gridPane;
    } //end showLives()

    /**
     * update player losses
     */
    public static void updateLosses() {
        losses++;

        if (losses == 1) {
            heart1.setImage(new Image("CharacterImages/brokenheart.png"));
        }

        if (losses == 2) {
            heart2.setImage(new Image("CharacterImages/brokenheart.png"));
        }
    } //end updateLosses()

    /**
     * game over screen once player loses 3 hearts
     */
    public static void createGameOver() {
        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        BackgroundImage bgImage = new BackgroundImage(backgrounds[count], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        root.setBackground(new Background(bgImage));

        ImageView imageView = new ImageView(new Image("CharacterImages/rockyDead.png"));
        imageView.setFitWidth(460);
        imageView.setFitHeight(427);
        imageView.setLayoutX(270);
        imageView.setLayoutY(129);
        root.getChildren().add(imageView);

        Label label = new Label("GAME OVER");
        label.setPrefSize(758, 122);
        label.setLayoutX(121);
        label.setLayoutY(7);
        label.setStyle("-fx-background-color: #4a6741;");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Elephant", 96));
        label.setAlignment(javafx.geometry.Pos.CENTER);
        root.getChildren().add(label);

        Button restartButton = new Button("Restart");
        restartButton.setPrefSize(262, 97);
        restartButton.setLayoutX(223);
        restartButton.setLayoutY(556);
        restartButton.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%;");
        restartButton.setTextFill(javafx.scene.paint.Color.WHITE);
        restartButton.setFont(new Font("Elephant", 48));
        restartButton.setOnMouseClicked(e -> {
            /** W.I.P DO NOT TOUCH!!
            // Reset game state
            adventurer = new Player();
            gamesWon = 0;
            losses = 0;
            timerLabel.setText(""); // Reset timer label text
            original = 0.1;
            progressBar.setProgress(original); // Reset progress bar
            count = 0;
            backGroundImage = 0;
            ProgressScenes.randomizeGameOrder();
            heart1.setImage(new Image("CharacterImages/heart.png"));
            heart2.setImage(new Image("CharacterImages/heart.png"));
            heart3.setImage(new Image("CharacterImages/heart.png"));

            // Show intro screen
            createIntroScreen();
             */
        });
        root.getChildren().add(restartButton);

        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(262, 97);
        exitButton.setLayoutX(515);
        exitButton.setLayoutY(556);
        exitButton.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%;");
        exitButton.setTextFill(javafx.scene.paint.Color.WHITE);
        exitButton.setFont(new Font("Elephant", 48));
        exitButton.setOnMouseClicked(e -> Platform.exit());
        root.getChildren().add(exitButton);

        currentStage.setScene(new Scene(root));
    } //end createGameOver()

    /**
     * once player wins 9 games, lets them end the game
     */
    public static void openGameEnd() {
        gameEnd.setAlignment(Pos.CENTER);
        gameEnd.setVisible(true);
        gameEnd.setPrefSize(500, 350);
        gameEnd.setFont(new Font("Elephant", 42));
        gameEnd.setStyle("-fx-font-weight: bold; -fx-background-color: #4a6741; -fx-background-radius: 20%;");
        gameEnd.setOnMouseClicked(e -> {
            createEndingScreen();
            timer.stop();

            leaderboard.addToLeaderboard(adventurer.getPlayerName(), timerLabel.getText());
        });
    }

    /**
     * creates ending screen of game
     */
    private static void createEndingScreen() {
        Pane pane = new Pane();
        pane.setPrefSize(1000, 700);
        pane.setStyle("-fx-background-color: #6F4E37");

        Label titleLabel = new Label("NO SPOILERS");
        titleLabel.setPrefSize(443, 75);
        titleLabel.setLayoutX(10);
        titleLabel.setAlignment(Pos.TOP_CENTER);
        titleLabel.setFont(new Font("Elephant", 48));

        Label completedTimeLabel = new Label("Completed Time: " + timerLabel.getText());
        completedTimeLabel.setPrefSize(1000, 100);
        completedTimeLabel.setLayoutY(598);
        completedTimeLabel.setAlignment(Pos.BOTTOM_LEFT);
        completedTimeLabel.setTextFill(Color.WHITE);
        completedTimeLabel.setFont(new Font("Elephant", 48));

        pane.getChildren().addAll(titleLabel, completedTimeLabel);
        currentStage.setScene(new Scene(pane));
    }

}