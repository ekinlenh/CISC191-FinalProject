package edu.sdccd.cisc191.aFinalBossBattle;

import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

import static edu.sdccd.cisc191.aFinalBossBattle.RockyPlayer.*;

public class BossBattle extends SceneController {

    protected static Pane root;
    private static Pane rockyPlayerRoot = new Pane();
    protected static RockyPlayer rocky = new RockyPlayer(rockyPlayerRoot);
    protected AnimationTimer animationTimer;

    private static HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();
    private static boolean isPressed(KeyCode key) { return keys.getOrDefault(key, false); }

    /**
     * creates the boss battle against EL MONO
     */
    public void createBossBattle() {
        root = new Pane();
        root.setPrefSize(1000, 700);
        root.setBackground(new Background(new BackgroundImage(new Image("Scenes/primaljungle.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1000, 700, false, false, false, false))));

        BossLevel bossLevel = new BossLevel();
        bossLevel.createBossLevel();

        GridPane lives = showLives();
        lives.setLayoutY(20);
        lives.setLayoutX(830);

        root.getChildren().addAll(rockyPlayerRoot, lives);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> keys.put(event.getCode(), false));

        currentStage.setScene(scene);

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gameLoop();
            }
        };
        animationTimer.start();
    } //end createBossBattle()

    private void gameLoop() {
        boolean onLadder = false;

        //checks for if player is on the ladder
        for (Node node: BossLevel.ladders) {
            if (rocky.player.getBoundsInParent().intersects(node.getBoundsInParent())) {
                onLadder = true;
                break;
            }
        }

        //checks for if player collides with a barrel
        for (Node node: BossLevel.barrels) {
            if (rocky.player.getBoundsInParent().intersects(node.getBoundsInParent())) {
                updateLosses();
                rocky.resetPlayerPosition();
                if (losses == 3) {
                    createGameOver();
                }
            }
        }

        //updates barrels position
//        for (Barrel barrel: BossLevel.barrels) {
//            Platform.runLater(barrel::update);
//        }

        if (isPressed(KeyCode.SPACE) || isPressed(KeyCode.UP) || isPressed(KeyCode.W)) {
            if (onLadder) { //if player is on ladder and presses up key, they can climb
                rocky.movePlayerY(-3);
            } else { //else they jump normally
                rocky.jumpPlayer();
            }
        }

        //if player is on ladder and is moving down, go down
        if (onLadder && isPressed(KeyCode.DOWN) || isPressed(KeyCode.S)) {
            rocky.movePlayerY(3);
        }

        //checks if player is moving left
        if (isPressed(KeyCode.A) || isPressed(KeyCode.LEFT)) {
            rocky.movePlayerX(-5);
        }

        //checks if player is moving right
        if (isPressed(KeyCode.D) || isPressed(KeyCode.RIGHT)) {
            rocky.movePlayerX(5);
        }

        //if player isn't on ladder, behave normally
        if (!onLadder) {
            if (RockyPlayer.pVelocityY < 10) {
                RockyPlayer.changePVelocityY(1);
            }
            rocky.movePlayerY(RockyPlayer.pVelocityY);
        } else { //else cant jump
            RockyPlayer.pVelocityY = 0;
        }

        //if player falls out of map (game over)
        if (rocky.player.getTranslateY() > 700) {
            updateLosses();
            rocky.resetPlayerPosition();
            if (losses == 3) {
                createGameOver();
            }
        }

        if (rocky.player.getBoundsInParent().intersects(BossLevel.elMono.getBoundsInParent())) {
            for (Barrel barrel: BossLevel.barrels) {
                barrel.stop();
            }
            animationTimer.stop();
            FightingStage fightingStage = new FightingStage();
            fightingStage.createFight();
        }
    }
} //end BossBattle class
