package edu.sdccd.cisc191.aFinalBossBattle;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class RockyPlayer{
    private Pane playerRoot;
    public Node player;
    private boolean canJump = true;
    public static int pVelocityY;
    private static HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();
    static boolean isPressed(KeyCode key) { return keys.getOrDefault(key, false); }

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

            player.setTranslateY(player.getTranslateY() + (movingDown ? 0.2 : - 0.2));
        }
    }
    public void resetPlayerPosition() {
        player.setTranslateX(70);
        player.setTranslateY(640);
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
}
