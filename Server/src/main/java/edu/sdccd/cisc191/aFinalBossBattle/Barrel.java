package edu.sdccd.cisc191.aFinalBossBattle;

import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Barrel extends ImageView {
    private double velocityX;
    private int minX = 50;
    private int maxX = 950;
    private boolean running = true;
    Thread thread;

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

        // start movement logic in a new thread
        thread = new Thread() {
            public void run() {
                while (running) {
                    update();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        running = false;
                    }
                }
            }
        };
        thread.start();
    }

    public void update() {
        double newX = getTranslateX() + velocityX;

        // if barrel reaches end of platform, change direction
        if (newX < minX || newX + getFitWidth() > maxX) {
            velocityX *= -1;
        }

        Platform.runLater(() -> setTranslateX(newX));
    }

    public void stop() {
        thread.interrupt();
    }
}
