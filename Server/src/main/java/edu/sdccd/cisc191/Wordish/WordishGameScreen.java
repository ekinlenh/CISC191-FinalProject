package edu.sdccd.cisc191.Wordish;

import edu.sdccd.cisc191.SceneController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;

public class WordishGameScreen extends SceneController {
    protected static String word;
    protected static String guessWord;
    protected static Label[][] labels = new Label[6][5];
    protected static int counter = 0;
    protected static int guessesRemaining = 6;

    protected static Button submit = new Button();
    protected static Button exitButton = new Button("EXIT");

    /**
     * creates start screen of Wordish where you can see instructions and preview
     */
    public void createWordish() {
        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        root.setStyle("-fx-background-color: #6F4E37;");

        Rectangle backgroundRect = new Rectangle(1000, 381);
        backgroundRect.setLayoutY(128);
        backgroundRect.setFill(Color.web("#4a3325"));
        backgroundRect.setStroke(Color.web("#4a3325"));
        backgroundRect.setStrokeType(StrokeType.INSIDE);

        Rectangle gameRect = new Rectangle(558, 423);
        gameRect.setArcWidth(30);
        gameRect.setArcHeight(30);
        gameRect.setLayoutX(44);
        gameRect.setLayoutY(107);
        gameRect.setFill(Color.WHITE);
        gameRect.setStroke(Color.WHITE);
        gameRect.setStrokeType(StrokeType.INSIDE);

        Button startButton = new Button("Start!");
        startButton.setLayoutX(660);
        startButton.setLayoutY(526);
        startButton.setPrefSize(302, 64);
        startButton.setStyle("-fx-background-radius: 35%; -fx-background-color: yellow;");
        startButton.setTextFill(Color.web("#7c7575"));
        startButton.setFont(Font.font("Times New Roman", 36));
        startButton.setOnMouseClicked(e -> createWordishGameScreen());

        ImagePattern previewImage = new ImagePattern(new Image("wordish.png"));
        gameRect.setFill(previewImage);

        Label titleLabel = new Label("Wordish");
        titleLabel.setLayoutX(44);
        titleLabel.setLayoutY(20);
        titleLabel.setPrefSize(324, 64);
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setFont(Font.font("Times New Roman", 64));

        Label instructionsLabel = new Label("Guess the five letter word in 6 guesses or less." +
                "\nIf a letter is in the right place, it will be green." + "\nIf a letter is in the word" +
                " but in the wrong place, \nit will be yellow. Otherwise, it will remain gray.");
        instructionsLabel.setLayoutX(152);
        instructionsLabel.setLayoutY(551);
        instructionsLabel.setPrefSize(465, 135);
        instructionsLabel.setStyle("-fx-background-radius: 25%; -fx-background-color: #FFFFFF;");
        instructionsLabel.setTextFill(Color.web("#7c7575"));
        instructionsLabel.setFont(Font.font("Times New Roman", 20));
        instructionsLabel.setAlignment(Pos.CENTER);

        ImageView georgeImageView = new ImageView(new Image("CharacterImages/george.png"));
        georgeImageView.setFitWidth(176);
        georgeImageView.setFitHeight(182);
        georgeImageView.setLayoutX(0);
        georgeImageView.setLayoutY(518);

        root.getChildren().addAll(backgroundRect, gameRect, startButton, titleLabel, instructionsLabel, georgeImageView);

        currentStage.setScene(new Scene(root));

    } //end createStartScreen()

    /**
     * creates the main game screen
     */
    public void createWordishGameScreen() {
        // SplitPane
        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPositions(0.5);
        splitPane.setPrefSize(600, 400);
        splitPane.setStyle("-fx-pref-height: 700; -fx-pref-width: 1000;");
        int temp = games.indexOf("Wordish");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        splitPane.setBackground(new Background(bgImage));

        // AnchorPane 1
        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setPrefSize(469, 700);
        anchorPane1.setStyle("-fx-background-color:#355E3B");

        // GridPane
        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(24);
        gridPane.setLayoutY(94);
        gridPane.setPrefSize(448, 511);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.5));

        // Column Constraints
        for (int i = 0; i < 5; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
            column.setMinWidth(10.0);
            column.setPrefWidth(100.0);
            gridPane.getColumnConstraints().add(column);
        }

        // Row Constraints
        for (int i = 0; i < 6; i++) {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            row.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }

        // Labels
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                Label label = new Label();
                gridPane.add(label, i, j);
                labels[j][i] = label;
                labels[j][i].setFont(new Font("Times New Roman", 36));
                styleLabels(label);
            }
        }
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        anchorPane1.getChildren().add(gridPane);
        splitPane.getItems().add(anchorPane1);

        // AnchorPane 2
        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setPrefSize(200, 200);

        TextField textField = new TextField();
        textField.setLayoutX(120);
        textField.setLayoutY(370);
        textField.setPrefSize(257, 66);
        textField.setAlignment(javafx.geometry.Pos.CENTER);
        textField.setStyle("-fx-background-color: #6F4E37; -fx-font-size: 28px; -fx-text-fill: white");
        textField.setEffect(dropShadow);

        submit.setDisable(false);
        submit.setLayoutX(120);
        submit.setLayoutY(436);
        submit.setMnemonicParsing(false);
        submit.setPrefSize(257, 37);
        submit.setStyle("-fx-background-color: #355E3B; -fx-text-fill: white");
        submit.setText("Submit");
        submit.setOnMouseClicked(e -> {
            guessWord = textField.getText().toUpperCase();
            WordGuessChecker.checkGuess();
        });
        submit.setEffect(dropShadow);

        //exit button
        exitButton.setFont(new Font("Times New Roman", 20));
        exitButton.setPrefSize(100, 50);
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> {
            createMainScreen();
            counter = 0;
            guessesRemaining = 6;
        });
        exitButton.setLayoutX(400);
        exitButton.setLayoutY(650);

        anchorPane2.getChildren().addAll(TitleAnimation.createTitle(), submit, textField, exitButton);
        splitPane.getItems().add(anchorPane2);

        currentStage.setScene(new Scene(splitPane));

        TitleAnimation.animateTitle();
        WordSelection.chooseRandomWord();
        System.out.println("Word: " + word);
    } //end createWordle()

    /**
     * style labels
     */
    private void styleLabels(Label label) {
        label.setPrefSize(95, 92);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setStyle("-fx-background-color: #6F4E37");

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.5));

        label.setEffect(dropShadow);
    } //end styleLabels()
}
