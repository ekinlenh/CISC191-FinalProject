package edu.sdccd.cisc191.MonkeySnake;

import edu.sdccd.cisc191.GameLabel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.LinkedList;

public class CanvasDrawing {

    /**
     * draws the background of snake game
     */
    public static void drawBackground(GraphicsContext gc, int screenHeight, int screenWidth, int cellSize) {
        int rows = screenHeight / cellSize;
        int cols = screenWidth / cellSize;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.rgb(82, 60, 41));
                } else {
                    gc.setFill(Color.rgb(62, 40, 41));
                }
                gc.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
            }}
    } //end drawBackground()

    /**
     * draws the snake
     */
    public static void drawSnake(GraphicsContext gc, LinkedList<Point> snake, Point snakeHead, int cellSize) {
        gc.setFill(Color.rgb(52, 30, 41));

        for (Point point : snake) {
            gc.fillRoundRect(point.getX() * cellSize, point.getY() * cellSize, cellSize, cellSize, 50, 50);
        }

        Image monkeyFace = new Image("monkeySnake.png");
        gc.drawImage(monkeyFace, snakeHead.getX() * cellSize, snakeHead.getY() * cellSize, cellSize, cellSize);
    } //end drawSnake()

    /**
     * draws the score on the screen
     */
    public static void drawScore(GameLabel scoreLabel, int score) {
        scoreLabel.setText("Score: " + score);
    } //end drawScore()
}
