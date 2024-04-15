package edu.sdccd.cisc191.MonkeySnake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.Point;
import java.util.Iterator;

public class BananaFood extends Snake{

    private static int foodX;
    private static int foodY;

    /**
     * generates a random banana on the board
     */
    public static void generateBanana() {
        do {
            foodX = (int)(Math.random() * SCREEN_WIDTH/CELL_SIZE);
            foodY = (int)(Math.random() * SCREEN_HEIGHT/CELL_SIZE);
        } while (checkIfAtSnakePosition(foodX, foodY));
    } //end generateBanana()

    /**
     * checks to make sure banana is not in any snake cells
     */
    private static boolean checkIfAtSnakePosition(int x, int y) {
        for (Point point: snake) {
            if (point.x == x && point.y == y) {
                return true;
            }
        }
        return false;
    }

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
