package edu.sdccd.cisc191.TicTacToe;

import edu.sdccd.cisc191.SceneController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class TicTacToeGameScreen extends SceneController {
    protected static Button button1 = new Button();
    protected static Button button2 = new Button();
    protected static Button button3 = new Button();
    protected static Button button4 = new Button();
    protected static Button button5 = new Button();
    protected static Button button6 = new Button();
    protected static Button button7 = new Button();
    protected static Button button8 = new Button();
    protected static Button button9 = new Button();
    protected static Button[][] buttons = {{button1, button2, button3}, {button4, button5, button6}, {button7, button8, button9}};
    protected static Label label = new Label("Tic Tac Toe");
    protected static Button exitGame = new Button("Exit Game");

    /**
     * creates the scene to play TicTacToe
     */
    public void createTicTacToe() {
        FlowPane board = new FlowPane();
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
        board.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7, button8, button9);

        //set up label
        label.setAlignment(Pos.CENTER);
        label.setLayoutX(270);
        label.setLayoutY(14);
        label.setPrefSize(461, 120);
        label.setStyle("-fx-background-color: #6F4E37; -fx-font-weight: bold;");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setFont(new Font("Times New Roman", 48));

        //set up exit button
        exitGame.setAlignment(Pos.CENTER);
        exitGame.setVisible(false);
        exitGame.setLayoutX(405);
        exitGame.setLayoutY(650);
        exitGame.setPrefSize(200, 40);
        exitGame.setStyle("-fx-background-color: #6F4E37; -fx-font-weight: bold;");
        exitGame.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        exitGame.setFont(new Font("Times New Roman", 24));
        exitGame.setOnMouseClicked(e -> {
            resetGame();
            createMainScreen();
        });

        layout.getChildren().addAll(board, label, exitGame, goldLabel);
        currentStage.setScene(new Scene(layout));
    } //end createTicTacToe()

    /**
     * reset game board
     */
    private void resetGame() {
        for (Button[] button: buttons) {
            for (Button b: button) {
                b.setDisable(false);
                b.setText("");
            }
        }
        label.setText("Tic Tac Toe");
    } //end resetGame()
}