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

    /**
     * creates the intro of the game that asks player to choose class
     * @return the intro scene
     */
    public Scene createIntroScreen() {
        //introduction
        Pane root = new Pane();

        ImageView background = new ImageView(new Image("start.png"));
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
        playButton.setOnMouseClicked(e -> createNamingScreen());
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

        return new Scene(root);
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
        //main menu
        BorderPane mainPane = new BorderPane();
        mainPane.setPrefSize(sceneWidth, sceneHeight);
        mainPane.setStyle("-fx-background-color: lightblue;");

        //container for player options
        HBox bottomBox = new HBox();
        bottomBox.setPrefSize(200, 100);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setStyle("-fx-background-color: #6F4E37;");

        //first player option fight
        Button fightBtn = new Button("Fight");
        fightBtn.setPrefSize(138, 61);
        fightBtn.setStyle("-fx-background-color: #6F4E37; -fx-font-weight: bold;");
        fightBtn.setFont(new Font("Times New Roman", 24));
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

        Label games = new Label("Games Won: " + gamesWon);
        games.setPrefSize(350, 60);
        games.setStyle("-fx-background-color: #6F4E37; -fx-font-weight: bold");
        games.setFont(new Font("Times New Roman", 44));
        games.setAlignment(Pos.CENTER);

        timerLabel.setStyle("-fx-background-color: #6F4E37; -fx-font-weight: bold");
        timerLabel.setFont(new Font("Times New Roman", 44));
        timerLabel.setPrefSize(200, 60);
        timerLabel.setAlignment(Pos.CENTER);

        AnchorPane temp = new AnchorPane();
        temp.setPrefSize(sceneWidth, 70);
        temp.getChildren().addAll(games, timerLabel);
        temp.setStyle("-fx-background-color: #6F4E37");
        AnchorPane.setLeftAnchor(games, 10.0);
        AnchorPane.setRightAnchor(timerLabel, 10.0);

        bottomBox.getChildren().addAll(fightBtn, storeBtn, bagBtn, profileBtn);
        mainPane.setBottom(bottomBox);
        mainPane.setTop(temp);
        mainPane.setCenter(gameEnd);
        currentStage.setScene(new Scene(mainPane));

        gameEnd.setVisible(false);
        if (gamesWon == 9) {
            openGameEnd();
        }

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