package edu.sdccd.cisc191.CoinFlip;

import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;

public class CoinFlipGameScreen extends SceneController {

    //create coin sides
    protected static boolean heads = false, tails = false;
    protected static ImageView coinImage = new ImageView(new Image("coin.png"));
    protected static Label titleLabel = new Label("COIN FLIP");
    protected static Label rockyText = new Label("What should we do!!");
    protected static Label businessText = new Label("Foolish monkey!");
    protected static Button exitButton = createButton("EXIT");

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

        Label titleLabel = new Label("COIN FLIP");
        titleLabel.setFont(new Font("Elephant", 48));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setBackground(new Background(new BackgroundFill(Color.web("#4a6741"), CornerRadii.EMPTY, Insets.EMPTY)));
        titleLabel.setPrefSize(462, 85);
        titleLabel.setLayoutX(269);
        titleLabel.setAlignment(Pos.CENTER);
        root.getChildren().add(titleLabel);

        ImageView rockyProfile = new ImageView(new Image("CharacterImages/rockyProfile.png"));
        rockyProfile.setFitWidth(275);
        rockyProfile.setFitHeight(336);
        rockyProfile.setLayoutY(364);
        root.getChildren().add(rockyProfile);

        rockyText.setFont(new Font("Elephant", 18));
        rockyText.setTextFill(Color.WHITE);
        rockyText.setBackground(new Background(new BackgroundFill(Color.web("#4a6741"), CornerRadii.EMPTY, Insets.EMPTY)));
        rockyText.setPrefSize(247, 91);
        rockyText.setLayoutX(14);
        rockyText.setLayoutY(305);
        rockyText.setAlignment(Pos.CENTER);
        root.getChildren().add(rockyText);

        ImageView businessmanImageView = new ImageView(new Image("CharacterImages/businessman.png"));
        businessmanImageView.setFitWidth(247);
        businessmanImageView.setFitHeight(297);
        businessmanImageView.setLayoutX(745);
        businessmanImageView.setLayoutY(403);
        root.getChildren().add(businessmanImageView);

        businessText.setFont(new Font("Elephant", 18));
        businessText.setTextFill(Color.WHITE);
        businessText.setBackground(new Background(new BackgroundFill(Color.web("#4a6741"), CornerRadii.EMPTY, Insets.EMPTY)));
        businessText.setPrefSize(247, 91);
        businessText.setLayoutX(745);
        businessText.setLayoutY(264);
        businessText.setAlignment(Pos.CENTER);
        root.getChildren().add(businessText);

        exitButton.setLayoutX(429);
        exitButton.setLayoutY(630);
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> {
            coinImage.setImage(new Image("coin.png"));
            createMainScreen();
            titleLabel.setText("COIN FLIP");
            heads = false;
            tails = false;
        });
        root.getChildren().add(exitButton);

        Button flipButton = createButton("FLIP");
        flipButton.setDisable(true);
        flipButton.setLayoutX(429);
        flipButton.setLayoutY(560);
        flipButton.setOnAction(e -> {
            CoinFlipAnimation.flipCoin();
            flipButton.setDisable(true);
        });
        root.getChildren().add(flipButton);

        Button headsButton = createButton("HEADS");
        Button tailsButton = createButton("TAILS");

        headsButton.setLayoutX(289);
        headsButton.setLayoutY(476);
        headsButton.setOnMouseClicked(e -> {
            heads = true;
            flipButton.setDisable(false);
            headsButton.setDisable(true);
            tailsButton.setDisable(true);
            rockyText.setText("Alright! Let's go \nwith heads!");
            businessText.setText("Hah! Then I'll \ngo with tails!");
        });
        root.getChildren().add(headsButton);

        tailsButton.setLayoutX(559);
        tailsButton.setLayoutY(476);
        tailsButton.setOnMouseClicked(e -> {
            tails = true;
            flipButton.setDisable(false);
            tailsButton.setDisable(true);
            headsButton.setDisable(true);
            rockyText.setText("Alright! Let's go \nwith tails!");
            businessText.setText("Hah! Then I'll \ngo with heads!");
        });
        root.getChildren().add(tailsButton);

        Polygon leftArrow = new Polygon(-31, 31, -61, -10, 4.5, -10);
        leftArrow.setLayoutX(161);
        leftArrow.setLayoutY(406);
        leftArrow.setFill(Color.web("#4a6741"));
        leftArrow.setStroke(Color.web("#4a6741"));
        leftArrow.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        leftArrow.setStyle("-fx-background-radius: 20%");
        root.getChildren().add(leftArrow);

        coinImage.setFitWidth(390);
        coinImage.setFitHeight(354);
        coinImage.setLayoutX(305);
        coinImage.setLayoutY(98);
        root.getChildren().add(coinImage);

        Polygon rightArrow = new Polygon(-31, 31, -61, -10, 4.5, -10);
        rightArrow.setLayoutX(892);
        rightArrow.setLayoutY(365);
        rightArrow.setFill(Color.web("#4a6741"));
        rightArrow.setStroke(Color.web("#4a6741"));
        rightArrow.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rightArrow.setStyle("-fx-background-radius: 20%");
        root.getChildren().add(rightArrow);

        currentStage.setScene(new Scene(root));
    } //end createCoinFlipScreen()

    /**
     * styles the buttons
     *
     * @param text takes in what button text wants to be
     * @return the styled button
     */
    private static Button createButton(String text) {
        Button button = new Button(text);
        button.setFont(new Font("Elephant", 24));
        button.setTextFill(Color.WHITE);
        button.setPrefSize(136, 69);
        button.setStyle("-fx-background-radius: 20%; -fx-background-color: #4a6741");
        return button;
    }
}
