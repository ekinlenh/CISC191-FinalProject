package edu.sdccd.cisc191.BlackJack;

import edu.sdccd.cisc191.AlertBox;
import edu.sdccd.cisc191.SceneController;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class BJlogic extends SceneController {

    private CardsDeck deck = new CardsDeck();
    private Hand dealer, player;
    private Text message = new Text();

    protected static int bet = 0;

    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);

    private HBox dealerCards = new HBox(20);
    private HBox playerCards = new HBox(20);
    private Button exitButton = new Button("EXIT");

    private Button btnPlay = new Button("PLAY");


    public void createContent() {

        btnPlay.setLayoutX(850);
        btnPlay.setLayoutY(300);
        dealer = new Hand(dealerCards.getChildren());
        player = new Hand(playerCards.getChildren());

        AnchorPane root = new AnchorPane();
        root.setPrefSize(1000, 700);

        Region background = new Region();
        background.setPrefSize(1000, 700);
        background.setStyle("-fx-background-color: #6F4E37;");;




        // LEFT
        VBox leftVBox = new VBox(50);
        leftVBox.setAlignment(Pos.TOP_CENTER);

        Text dealerScore = new Text("Dealer: ");
        Text playerScore = new Text("Player: ");

        leftVBox.getChildren().addAll(dealerScore, dealerCards, message, playerCards, playerScore);








        //lets user enter how much to bet
        TextField textField = new TextField();
        textField.setLayoutX(748);
        textField.setLayoutY(636);
        textField.setAlignment(javafx.geometry.Pos.CENTER);

        textField.setPrefSize(107, 44);

        //exit button

        exitButton.setFont(new Font("Times New Roman", 24));

        exitButton.setLayoutX(450);
        exitButton.setLayoutY(636);
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> {
            createMainScreen();
        });

        //betting button
        Button betButton = new Button("BET");
        betButton.setLayoutX(850);
        betButton.setLayoutY(350);
        betButton.setFont(new Font("Times New Roman", 24));

        betButton.setOnAction(e -> {
            try {
                bet = Integer.parseInt(textField.getText());
                if (bet > adventurer.getGold()) {
                    AlertBox.display("Betting Error", "You don't have enough to bet that. Try again.");
                } else if (bet < 5) {
                    AlertBox.display("Betting Error", "The minimum betting amount is 5 gold. Try again.");
                } else {
                    adventurer.subtractGold(bet);
                    goldLabel.setText("GOLD: " + adventurer.getGold());
                    textField.setDisable(true);
                    betButton.setDisable(true);


                }
            } catch (Exception exception) {
                AlertBox.display("Error", "Don't try that again.");
            }
        });



        Button btnHit = new Button("HIT");
        btnHit.setLayoutX(820);
        btnHit.setLayoutY((500));
        Button btnStand = new Button("STAND");
        btnStand.setLayoutX(880);
        btnStand.setLayoutY((500));




        // ADD BOTH STACKS TO ROOT LAYOUT


        root.getChildren().addAll(background, leftVBox, goldLabel, betButton, btnPlay, btnHit, btnStand, textField, exitButton);


        // BIND PROPERTIES

        btnPlay.disableProperty().bind(playable);
        btnHit.disableProperty().bind(playable.not());
        btnStand.disableProperty().bind(playable.not());

        playerScore.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.valueProperty().asString()));
        dealerScore.textProperty().bind(new SimpleStringProperty("Dealer: ").concat(dealer.valueProperty().asString()));

        player.valueProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() >= 21) {
                endGame();
            }
        });

        dealer.valueProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() >= 21) {
                endGame();
            }
        });

        // INIT BUTTONS

        btnPlay.setOnAction(event -> {
            startNewGame();
        });

        btnHit.setOnAction(event -> {
            player.takeCard(deck.drawCard());
        });

        btnStand.setOnAction(event -> {
            while (dealer.valueProperty().get() < 17) {
                dealer.takeCard(deck.drawCard());
            }

            endGame();
        });

        currentStage.setScene(new Scene(root));


    }      private void startNewGame() {
                playable.set(true);
                message.setText("");

                deck.refill();

                dealer.reset();
                player.reset();

                dealer.takeCard(deck.drawCard());
                dealer.takeCard(deck.drawCard());
                player.takeCard(deck.drawCard());
                player.takeCard(deck.drawCard());
            }

            private void endGame() {
                playable.set(false);

                int dealerValue = dealer.valueProperty().get();
                int playerValue = player.valueProperty().get();
                String winner = "Exceptional case: d: " + dealerValue + " p: " + playerValue;

                // the order of checking is important
                if (dealerValue == 21 || playerValue > 21 || dealerValue == playerValue
                        || (dealerValue < 21 && dealerValue > playerValue)) {
                    winner = "DEALER";
                    exitButton.setVisible(true);
                    btnPlay.setVisible(false);

                } else if (playerValue == 21 || dealerValue > 21 || playerValue > dealerValue) {
                    winner = "PLAYER";
                    adventurer.addGold(bet*2);
                    exitButton.setVisible(true);
                    btnPlay.setVisible(false);

                }

                message.setText(winner + " WON");
            }


        }

