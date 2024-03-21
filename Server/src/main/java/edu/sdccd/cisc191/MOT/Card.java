package edu.sdccd.cisc191.MOT;

import javafx.scene.image.*;

class Card {
    String color;
    String value;
    String image;

    Card(String color, String value, String image) {
        this.color = color;
        this.value = value;
        this.image = image;
    }

    void setColor(String color) {
        this.color = color;
    }
}
