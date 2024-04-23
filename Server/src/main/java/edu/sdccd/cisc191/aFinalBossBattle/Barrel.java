package edu.sdccd.cisc191.aFinalBossBattle;

import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Barrel extends ImageView {
    private double velocityX;
    private int minX = 50;
    private int maxX = 950;

    public Barrel(Image image, double x, double y, int w, int h, double velocityX) {
        super(image);
        this.velocityX = velocityX;
        setFitWidth(w);
        setFitHeight(h);
        setTranslateX(x);
        setTranslateY(y);

        // rolling animation
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), this);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.play();
    }

    public void update() {
        double newX = getTranslateX() + velocityX;

        // if barrel reaches end of platform, change direction
        if (newX < minX || newX + getFitWidth() > maxX) {
            velocityX *= -1;
        }

        setTranslateX(newX);
    }
}
