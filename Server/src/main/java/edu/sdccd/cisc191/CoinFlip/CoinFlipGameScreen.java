package edu.sdccd.cisc191.CoinFlip;

import edu.sdccd.cisc191.Scenes.AlertBox;
import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
        int temp = games.indexOf("CoinFlip");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        root.setBackground(new Background(bgImage));

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
            titleLabel.setText("COIN FLIP");
            heads = false;
            tails = false;
        });

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


        root.getChildren().addAll(titleLabel, coinImage, flipButton, exitButton, headsButton, tailsButton);

        currentStage.setScene(new Scene(root));
        AlertBox.display("COIN FLIP Instructions", "Are you feeling lucky?");
    }
}
