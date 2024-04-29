package edu.sdccd.cisc191.aFinalBossBattle;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
    }
}
