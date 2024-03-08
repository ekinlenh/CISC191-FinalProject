package edu.sdccd.cisc191;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
public class NamingScreen extends SceneController{

    private static final Label rockyText = new Label();
    private static final Label rockyName = new Label();
    private static final Button responseButton = new Button();
    private static final TextField textField = new TextField();
    private int count = 0;

    /**
     * create the ask player name screen of the game
     */
    public void createScene() {
        Pane root = new Pane();

        ImageView background = new ImageView(new Image("start.png"));
        background.setFitWidth(1000);
        background.setFitHeight(700);
        root.getChildren().add(background);

        ImageView rockImage = new ImageView(new Image("CharacterImages/rockypoint.png"));
        rockImage.setFitWidth(386);
        rockImage.setFitHeight(491);
        rockImage.setLayoutX(316);
        root.getChildren().add(rockImage);

        rockyText.setText("Hey you!");
        rockyText.setLayoutX(272);
        rockyText.setLayoutY(468);
        rockyText.setPrefSize(457, 92);
        rockyText.setStyle("-fx-background-color: #4a6741; -fx-background-radius: 20%;");
        rockyText.setTextFill(javafx.scene.paint.Color.WHITE);
        rockyText.setFont(new Font("Elephant", 18));
        rockyText.setAlignment(javafx.geometry.Pos.CENTER);
        root.getChildren().add(rockyText);

        rockyName.setText("???");
        rockyName.setLayoutX(370);
        rockyName.setLayoutY(14);
        rockyName.setPrefSize(261, 105);
        rockyName.setStyle("-fx-opacity: 0.5; -fx-background-color: #000000; -fx-background-radius: 15%;");
        rockyName.setTextFill(javafx.scene.paint.Color.WHITE);
        rockyName.setFont(new Font(72));
        rockyName.setAlignment(javafx.geometry.Pos.CENTER);
        root.getChildren().add(rockyName);

        responseButton.setText("Who...? Me?");
        responseButton.setLayoutX(391);
        responseButton.setLayoutY(568);
        responseButton.setPrefSize(219, 64);
        responseButton.setStyle("-fx-background-color: #6F4E37; -fx-background-radius: 15%;");
        responseButton.setTextFill(javafx.scene.paint.Color.WHITE);
        root.getChildren().add(responseButton);

        textField.setLayoutX(421);
        textField.setLayoutY(574);
        textField.setPrefSize(159, 53);
        textField.setPromptText("...");
        textField.setStyle("-fx-background-color: #6F4E37;");
        textField.setVisible(false);
        textField.setFont(new Font("Elephant", 18));
        textField.setCursor(javafx.scene.Cursor.S_RESIZE);
        root.getChildren().add(textField);

        currentStage.setScene(new Scene(root));

        responseButton.setOnAction(e -> {
            createDialogue();
        });
    } //end createNamingScreen()

    /**
     * creates dialogue sequence
     */
    public void createDialogue() {
            count++;
            switch (count) {
                case 0:
                    responseButton.setOnMouseClicked(e -> {
                        rockyText.setText("Yes you! Who else is there? What's your name?");
                        responseButton.setText("Who even are you?");
                    });
                    break;
                case 1:
                    responseButton.setOnMouseClicked(e -> {
                        rockyText.setText("Who am I? I'm Rocky! But that's not \nwhat matters right now. ");
                        rockyName.setText("Rocky");
                        responseButton.setText("Okay...");
                    });
                    break;
                case 2:
                    responseButton.setOnMouseClicked(e -> {
                        rockyText.setText("I need help saving my lover! \nMy dad kicked me out of the village \nand has kidnapped her! \nWill you help me save her?");
                        responseButton.setText("Yes");
                        responseButton.setOnMouseClicked(event -> {
                            createMainScreen();
                        });
                    });
                    break;
                default:
                    break;
            }
    } //end createDialogue()

}
