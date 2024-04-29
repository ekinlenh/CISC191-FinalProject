package edu.sdccd.cisc191.aFinalBossBattle;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import java.util.HashMap;
import static edu.sdccd.cisc191.Scenes.SceneController.createGameOver;

public class RockyPlayer{
    //for domain battle
    private Pane playerRoot;
    public Node player;
    private boolean canJump = true;
    public static int pVelocityY;
    private static HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();
    static boolean isPressed(KeyCode key) { return keys.getOrDefault(key, false); }

    //for fight battle
    private static int health = 100;
    private static int mana = 30;
    private Label rockyHealth = new Label();
    private static ProgressBar rockyHealthBar = new ProgressBar(100);
    private Label rockyMana = new Label();
    private static ProgressBar rockyManaBar = new ProgressBar(mana);

    public RockyPlayer() {
        rockyHealthBar.setLayoutX(64);
        rockyHealthBar.setLayoutY(591);
        rockyHealthBar.setPrefWidth(134);
        rockyHealthBar.setPrefHeight(23);
        rockyHealthBar.setStyle("-fx-border-radius: 20%; -fx-control-inner-background: white; -fx-accent: #800020; -fx-border-color: #800020;");

        rockyHealth.setFont(Font.font("Elephant", 16));
        rockyHealth.setTextFill(Color.valueOf("#000000"));
        rockyHealth.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        rockyHealth.setPrefSize(88, 23);
        rockyHealth.setLayoutX(105);
        rockyHealth.setLayoutY(591);

        rockyMana.setFont(Font.font("Elephant", 16));
        rockyMana.setTextFill(Color.BLACK);
        rockyMana.setAlignment(Pos.CENTER_RIGHT);
        rockyMana.setPrefSize(88, 23);
        rockyMana.setLayoutX(102);
        rockyMana.setLayoutY(634);

        rockyManaBar.setLayoutX(64);
        rockyManaBar.setLayoutY(634);
        rockyManaBar.setPrefSize(134, 23);
    }

    // DOMAIN BATTLE METHODS

    public RockyPlayer(Pane playerRoot) {
        this.playerRoot = playerRoot;
        player = drawPlayer(70, 620, new Image("CharacterImages/rockySprite.png"));
        player.toFront();
    }
    public Pane getPlayerRoot() {
        return playerRoot;
    }
    public void jumpPlayer() {
        if (canJump) {
            pVelocityY -= 40;
            canJump = false;
        }
    }

    public void movePlayerX(int moveX) {
        boolean movingRight = moveX > 0;

        for (int i=0; i<Math.abs(moveX); i++) { //Move player 1 pixel at a time
            for (Node platform: BossLevel.platforms) {    //Check for Collisions
                if (player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingRight) {
                        player.setTranslateX(player.getTranslateX() - 1);
                        return; //if collision detected return
                    } else {
                        player.setTranslateX(player.getTranslateX() + 2);
                        return; //if collision detected return
                    }
                }
            }

            player.setTranslateX(player.getTranslateX() + (movingRight ? 0.4 : -0.4));
        }
    }

    public void movePlayerY(int pVelocityY) {
        boolean movingDown = pVelocityY > 0; //if velocity is positive, player is moving down, otherwise player is moving up
        for (int i=0; i<Math.abs(pVelocityY); i++) {
            for (Node platform: BossLevel.platforms) {

                if (player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingDown) {
                        player.setTranslateY(player.getTranslateY() - 0.5);
                        canJump = true;
                        return;
                    } else {
                        player.setTranslateY(player.getTranslateY() + 1.5);
                        return;
                    }
                }
            }

            for (Node ladder: BossLevel.topLadders) {
                if (player.getBoundsInParent().intersects(ladder.getBoundsInParent())) {
                    if (isPressed(KeyCode.UP) || isPressed(KeyCode.SPACE) || isPressed(KeyCode.W)) {
                        player.setTranslateY(player.getTranslateY() - 2);
                        canJump = true;
                        return;
                    } else if (isPressed(KeyCode.DOWN) || isPressed(KeyCode.S)){
                        player.setTranslateY(player.getTranslateY() + 1);
                        return;
                    }
                }
            }

            player.setTranslateY(player.getTranslateY() + (movingDown ? 0.2 : - 0.2));
        }
    }
    public void resetPlayerPosition() {
        player.setTranslateX(70);
        player.setTranslateY(600);
    }

    public Node drawPlayer (int x, int y, Image image) {
        Rectangle entity = new Rectangle(50, 60);
        entity.setTranslateX(x);
        entity.setTranslateY(y);
        entity.setFill(new ImagePattern(image));

        playerRoot.getChildren().add(entity);
        return entity;
    }

    public Node getPlayer() {
        return player;
    }

    public static void changePVelocityY(int value) {
        pVelocityY += value;
    }

    // FIGHTING BATTLE METHODS

    public void setHealth(int health) {
        this.health = health;
    } //end setHealth

    public int getHealth() {
        return health;
    } //end getHealth()

    public void setMana(int mana) {
        this.mana = mana;
    } //end setMana()

    public int getMana() {
        return mana;
    } //end getMana()

    public Label getRockyHealthLabel() {
        return rockyHealth;
    } //end getRockyHealthLabel()

    public Label getRockyManaLabel() {
        return rockyMana;
    } //end getRockyManaLabel()

    public ProgressBar getRockyHealthBar() {
        return rockyHealthBar;
    } //end getRockyHealthBar()

    public ProgressBar getRockyManaBar() {
        return rockyManaBar;
    } //end getRockyManaBar()

    public void updateBarsAndLabels() {
        rockyHealth.setText(getHealth() + "/100");
        rockyMana.setText(getMana() + "/30");

        rockyHealthBar.setProgress((double) getHealth() /100);
        rockyManaBar.setProgress(getMana());

        if (getHealth() <= 0) {
            createGameOver();
        }
    } //end updateBars()
}
