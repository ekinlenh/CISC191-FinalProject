package edu.sdccd.cisc191;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class GameButton extends Button {

    /**
     * styles game buttons
     * @param text takes in button text
     * @param width takes in button width
     * @param height takes in button height
     * @param fontSize takes in font size
     */
    public GameButton(String text, int width, int height, int fontSize) {
        setText(text);
        setPrefSize(width, height);
        setStyle("-fx-font-size:" + fontSize);
        setAlignment(Pos.CENTER);
        getStylesheets().add("stylesheet.css");
        getStyleClass().add("game-button");
    } //end constructor
}
