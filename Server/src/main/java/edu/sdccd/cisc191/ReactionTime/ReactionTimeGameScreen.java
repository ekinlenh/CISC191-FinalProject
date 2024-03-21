package edu.sdccd.cisc191.ReactionTime;

import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ReactionTimeGameScreen extends SceneController {
    private FlowPane board;
    private AnchorPane layout;
    private Button playAgainButton;
    private Button exitButton;
    private ImageView startButton;
    private Text resultText;
    private Timer timer;
    private long startTime;

    public void createReactionTime() {
        // Initialize layout and set background
        layout = new AnchorPane();
        layout.setPrefSize(1000, 700);
        int temp = games.indexOf("ReactionTime");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        layout.setBackground(new Background(bgImage));

        // Initialize board (FlowPane) to hold cards
        board = new FlowPane();
        board.setLayoutX(490);
        board.setLayoutY(119);
        board.setStyle("-fx-pref-height: 510; -fx-pref-width: 510;");

        // Initialize "Play Again" button
        playAgainButton = new Button("Play Again");
        playAgainButton.setOnAction(event -> playAgain());
        playAgainButton.setLayoutX(20);
        playAgainButton.setLayoutY(20);
        playAgainButton.setVisible(true);

        // Initialize "Exit" button
        exitButton = new Button("Exit");
        exitButton.setOnAction(event -> exit());
        exitButton.setLayoutX(100);
        exitButton.setLayoutY(20);
        exitButton.setVisible(true);

        // Initialize result text
        resultText = new Text();
        resultText.setFont(Font.font(24));
        resultText.setLayoutX(425);
        resultText.setLayoutY(375);
        resultText.setVisible(true);

        // Load button images
        Image greenButtonImage = new Image("ReactionTime/green_button.png");
        Image greyButtonImage = new Image("ReactionTime/grey_button.png");

        // Initialize start button as ImageView with grey button image
        startButton = new ImageView(greyButtonImage);
        startButton.setFitWidth(150);
        startButton.setFitHeight(50);
        startButton.setLayoutX(425);
        startButton.setLayoutY(300);
        startButton.setOnMouseClicked(event -> startGame());

        // Add components to layout
        layout.getChildren().addAll(board, startButton, playAgainButton, exitButton, resultText);

        // Set scene
        currentStage.setScene(new Scene(layout));
    }

    private void startGame() {
        startButton.setDisable(true);
        resultText.setText("");

        // Set a random delay before the button turns green
        Random random = new Random();
        long delay = (long) (random.nextDouble() * 3000); // Random delay up to 3 seconds

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> turnButtonGreen());
            }
        }, delay);
    }

    private void turnButtonGreen() {
        startTime = System.currentTimeMillis();
        startButton.setImage(new Image("ReactionTime/green_button.png"));
        startButton.setOnMouseClicked(event -> checkReactionTime());
    }

    private void checkReactionTime() {
        long reactionTime = System.currentTimeMillis() - startTime;
        if (reactionTime < 500) {
            resultText.setText("Your reaction time: " + reactionTime + " milliseconds. You win!");
        } else {
            resultText.setText("Your reaction time: " + reactionTime + " milliseconds. Too slow! You lose!");
        }

        resultText.setVisible(true);
        startButton.setDisable(true);
        playAgainButton.setVisible(true);
        exitButton.setVisible(true);
    }

    private void playAgain() {
        layout.getChildren().removeAll(playAgainButton, exitButton, resultText);
        startButton.setDisable(false);
        startButton.setImage(new Image("ReactionTime/grey_button.png")); // Reset button image
        boolean gameStarted = false;
        startGame(); // Restart the game
    }

    // Method to handle "Exit" button click
    private void exit() {
        // Close the application
        currentStage.close();
    }

    private void startTimer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                long elapsedTime = System.currentTimeMillis() - startTime;
                if (elapsedTime > 500) {
                    Platform.runLater(() -> {
                        resultText.setText("Your reaction time: " + elapsedTime + " milliseconds. Too slow! You lose!");
                        resultText.setVisible(true);
                        startButton.setDisable(true);
                        playAgainButton.setVisible(true);
                        exitButton.setVisible(true);
                    });
                    timer.cancel();
                }
            }
        }, 0, 10); // Check every 10 milliseconds
    }

    public void onClose() {
        if (timer != null) {
            timer.cancel();
        }
    }
}


