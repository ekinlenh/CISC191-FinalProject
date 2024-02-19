package edu.sdccd.cisc191;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class TicTacToeGameScreen extends SceneController{

    protected static FlowPane board = new FlowPane();
    protected static Label label = new Label("Tic Tac Toe");
    public Scene createTicTacToe() {
        AnchorPane layout = new AnchorPane();
        layout.setPrefSize(1000, 700);
        layout.setStyle("-fx-background-color: #6F4E37;");

        board.setLayoutX(250);
        board.setLayoutY(133);
        board.setPrefSize(507, 433);
        board.setStyle("-fx-pref-height: 510; -fx-pref-width: 510;");

        //run game till someone wins
        TicTacToeButtonController buttonController = new TicTacToeButtonController();
        buttonController.createButtons();

        //set up label
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(270);
        label.setLayoutY(14);
        label.setPrefSize(461, 120);
        label.setStyle("-fx-background-color: #6F4E37; -fx-font-weight: bold;");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setFont(new Font("Times New Roman", 48));

        layout.getChildren().addAll(board, label);

        return new Scene(layout);
    } //end createTicTacToe()
}
