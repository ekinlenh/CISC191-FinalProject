package edu.sdccd.cisc191.aFinalBossBattle;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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

    public static void createSnackButtonUse(CombatButton combatButton, Item item, RockyPlayer rP, PauseTransition pause, GridPane snacksMenu) {
        combatButton.setOnMouseClicked(e -> {
            if (item.getAmount() > 0) {
                item.useItem();
                item.setAmount(item.getAmount() - 1);
                combatButton.setText(item.getName() + " x" + item.getAmount());
                rP.updateBarsAndLabels();
                pause.play();
                pause.setOnFinished(event -> {
                    createBossAttack();
                    rP.updateBarsAndLabels();
                });
            }
        });
    } //end createSnackButtonUse()
}
