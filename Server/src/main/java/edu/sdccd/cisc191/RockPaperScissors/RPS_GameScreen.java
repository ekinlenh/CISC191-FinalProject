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
import javafx.scene.text.Font;

import java.text.DecimalFormat;

public class RPS_GameScreen extends SceneController {

    protected static Label playerLabel = new Label("Player");
    protected static Label npcLabel = new Label("NPC");
    protected static Label score = new Label();
    protected static ImageView paperImg = new ImageView();
    protected static ImageView rockImg = new ImageView();
    protected static ImageView scissorsImg = new ImageView();
    protected static ImageView npcRockImg = new ImageView();
    protected static ImageView npcPaperImg = new ImageView();
    protected static ImageView npcScissorsImg = new ImageView();
    protected static String playerChoice;
    protected static double playerWins = 0, npcWins = 0;
    private static final RPS_NPC_Controller npcController = new RPS_NPC_Controller();
    private static final Button exitButton = new Button("EXIT");
    private static final Button playAgain = new Button();

    /**
     * create rock paper scissors game screen
     */
    public void createRockPaperScissorsScreen() {
        //Create Player Screen
        BorderPane playerPane = new BorderPane();
        playerPane.setPrefSize(500, 700);

        playerLabel.setFont(new Font("Times New Roman", 48));
        playerLabel.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(playerLabel, Pos.CENTER);
        playerPane.setTop(playerLabel);

        setUpRock(playerPane, rockImg);
        setUpPaper(playerPane, paperImg);
        setUpScissors(playerPane, scissorsImg);
        setUpPlayerControls();

        HBox hBox = new HBox(exitButton);
        hBox.setPrefSize(300, 100);
        playerPane.setBottom(hBox);

        // Create NPC Screen
        BorderPane npcPane = new BorderPane();
        npcPane.setPrefSize(500, 700);

        npcLabel.setFont(new Font("Times New Roman", 48));
        npcLabel.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(npcLabel, Pos.CENTER);
        npcPane.setTop(npcLabel);

        //exit button
        exitButton.setFont(new Font("Times New Roman", 24));
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> {
            playerWins = 0;
            npcWins = 0;
            createMainScreen();
            resetGame();
        });

        setUpRock(npcPane, npcRockImg);
        setUpPaper(npcPane, npcPaperImg);
        setUpScissors(npcPane, npcScissorsImg);
        npcRockImg.setDisable(true);
        npcPaperImg.setDisable(true);
        npcScissorsImg.setDisable(true);

        // Create Line
        Line line = new Line();
        line.setStartX(404);
        line.setStartY(1400);
        line.setEndX(410);
        line.setEndY(700);
        line.setStrokeWidth(5);

        //Score label
        score.setFont(new Font("Times New Roman", 48));
        updateScoreLabel();

        //Play again button
        playAgain.setFont(new Font("Times New Roman", 18));
        playAgain.setText("Play Again");
        playAgain.setVisible(false);
        playAgain.setPrefSize(120, 50);
        playAgain.setOnAction(e -> {
            resetGame();
        });

        HBox scoreAndPlay = new HBox(score, playAgain);
        scoreAndPlay.setPrefSize(300, 100);
        npcPane.setBottom(scoreAndPlay);
        scoreAndPlay.setSpacing(10); // Add spacing between score and playAgain button
        scoreAndPlay.setAlignment(Pos.CENTER_RIGHT); // Align HBox contents to the right
        BorderPane.setAlignment(scoreAndPlay, Pos.BOTTOM_RIGHT);

        // Create HBox to hold both BorderPanes and Line
        HBox hbox = new HBox(playerPane, line, npcPane);
        hbox.setPrefSize(1000, 700);
        int temp = games.indexOf("RockPaperScissors");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 800, false, false, false, false));
        hbox.setBackground(new Background(bgImage));

        // Create Scene
        Scene scene = new Scene(hbox);
        currentStage.setScene(scene);

        AlertBox.display("Rock Paper Scissors", "First to a score of 3.");
    } //end createRockPaperScissorsScreen()

    /**
     * update score label
     */
    public void updateScoreLabel() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String pWins = decimalFormat.format(playerWins);
        String nWins = decimalFormat.format(npcWins);
        score.setText("Score: " + pWins + " - " + nWins);
    } //end updateScoreLabel()

    /**
     * sets up rock image
     * @param pane takes in pane
     * @param r takes in rock image
     */
    private void setUpRock(BorderPane pane, ImageView r) {
        r.setFitWidth(160);
        r.setFitHeight(150);
        r.setImage(new Image("rock.png"));
        pane.setLeft(r);
        BorderPane.setAlignment(r, Pos.CENTER);
    } //end setUpRock()

    /**
     * sets up paper image
     * @param pane takes in pane
     * @param p takes in paper image
     */
    private void setUpPaper(BorderPane pane,ImageView p) {
        p.setFitWidth(160);
        p.setFitHeight(150);
        p.setImage(new Image("paper.png"));
        pane.setCenter(p);
    } //end setUpPaper()

    /**
     * sets up scissors image
     * @param pane takes in pane
     * @param s takes in scissors image
     */
    private void setUpScissors(BorderPane pane, ImageView s) {
        s.setFitWidth(160);
        s.setFitHeight(150);
        s.setImage(new Image("scissors.png"));
        pane.setRight(s);
        BorderPane.setAlignment(s, Pos.CENTER);
    } //end setUpScissors()

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
        playerLabel.setText("Player");
        rockImg.setDisable(false);
        rockImg.setOpacity(1);
        paperImg.setDisable(false);
        paperImg.setOpacity(1);
        scissorsImg.setDisable(false);
        scissorsImg.setOpacity(1);

        npcLabel.setText("NPC");
        npcRockImg.setDisable(true);
        npcRockImg.setOpacity(1);
        npcPaperImg.setDisable(true);
        npcPaperImg.setOpacity(1);
        npcScissorsImg.setDisable(true);
        npcScissorsImg.setOpacity(1);

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
