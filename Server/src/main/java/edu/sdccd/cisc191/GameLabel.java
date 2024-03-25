package edu.sdccd.cisc191;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class GameLabel extends Label {

    public GameLabel(String text, int width, int height, int fontSize) {
        setText(text);
        setPrefSize(width, height);
        setStyle("-fx-font-size: " + fontSize);
        setAlignment(Pos.CENTER);
        getStylesheets().add("stylesheet.css");
        getStyleClass().add("game-label");
    } //end constructor
}
