package edu.sdccd.cisc191.aFinalBossBattle;

import edu.sdccd.cisc191.JavaFXStyles;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class ActTwo extends FinalBossBattle {

    private int currentDialogueIndex = 0;
    private final Label rockyText = new Label();
    private final Label elMonoText = new Label();
    private int rockyCount = 0;
    private int elMonoCount = 0;
    private final String[] rockyDialogues = {
            "Father...",
            "No. Father...I've grown stronger. \n"+ adventurer.getPlayerName() + "helped me get here, now I will end this.",
            "Yes, father. I will show you true strength."
    };
    private final String[] monoDialogues = {
            "You dare come back, Rocky? \nWith a friend, I see?",
            "You are still as pathetic as ever.\nA disgrace to this village.",
            "Do you really think you can beat me?"
    };

    public void createScene() {
        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        BackgroundImage bgImage = new BackgroundImage(backgrounds[count], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
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

        JavaFXStyles<Label> styler = new JavaFXStyles<>(elMonoText);
        styler.setFXStyle();
        elMonoText.setAlignment(javafx.geometry.Pos.CENTER);
        elMonoText.setLayoutX(551);
        elMonoText.setLayoutY(65);
        elMonoText.setPrefSize(416, 96);

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                -62.0, 2.0,
                43.0, 2.0,
                -14.0, 40.0
        );
        polygon.setLayoutX(768);
        polygon.setLayoutY(159);
        polygon.setFill(Color.web("#4a6741"));
        polygon.setStroke(Color.web("#4a6741"));
        polygon.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        styler = new JavaFXStyles<>(rockyText);
        styler.setFXStyle();
        rockyText.setAlignment(javafx.geometry.Pos.CENTER);
        rockyText.setLayoutX(31);
        rockyText.setLayoutY(65);
        rockyText.setPrefSize(416, 96);

        root.getChildren().addAll(rockyImageView, monoImageView, elMonoText, polygon, rockyText);

        currentStage.setScene(new Scene(root));

        animateText();
    }

    /**
     * animate text
     */
    private void animateText() {
        int totalDialogue = rockyDialogues.length + monoDialogues.length;

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            if (currentDialogueIndex % 2 == 0 && currentDialogueIndex < monoDialogues.length * 2) {
                elMonoText.setText(monoDialogues[elMonoCount]);
                rockyText.setText(null);
                elMonoCount++;
            } else if (currentDialogueIndex % 2 == 1 && currentDialogueIndex < totalDialogue * 2) {
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
                    createCutScenes();
                });
            });
        });
    } //end animateText()

    /**
     * creates the cutscenes prior to entering the boss battle
     */
    private void createCutScenes() {

    } //end createCutScenes()
}
