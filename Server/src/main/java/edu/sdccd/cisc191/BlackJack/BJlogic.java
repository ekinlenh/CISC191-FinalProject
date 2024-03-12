package edu.sdccd.cisc191.BlackJack;

import edu.sdccd.cisc191.Scenes.AlertBox;
import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


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
        int temp = games.indexOf("BlackJack");
        BackgroundImage bgImage = new BackgroundImage(backgrounds[temp], BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false));
        background.setBackground(new Background(bgImage));




        // LEFT
        VBox leftVBox = new VBox(50);
        leftVBox.setAlignment(Pos.TOP_CENTER);

        Text dealerScore = new Text("Dealer: ");
        Text playerScore = new Text("Player: ");

        leftVBox.getChildren().addAll(dealerScore, dealerCards, message, playerCards, playerScore);

        //exit button

        exitButton.setFont(new Font("Times New Roman", 24));

        exitButton.setLayoutX(450);
        exitButton.setLayoutY(636);
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> {
            createMainScreen();
        });

        Button btnHit = new Button("HIT");
        btnHit.setLayoutX(820);
        btnHit.setLayoutY((500));
        Button btnStand = new Button("STAND");
        btnStand.setLayoutX(880);
        btnStand.setLayoutY((500));


        // ADD BOTH STACKS TO ROOT LAYOUT


        root.getChildren().addAll(background, leftVBox, btnPlay, btnHit, btnStand, exitButton);


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
                    updateLosses();

                } else {
                    winner = "PLAYER";
                    gamesWon++;
                    exitButton.setVisible(true);
                    btnPlay.setVisible(false);
                    ProgressScenes.changeScene();
                }

                message.setText(winner + " WON");
            }


        }

