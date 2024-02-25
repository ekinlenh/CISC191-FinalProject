package edu.sdccd.cisc191.CoinFlip;

import edu.sdccd.cisc191.AlertBox;
import edu.sdccd.cisc191.SceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class CoinFlipGameScreen extends SceneController {

    //create coin sides
    protected static boolean heads = false, tails = false;
    protected static ImageView coinImage = new ImageView(new Image("coin.png"));
    protected static Label titleLabel = new Label("COIN FLIP");
    protected static int bet = 0;


    /**
     * creates the screen for coin flip game
     */
    public void createCoinFlipScreen() {

        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        root.setStyle("-fx-background-color: #6F4E37;");

        //sets title of game
        titleLabel.setFont(new Font("Times New Roman", 72));
        titleLabel.setLayoutX(193);
        titleLabel.setLayoutY(14);
        titleLabel.setPrefSize(614, 102);
        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);

        //coin image
        coinImage.setFitHeight(376);
        coinImage.setFitWidth(430);
        coinImage.setLayoutX(285);
        coinImage.setLayoutY(150);

        //exit button
        Button exitButton = new Button("EXIT");
        exitButton.setFont(new Font("Times New Roman", 24));
        exitButton.setLayoutX(450);
        exitButton.setLayoutY(636);
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> {
            coinImage.setImage(new Image("coin.png"));
            createMainScreen();
        });

        //lets user enter how much to bet
        TextField textField = new TextField();
        textField.setAlignment(javafx.geometry.Pos.CENTER);
        textField.setLayoutX(748);
        textField.setLayoutY(636);
        textField.setPrefSize(107, 44);

        //flip coin button
        Button flipButton = new Button("FLIP");
        flipButton.setFont(new Font("Times New Roman", 24));
        flipButton.setLayoutX(450);
        flipButton.setLayoutY(550);
        flipButton.setDisable(true);
        flipButton.setOnAction(e -> {
            CoinFlipAnimation animation = new CoinFlipAnimation();
            animation.flipCoin();
            flipButton.setDisable(true);
            exitButton.setVisible(true);
        });

        //choose coin side
        Button headsButton = new Button("Heads");
        Button tailsButton = new Button("Tails");

        //style heads button
        headsButton.setDisable(true);
        headsButton.setFont(new Font("Times New Roman", 22));
        headsButton.setLayoutX(750);
        headsButton.setLayoutY(550);
        headsButton.setPrefSize(90, 35);
        headsButton.setOnMouseClicked(e -> {
            heads = true;
            flipButton.setDisable(false);
            headsButton.setDisable(true);
            tailsButton.setDisable(true);
        });

        //style tails button
        tailsButton.setDisable(true);
        tailsButton.setFont(new Font("Times New Roman", 22));
        tailsButton.setPrefSize(90, 35);
        tailsButton.setLayoutX(850);
        tailsButton.setLayoutY(550);
        tailsButton.setOnMouseClicked(e -> {
            tails = true;
            flipButton.setDisable(false);
            tailsButton.setDisable(true);
            headsButton.setDisable(true);
        });

        //betting button
        Button betButton = new Button("BET");
        betButton.setFont(new Font("Times New Roman", 24));
        betButton.setLayoutX(854);
        betButton.setLayoutY(636);
        betButton.setOnAction(e -> {
            try {
                bet = Integer.parseInt(textField.getText());
                if (bet > adventurer.getGold()) {
                    AlertBox.display("Betting Error", "You don't have enough to bet that. Try again.");
                }
                else if (bet < 5){
                    AlertBox.display("Betting Error", "The minimum betting amount is 5 gold. Try again.");
                }else {
                    adventurer.subtractGold(bet);
                    goldLabel.setText("GOLD: " + adventurer.getGold());
                    textField.setDisable(true);
                    betButton.setDisable(true);
                    tailsButton.setDisable(false);
                    headsButton.setDisable(false);
                }
            } catch (Exception exception) {
                AlertBox.display("Error", "Don't try that again.");
            }
        });

        root.getChildren().addAll(titleLabel, coinImage, flipButton, betButton, goldLabel, textField, exitButton, headsButton, tailsButton);

        currentStage.setScene(new Scene(root));
        AlertBox.display("COINFLIP Instructions", "Are you feeling lucky? \nBet money and pick a side.");
    }
}
