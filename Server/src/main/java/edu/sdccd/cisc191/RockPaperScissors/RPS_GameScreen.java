package edu.sdccd.cisc191.RockPaperScissors;

import edu.sdccd.cisc191.Scenes.AlertBox;
import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.text.DecimalFormat;

public class RPS_GameScreen extends SceneController {

    protected static Label score = new Label();
    protected static Label titleLabel = new Label("Rock Paper Scissors");
    protected static Label rockyScore = new Label();
    protected static Label teenScore = new Label();
    protected static ImageView paperImg = new ImageView();
    protected static ImageView rockImg = new ImageView();
    protected static ImageView scissorsImg = new ImageView();
    protected static ImageView npcRockImg = new ImageView();
    protected static ImageView npcPaperImg = new ImageView();
    protected static ImageView npcScissorsImg = new ImageView();
    protected static String playerChoice;
    protected static double playerWins = 0, npcWins = 0;
    private static final RPS_NPC_Controller npcController = new RPS_NPC_Controller();
    private static final Button exitButton = new Button("Exit");
    private static final Button playAgain = new Button("Play Again");

    /**
     * create rock paper scissors game screen
     */
    public void createRockPaperScissorsScreen() {
        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        int temp = games.indexOf("RockPaperScissors");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 800, false, false, false, false));
        root.setBackground(new Background(bgImage));

        Line line1 = new Line(-34, 9.5, -34, 617);
        line1.setLayoutX(534);
        line1.setLayoutY(88);
        line1.setStroke(javafx.scene.paint.Color.valueOf("#4a6741"));
        line1.setStrokeWidth(5.0);

        titleLabel.setStyle("-fx-background-color: #4a6741;");
        titleLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);
        titleLabel.setFont(new Font("Elephant", 48));
        titleLabel.setPrefWidth(1000);
        titleLabel.setPrefHeight(95);

        ImageView rockyProfile = new ImageView(new Image("CharacterImages/rockyProfile.png"));
        rockyProfile.setLayoutX(148);
        rockyProfile.setLayoutY(192);
        rockyProfile.setFitWidth(199);
        rockyProfile.setFitHeight(271);

        Rectangle rectangle1 = new Rectangle(200, 247);
        rectangle1.setLayoutX(148);
        rectangle1.setLayoutY(216);
        rectangle1.setArcWidth(5.0);
        rectangle1.setArcHeight(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.valueOf("#1f93ff00"));
        rectangle1.setStroke(javafx.scene.paint.Color.valueOf("#4a6741"));
        rectangle1.setStrokeWidth(5.0);

        HBox hBox1 = new HBox();
        hBox1.setLayoutY(480);
        hBox1.setPrefWidth(495);
        hBox1.setPrefHeight(221);
        hBox1.setStyle("-fx-background-color: #4a6741;");
        hBox1.setAlignment(javafx.geometry.Pos.CENTER);

        rockImg.setImage(new Image("RPS/rock.png"));
        rockImg.setFitWidth(160);
        rockImg.setFitHeight(191);

        paperImg.setImage(new Image("RPS/paper.png"));
        paperImg.setFitWidth(160);
        paperImg.setFitHeight(195);

        scissorsImg.setImage(new Image("RPS/scissors.png"));
        scissorsImg.setFitWidth(160);
        scissorsImg.setFitHeight(195);

        hBox1.getChildren().addAll(rockImg, paperImg, scissorsImg);

        HBox hBox2 = new HBox();
        hBox2.setLayoutX(505);
        hBox2.setLayoutY(480);
        hBox2.setPrefWidth(495);
        hBox2.setPrefHeight(221);
        hBox2.setStyle("-fx-background-color: #4a6741;");
        hBox2.setAlignment(javafx.geometry.Pos.CENTER);

        npcRockImg.setImage(new Image("RPS/rock.png"));
        npcRockImg.setFitWidth(160);
        npcRockImg.setFitHeight(191);

        npcPaperImg.setImage(new Image("RPS/paper.png"));
        npcPaperImg.setFitWidth(160);
        npcPaperImg.setFitHeight(195);

        npcScissorsImg.setImage(new Image("RPS/scissors.png"));
        npcScissorsImg.setFitWidth(160);
        npcScissorsImg.setFitHeight(195);

        hBox2.getChildren().addAll(npcRockImg, npcPaperImg, npcScissorsImg);

        ImageView teenProfile = new ImageView(new Image("CharacterImages/teen.png"));
        teenProfile.setLayoutX(654);
        teenProfile.setLayoutY(259);
        teenProfile.setFitWidth(199);
        teenProfile.setFitHeight(212);

        Rectangle rectangle2 = new Rectangle(200, 247);
        rectangle2.setLayoutX(653);
        rectangle2.setLayoutY(216);
        rectangle2.setArcWidth(5.0);
        rectangle2.setArcHeight(5.0);
        rectangle2.setFill(javafx.scene.paint.Color.valueOf("#1f93ff00"));
        rectangle2.setStroke(javafx.scene.paint.Color.valueOf("#4a6741"));
        rectangle2.setStrokeWidth(5.0);

        exitButton.setLayoutX(437);
        exitButton.setVisible(false);
        exitButton.setLayoutY(413);
        exitButton.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%;");
        exitButton.setTextFill(javafx.scene.paint.Color.WHITE);
        exitButton.setFont(new Font("Elephant", 18));
        exitButton.setPrefWidth(126);
        exitButton.setPrefHeight(66);
        exitButton.setOnAction(e -> {
            playerWins = 0;
            npcWins = 0;
            createMainScreen();
            resetGame();
        });

        score.setLayoutX(376);
        score.setLayoutY(145);
        score.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%;");
        score.setTextFill(javafx.scene.paint.Color.WHITE);
        score.setFont(new Font("Elephant", 24));
        score.setPrefWidth(253);
        score.setPrefHeight(95);
        score.setAlignment(Pos.CENTER);

        playAgain.setVisible(false);
        playAgain.setLayoutX(437);
        playAgain.setLayoutY(340);
        playAgain.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%;");
        playAgain.setTextFill(javafx.scene.paint.Color.WHITE);
        playAgain.setFont(new Font("Elephant", 18));
        playAgain.setPrefWidth(126);
        playAgain.setPrefHeight(66);
        playAgain.setOnAction(e -> {
            titleLabel.setText("Rock Paper Scissors");
            resetGame();
        });

        rockyScore.setLayoutX(148);
        rockyScore.setLayoutY(108);
        rockyScore.setPrefWidth(200);
        rockyScore.setPrefHeight(116);
        rockyScore.setStyle("-fx-background-color: #4a6741;");
        rockyScore.setTextFill(javafx.scene.paint.Color.WHITE);
        rockyScore.setFont(new Font("Elephant", 48));
        rockyScore.setAlignment(Pos.CENTER);

        teenScore.setLayoutX(653);
        teenScore.setLayoutY(108);
        teenScore.setPrefWidth(200);
        teenScore.setPrefHeight(116);
        teenScore.setStyle("-fx-background-color: #4a6741;");
        teenScore.setTextFill(javafx.scene.paint.Color.WHITE);
        teenScore.setFont(new Font("Elephant", 48));
        teenScore.setAlignment(Pos.CENTER);

        root.getChildren().addAll(line1, titleLabel, rockyProfile, teenProfile, hBox1, hBox2, rectangle1, rockyScore, rectangle2, teenScore, score, playAgain, exitButton);
        currentStage.setScene(new Scene(root));

        setUpPlayerControls();
        updateScoreLabel();
        AlertBox.display("Rock Paper Scissors", "First to a score of 3.");
    } //end createRockPaperScissorsScreen()

    /**
     * update score label
     */
    public void updateScoreLabel() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String pWins = decimalFormat.format(playerWins);
        String nWins = decimalFormat.format(npcWins);
        rockyScore.setText(String.valueOf(decimalFormat.format(playerWins)));
        teenScore.setText(String.valueOf(decimalFormat.format(npcWins)));
        score.setText("Score: " + pWins + " - " + nWins);
    } //end updateScoreLabel()

    /**
     * set up player controls when clicking their choice
     */
    private void setUpPlayerControls() {
        //rock image
        rockImg.setOnMouseClicked(e -> {
            paperImg.setOpacity(0.5);
            paperImg.setDisable(true);
            scissorsImg.setOpacity(0.5);
            scissorsImg.setDisable(true);
            playerChoice = "Rock";

            npcController.makeNPCMove();
        });

        //paper image
        paperImg.setOnMouseClicked(e -> {
            rockImg.setOpacity(0.5);
            rockImg.setDisable(true);
            scissorsImg.setOpacity(0.5);
            scissorsImg.setDisable(true);
            playerChoice = "Paper";

            npcController.makeNPCMove();
        });

        //scissors image
        scissorsImg.setOnMouseClicked(e -> {
            rockImg.setOpacity(0.5);
            rockImg.setDisable(true);
            paperImg.setOpacity(0.5);
            paperImg.setDisable(true);
            playerChoice = "Scissors";

            npcController.makeNPCMove();
        });
    } //end setUpPlayerControl()

    /**
     * resets game once player leaves screen
     */
    private void resetGame() {
        rockImg.setDisable(false);
        rockImg.setOpacity(1);
        paperImg.setDisable(false);
        paperImg.setOpacity(1);
        scissorsImg.setDisable(false);
        scissorsImg.setOpacity(1);

        npcRockImg.setDisable(true);
        npcRockImg.setOpacity(1);
        npcPaperImg.setDisable(true);
        npcPaperImg.setOpacity(1);
        npcScissorsImg.setDisable(true);
        npcScissorsImg.setOpacity(1);

        playerChoice = "";
        playAgain.setVisible(false);
    } //end resetGame()

    /**
     * ends game by disabling all images
     */
    public void endGame() {
        rockImg.setDisable(true);
        paperImg.setDisable(true);
        scissorsImg.setDisable(true);
        if (playerWins >= 3.0) {
            gamesWon++;
            exitButton.setVisible(true);
            ProgressScenes.changeScene();
        } else if (npcWins >= 3.0) {
            exitButton.setVisible(true);
            updateLosses();
        }
        else {
            playAgain.setVisible(true);
        }
    } //end endGame()
}
