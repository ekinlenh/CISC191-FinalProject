package edu.sdccd.cisc191.aFinalBossBattle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

import static edu.sdccd.cisc191.aFinalBossBattle.FightingStage.createBossAttack;

public class CombatButton extends Button {

    /**
     * creates combat buttons for final boss battle
     * @param text takes in button text
     * @param fontSize takes in font size
     */
    public CombatButton(String text, int fontSize) {
        setText(text);
        setPrefSize(288, 79);
        setStyle("-fx-font-size: " + fontSize + "pt;");
        getStylesheets().add("stylesheet.css");
        getStyleClass().add("combat-button");
    } //end constructor

    public int createSkillButtonUse(String skillName, RockyPlayer rockyPlayer, ImageView elMono, int bossHealth, PauseTransition pause, GridPane gridPane) {
            switch (skillName) {
                case "Banana Barrage":
                    Pane pane = (Pane) elMono.getScene().getRoot();
                    ArrayList<ImageView> bananaImages = new ArrayList<>();

                    gridPane.setDisable(true);
                    int totalDamage = 0;
                    Random random = new Random();
                    for (int i = 0; i < 5; i++) {
                        totalDamage += random.nextInt(5) + 10;
                        ImageView banana = new ImageView(new Image("bananaBarrage.png"));
                        banana.rotateProperty().set(random.nextInt(360));
                        banana.setFitHeight(100);
                        banana.setFitWidth(100);
                        banana.setLayoutX(350 + random.nextInt(200));
                        banana.setLayoutY(150 + random.nextInt(300));
                        pane.getChildren().add(banana);
                        bananaImages.add(banana);
                    }

                    pause.play();
                    pause.setOnFinished(event -> {
                        for (ImageView banana : bananaImages) {
                            pane.getChildren().remove(banana);
                        }
                        gridPane.setDisable(false);
                        createBossAttack();
                        rockyPlayer.setMana(rockyPlayer.getMana() - 10);
                        rockyPlayer.updateBarsAndLabels();
                    });
                    return totalDamage;

                case "Spiky Shield":
                    gridPane.setDisable(true);
                    ImageView spikyShield = new ImageView(new Image("spikyShield.png"));
                    spikyShield.setFitWidth(500);
                    spikyShield.setFitHeight(500);
                    spikyShield.setLayoutX(250);
                    spikyShield.setLayoutY(50);
                    Pane pane1 = (Pane) elMono.getScene().getRoot();
                    pane1.getChildren().add(spikyShield);

                    int damageDeflected = createBossAttack();
                    rockyPlayer.setHealth(rockyPlayer.getHealth() + damageDeflected);

                    pause.play();
                    pause.setOnFinished(event -> {
                        pane1.getChildren().remove(spikyShield);
                        gridPane.setDisable(false);
                        rockyPlayer.setMana(rockyPlayer.getMana() - 5);
                        rockyPlayer.updateBarsAndLabels();
                    });

                    return damageDeflected;

                case "Banana Balm":
                    ImageView bananaBalm = new ImageView(new Image("bananaBalm.png"));
                    bananaBalm.setScaleX(0.5);
                    bananaBalm.setScaleY(0.5);

                    Pane root = (Pane) elMono.getScene().getRoot();
                    bananaBalm.setLayoutX(265);
                    bananaBalm.setLayoutY(70);
                    root.getChildren().add(bananaBalm);

                    Timeline timeline = new Timeline(
                            new KeyFrame(Duration.ZERO, new KeyValue(bananaBalm.rotateProperty(), -45)),
                            new KeyFrame(Duration.seconds(0.5), new KeyValue(bananaBalm.rotateProperty(), 45)),
                            new KeyFrame(Duration.seconds(1), new KeyValue(bananaBalm.rotateProperty(), 0))
                    );

                    timeline.setCycleCount(3);
                    timeline.play();
                    gridPane.setDisable(true);
                    timeline.setOnFinished(e -> {
                        gridPane.setDisable(false);
                        root.getChildren().remove(bananaBalm);
                        rockyPlayer.setHealth(100);
                        rockyPlayer.setMana(rockyPlayer.getMana() - 25);
                        rockyPlayer.updateBarsAndLabels();
                        pause.play();
                        pause.setOnFinished(event -> {
                            createBossAttack();
                            rockyPlayer.updateBarsAndLabels();
                        });
                    });
                    break;
                default:
                    System.out.println("Skill not found.");
            }
        return bossHealth;
    } //end createSkillButtonUse()

    /**
     * creates snack item usage
     * @param item takes in snack
     * @param rP takes in rocky player
     * @param pause takes in pause transition
     * @param snackMenu takes in snackMenu
     */
    public void createSnackButtonUse(Item item, RockyPlayer rP, PauseTransition pause, GridPane snackMenu) {
        setOnMouseClicked(e -> {
            if (item.getAmount() > 0) {
                item.useItem();
                item.setAmount(item.getAmount() - 1);
                setText(item.getName() + " x" + item.getAmount());
                rP.updateBarsAndLabels();
                snackMenu.setDisable(true);
                pause.play();
                pause.setOnFinished(event -> {
                    snackMenu.setDisable(false);
                    rP.updateBarsAndLabels();
                });
            }
        });
    } //end createSnackButtonUse()
}
