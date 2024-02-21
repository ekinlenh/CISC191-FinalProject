package edu.sdccd.cisc191.CoinFlip;

import edu.sdccd.cisc191.SceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.util.concurrent.atomic.AtomicInteger;

public class CoinFlipGameScreen extends SceneController {

    //create coin sides
    protected static String heads = "heads.png";
    protected static String tails = "tails.png";
    protected static ImageView coinImage = new ImageView();
    protected static int bet = 0;

    public void createCoinFlipScreen() {
        Image headsCoin = new Image("coin.png");

        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        root.setStyle("-fx-background-color: #6F4E37;");

        Label titleLabel = new Label("COIN FLIP");
        titleLabel.setFont(new Font("Times New Roman", 72));
        titleLabel.setLayoutX(193);
        titleLabel.setLayoutY(14);
        titleLabel.setPrefSize(614, 102);
        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);

        ImageView coinImage= new ImageView(headsCoin);
        coinImage.setFitHeight(376);
        coinImage.setFitWidth(430);
        coinImage.setLayoutX(285);
        coinImage.setLayoutY(150);

        Button exitButton = new Button("EXIT");
        exitButton.setFont(new Font("Times New Roman", 24));
        exitButton.setLayoutX(450);
        exitButton.setLayoutY(636);
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> createMainScreen());

        TextField textField = new TextField();
        textField.setAlignment(javafx.geometry.Pos.CENTER);
        textField.setLayoutX(748);
        textField.setLayoutY(636);
        textField.setPrefSize(107, 44);

        Button betButton = new Button("BET");
        betButton.setFont(new Font("Times New Roman", 24));
        betButton.setLayoutX(854);
        betButton.setLayoutY(636);
        betButton.setOnAction(e -> {
            bet = Integer.parseInt(textField.getText());
            if (bet > adventurer.getGold()) {
                //temp code
                System.out.println("youre poor you cant do that try again");
            } else {
                adventurer.subtractGold(bet);
                goldLabel.setText("GOLD: " + adventurer.getGold());
                textField.setDisable(true);
                betButton.setDisable(true);
            }
            //need code so that you can only enter numbers
        });

        Button flipButton = new Button("FLIP");
        flipButton.setFont(new Font("Times New Roman", 24));
        flipButton.setLayoutX(450);
        flipButton.setLayoutY(550);
        flipButton.setOnAction(e -> {
            CoinFlipAnimation animation = new CoinFlipAnimation();
            animation.flipCoin();
            flipButton.setDisable(true);
            betButton.setDisable(true);
            exitButton.setVisible(true);
        });

        Button headsButton = new Button("Heads");
        headsButton.setFont(new Font("Times New Roman", 22));
        headsButton.setLayoutX(750);
        headsButton.setLayoutY(550);
        headsButton.setPrefSize(90, 35);
        Button tailsButton = new Button("Tails");
        tailsButton.setFont(new Font("Times New Roman", 22));
        tailsButton.setPrefSize(90, 35);
        tailsButton.setLayoutX(850);
        tailsButton.setLayoutY(550);

        root.getChildren().addAll(titleLabel, coinImage, flipButton, betButton, goldLabel, textField, exitButton, headsButton, tailsButton);

        currentStage.setScene(new Scene(root));
    }
}
