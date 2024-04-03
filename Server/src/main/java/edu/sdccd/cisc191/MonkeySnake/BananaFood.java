package edu.sdccd.cisc191.MonkeySnake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.Point;

public class BananaFood extends Snake{

    private static int foodX;
    private static int foodY;

    /**
     * generates a random banana on the board
     */
    public static void generateBanana() {
        foodX = (int)(Math.random() * SCREEN_WIDTH/CELL_SIZE);
        foodY = (int)(Math.random() * SCREEN_HEIGHT/CELL_SIZE);
    } //end generateBanana()

    /**
     * draws the banana on the board
     */
    public static void drawBanana(GraphicsContext gc) {
        Image banana = new Image("banana.png");
        gc.drawImage(banana, foodX * CELL_SIZE, foodY * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    } //end drawBanana()

    /**
     * checks to see when snake eats the banana
     */
    public static void eatFood() {
        if (snakeHead.getX() == foodX && snakeHead.getY() == foodY) {
            snake.add(new Point(-1, -1));
            generateBanana();
            score++;
        }
    } //end eatFood()
}
