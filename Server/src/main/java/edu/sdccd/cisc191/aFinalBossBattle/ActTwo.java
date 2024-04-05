package edu.sdccd.cisc191.aFinalBossBattle;

import edu.sdccd.cisc191.GameButton;
import edu.sdccd.cisc191.GameLabel;
import edu.sdccd.cisc191.Scenes.ProgressScenes;
import javafx.animation.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class ActTwo extends ActOne {

    private final PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2));
    private int currentDialogueIndex = 0;
    private GameLabel rockyText = new GameLabel(null, 416, 96, 14);
    private GameLabel elMonoText = new GameLabel(null, 416, 96, 14);
    private int rockyCount = 0;
    private int elMonoCount = 0;
    private final String[] rockyDialogues = {
            "Father...",
            "No. Father...I've grown stronger. \n"+ adventurer.getPlayerName() + " helped me get here, now I will end this.",
            "Yes, father. I will show you true strength."
    };
    private final String[] monoDialogues = {
            "You dare come back, Rocky? \nWith a friend, I see?",
            "You are still as pathetic as ever.\nA disgrace to this village.",
            "Do you really think you can beat me?"
    };
    private static final Pane root = new Pane();

    public void createScene() {
        root.setPrefSize(1000, 700);
        BackgroundImage bgImage = new BackgroundImage(backgrounds.head.data, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        root.setBackground(new Background(bgImage));

        ImageView rockyImageView = new ImageView(new Image("CharacterImages/rockyProfile.png"));
        rockyImageView.setFitWidth(219);
        rockyImageView.setFitHeight(252);
        rockyImageView.setLayoutX(130);
        rockyImageView.setLayoutY(176);

        ImageView monoImageView = new ImageView(new Image("CharacterImages/elMono.png"));
        monoImageView.setFitWidth(450);
        monoImageView.setFitHeight(462);
        monoImageView.setLayoutX(529);
        monoImageView.setLayoutY(199);

        elMonoText.setLayoutX(551);
        elMonoText.setLayoutY(65);
        elMonoText.setStyle("-fx-background-radius: 20%; -fx-font-size: 18");
        rockyText.setLayoutX(31);
        rockyText.setLayoutY(65);
        rockyText.setStyle("-fx-background-radius: 20%; -fx-font-size: 18");

        root.getChildren().addAll(rockyImageView, monoImageView, elMonoText, rockyText);

        currentStage.setScene(new Scene(root));

        animateText();
    }

    /**
     * animate text
     */
    private void animateText() {
        int totalDialogue = rockyDialogues.length + monoDialogues.length;
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            if (currentDialogueIndex % 2 == 0) {
                elMonoText.setText(monoDialogues[elMonoCount]);
                rockyText.setText(null);
                elMonoCount++;
            } else {
                rockyText.setText(rockyDialogues[rockyCount]);
                elMonoText.setText(null);
                rockyCount++;
            }

            currentDialogueIndex++;
        }));
        timeline.setCycleCount(totalDialogue); // Each character speaks once in a cycle
        timeline.play();
        timeline.setOnFinished(e -> {
            pauseTransition.play();
            pauseTransition.setOnFinished(event -> {
                elMonoText.setText("Hah! We'll see about that.");
                pauseTransition.play();
                pauseTransition.setOnFinished(event1 -> {
                    elMonoText.setText("Say your goodbyes to your friend\nwhile you still can.");
                    pauseTransition.play();
                    pauseTransition.setOnFinished(event2 -> {
                        createPlayerChat();
                    });
                });
            });
        });
    } //end animateText()

    /**
     *
     */
    private void createPlayerChat() {
        root.getChildren().clear();

        ImageView rockImage = new ImageView(new Image("CharacterImages/rockyProfile.png"));
        rockImage.setFitWidth(386);
        rockImage.setFitHeight(491);
        rockImage.setLayoutX(316);
        root.getChildren().add(rockImage);

        rockyText = new GameLabel(null, 457, 92, 18);
        rockyText.setText(adventurer.getPlayerName() + ", thank you for getting me this far. \nFrom now on, this will be my own fight.");
        rockyText.setStyle("-fx-background-radius: 20%; -fx-font-size: 18");
        rockyText.setLayoutX(272);
        rockyText.setLayoutY(468);
        root.getChildren().add(rockyText);

        GameButton responseButton = new GameButton("Will you be fine on your own?", 250, 64, 14);
        responseButton.setStyle("-fx-background-radius: 15%; -fx-font-size: 14; -fx-background-color: #6F4E37");
        responseButton.setOnMouseEntered(e -> responseButton.setStyle("-fx-background-radius: 15%; -fx-font-size: 14; -fx-background-color: #5C4033; -fx-font-family: Elephant"));
        responseButton.setOnMouseExited(e -> responseButton.setStyle("-fx-background-color: #6F4E37; -fx-background-radius: 15%; -fx-font-family: Elephant; -fx-font-size: 14"));        responseButton.setLayoutX(375);
        responseButton.setLayoutY(568);
        responseButton.setOnMouseClicked(e -> {
            rockyText.setText("My father might give me some trouble.");
            responseButton.setText("But would you lose?");
            responseButton.setOnAction(event -> {
                createFirstCutscene();
            });
        });
        root.getChildren().add(responseButton);
    } //end createPlayerChat()

    /**
     * begins the boss battle
     */
    private void beginBossBattle() {
        root.getChildren().clear();
        root.setBackground(ProgressScenes.getBackground());

        ImageView elMono = new ImageView(new Image("CharacterImages/elMono.png"));
        elMono.setFitWidth(420);
        elMono.setFitHeight(432);
        elMono.setLayoutX(270);
        root.getChildren().add(elMono);

        elMonoText = new GameLabel(null, 457, 92, 18);
        elMonoText.setText("Are you ready now?");
        elMonoText.setStyle("-fx-background-radius: 20%; -fx-font-size: 18");
        elMonoText.setLayoutX(272);
        elMonoText.setLayoutY(468);
        root.getChildren().add(elMonoText);

        GameButton responseButton = new GameButton("Yes.", 250, 64, 14);
        responseButton.setStyle("-fx-background-radius: 15%; -fx-font-size: 14; -fx-background-color: #6F4E37");
        responseButton.setOnMouseEntered(e -> responseButton.setStyle("-fx-background-radius: 15%; -fx-font-size: 14; -fx-background-color: #5C4033; -fx-font-family: Elephant"));
        responseButton.setOnMouseExited(e -> responseButton.setStyle("-fx-background-color: #6F4E37; -fx-background-radius: 15%; -fx-font-family: Elephant; -fx-font-size: 14"));        responseButton.setLayoutX(375);
        responseButton.setLayoutY(568);
        responseButton.setOnMouseClicked(e -> {
            elMonoText.setText("Then let's begin.");
            pauseTransition.play();
            pauseTransition.setOnFinished(event -> {
                createSecondCutscene();
            });
        });
        root.getChildren().add(responseButton);
    } //end beginBattle()

    /**
     * creates the first cutscene prior to entering the boss battle
     */
    private void createFirstCutscene() {
        root.getChildren().clear();
        Image cutsceneImage = new Image("CharacterImages/rockyGojo.png");
        BackgroundImage bgImage = new BackgroundImage(cutsceneImage, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        root.setBackground(new Background(bgImage));

        pauseTransition.play();
        pauseTransition.setOnFinished(e -> {
            makeFadeOutTransition();
        });
    } //end createCutScenes()

    /**
     * creates the second cutscene prior to entering the boss battle
     */
    private void createSecondCutscene() {
        root.getChildren().clear();
        Image cutsceneImage = new Image("CharacterImages/elMonoBattle.png");
        BackgroundImage bgImage = new BackgroundImage(cutsceneImage, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        root.setBackground(new Background(bgImage));

        StackPane temp = new StackPane();
        temp.setPrefHeight(100.0);
        temp.setPrefWidth(1000.0);
        temp.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");

        Label label = new Label();
        label.setPrefHeight(100.0);
        label.setPrefWidth(1000.0);
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Elephant", 56.0));

        root.getChildren().addAll(temp, label);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(0),
                        new KeyValue(label.textProperty(), "")));
        for (int i = 0; i < "Domain Expansion: Primal Jungle".length(); i++) {
            final int index = i;
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(i * 0.1),
                            e -> label.setText("Domain Expansion: Primal Jungle".substring(0, index + 1))));
        }

        pauseTransition.play();
        pauseTransition.setOnFinished(e -> {
            timeline.play();
            timeline.setOnFinished(event -> {
                BossBattle bossBattle = new BossBattle();
                bossBattle.createBossBattle();
            });
        });
    } //end createSecondCutscene()

    /**
     * the scene where it pops up saying you will now be playing as Rocky
     */
    private void changeToRocky() {
        makeFadeInTransition();
        root.setStyle("-fx-background-color: #000000");
        Label label = new Label();
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(5.0);
        label.setLayoutY(158.0);
        label.setPrefHeight(384.0);
        label.setPrefWidth(990.0);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Elephant", 52.0));
        root.getChildren().add(label);

        String text = "You will now be playing as Rocky.";
        int length = text.length();

        Timeline timeline = new Timeline();
        for (int i = 0; i < length; i++) {
            final int index = i;
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i * 0.2), e -> {
                String partialText = text.substring(0, index + 1);
                label.setText(partialText);
            });
            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(length * 0.3), e -> {
            beginBossBattle();
        }));

        timeline.play();
    }


    /**
     * makes a fade in transition between scenes
     */
    private void makeFadeInTransition() {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), root);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    } //end makeFadeInTransition()

    /**
     * makes a fade out transition between scenes
     */
    private void makeFadeOutTransition() {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), root);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.play();
        fadeTransition.setOnFinished(e -> {
            changeToRocky();
        });
    } //end makeFadeOutTransition
}
