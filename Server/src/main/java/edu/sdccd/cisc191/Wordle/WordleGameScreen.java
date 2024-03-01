package edu.sdccd.cisc191.Wordle;

import edu.sdccd.cisc191.SceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
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
        gridPane.setStyle("-fx-background-color: #DDDDDD;");
        gridPane.setGridLinesVisible(true);

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
                label.setPrefSize(95, 92);
                label.setAlignment(javafx.geometry.Pos.CENTER);
                gridPane.add(label, i, j);
                labels[j][i] = label;
                labels[j][i].setFont(new Font("Times New Roman", 36));
            }
        }

        anchorPane1.getChildren().add(gridPane);
        splitPane.getItems().add(anchorPane1);

        // AnchorPane 2
        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setPrefSize(200, 200);

        Label label2 = new Label();
        label2.setLayoutX(101);
        label2.setLayoutY(27);
        label2.setPrefSize(295, 104);
        label2.setStyle("-fx-font-weight: bold; -fx-font-size: 48px;");
        label2.setText("Not Wordle");
        label2.setTextFill(Color.WHITE);
        label2.setFont(new Font("Times New Roman", 48));

        TextField textField = new TextField();
        textField.setLayoutX(120);
        textField.setLayoutY(370);
        textField.setPrefSize(257, 66);
        textField.setAlignment(javafx.geometry.Pos.CENTER);
        textField.setStyle("-fx-background-color: #DDDDDD; -fx-font-size: 28px;");

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

        //exit button
        exitButton.setFont(new Font("Times New Roman", 20));
        exitButton.setPrefSize(100, 50);
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> {
            createMainScreen();
            count = 0;
        });
        exitButton.setLayoutX(400);
        exitButton.setLayoutY(650);

        anchorPane2.getChildren().addAll(label2, submit, textField, exitButton);

        splitPane.getItems().add(anchorPane2);

        currentStage.setScene(new Scene(splitPane));

        WordSelection.chooseRandomWord();
        System.out.println(word);
    } //end createWordle()

}
