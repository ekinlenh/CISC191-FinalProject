package edu.sdccd.cisc191.TicTacToe;

import edu.sdccd.cisc191.Scenes.AlertBox;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
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
    protected static boolean gameOver = false;


    /**
     * creates the scene to play TicTacToe
     */
    public void createTicTacToe() {
        FlowPane board = new FlowPane();
        AnchorPane layout = new AnchorPane();
        layout.setPrefSize(1000, 700);
        int temp = games.indexOf("TicTacToe");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        layout.setBackground(new Background(bgImage));

        board.setLayoutX(490);
        board.setLayoutY(119);
        board.setStyle("-fx-pref-height: 510; -fx-pref-width: 510;");

        //run game till someone wins
        TicTacToeButtonController buttonController = new TicTacToeButtonController();
        buttonController.createButtons();
        board.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7, button8, button9);

        //set up label
        label.setAlignment(Pos.CENTER);
        label.setLayoutX(490);
        label.setLayoutY(0);
        label.setPrefSize(510, 120);
        label.setStyle("-fx-background-color: #355E3B; -fx-font-weight: bold; -fx-text-fill: white");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setFont(new Font("Elephant", 48));

        //set up exit button
        exitGame.setAlignment(Pos.CENTER);
        exitGame.setVisible(false);
        exitGame.setLayoutX(660);
        exitGame.setLayoutY(650);
        exitGame.setPrefSize(200, 40);
        exitGame.setStyle("-fx-background-color: #355E3B; -fx-font-weight: bold; -fx-text-fill: white;");
        exitGame.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        exitGame.setFont(new Font("Elephant", 24));
        exitGame.setOnMouseClicked(e -> {
            resetGame();
            createMainScreen();
        });

        layout.getChildren().addAll(board, label, exitGame);
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
        gameOver = false;
    } //end resetGame()
}