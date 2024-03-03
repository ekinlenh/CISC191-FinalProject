package edu.sdccd.cisc191.Wordle;

import edu.sdccd.cisc191.SceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WordleGameScreen extends SceneController {
    protected static String word;
    protected static String guessWord;
    protected static Label[][] labels = new Label[6][5];
    protected static int count = 0;
    protected static int guessesRemaining = 6;

    protected static Button submit = new Button();
    protected static Button exitButton = new Button("EXIT");


    public void createWordle() {
        // SplitPane
        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPositions(0.5);
        splitPane.setPrefSize(600, 400);
        splitPane.setStyle("-fx-pref-height: 700; -fx-pref-width: 1000; -fx-background-color: #6F4E37;");

        // AnchorPane 1
        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setPrefSize(469, 533);

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
        textField.setStyle("-fx-background-color: #DDDDDD; -fx-font-size: 28px;");
        textField.setEffect(dropShadow);

        submit.setDisable(false);
        submit.setLayoutX(120);
        submit.setLayoutY(436);
        submit.setMnemonicParsing(false);
        submit.setPrefSize(257, 37);
        submit.setStyle("-fx-background-color: #6F4E37;");
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
            count = 0;
            guessesRemaining = 6;
        });
        exitButton.setLayoutX(400);
        exitButton.setLayoutY(650);

        anchorPane2.getChildren().addAll(TitleAnimation.createTitle(), submit, textField, exitButton);
        splitPane.getItems().add(anchorPane2);

        currentStage.setScene(new Scene(splitPane));

        TitleAnimation.animateTitle();
        WordSelection.chooseRandomWord();
        System.out.println(word);
    } //end createWordle()

    /**
     *
     */
    private void styleLabels(Label label) {
        label.setPrefSize(95, 92);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setStyle("-fx-background-color: #FFFFFF");

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.5));

        label.setEffect(dropShadow);
    } //end styleLabels()
}
