package edu.sdccd.cisc191.MonkeySnake;

import edu.sdccd.cisc191.GameButton;
import edu.sdccd.cisc191.GameLabel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;

import static edu.sdccd.cisc191.MonkeySnake.MonkeySnakeGameScreen.exitButton;
import static edu.sdccd.cisc191.MonkeySnake.MonkeySnakeGameScreen.monkeyLabel;

public class Snake {

    //dimensions for gameplay screen
    protected static final int SCREEN_WIDTH = 512;
    protected static final int SCREEN_HEIGHT = 512;
    protected static final int CELL_SIZE = 32;

    protected static LinkedList<Point> snake = new LinkedList<>();
    protected static Point snakeHead = new Point(8, SCREEN_WIDTH/CELL_SIZE/2);
    protected static Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
    protected static GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    protected static boolean gameOver = false;
    protected static int score = 0;
    protected static GameLabel scoreLabel = new GameLabel("Score: " + score, 512, 100, 48);
    protected static GameButton start = new GameButton("Start", 150, 75, 24);
    protected Timeline timeline;

    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;
    private static int currentDirection = RIGHT;

    /**
     * creates the game screen for snake
     */
    public Pane createGameScreen() {
        Pane root = new Pane();
        root.setPrefSize(512,700);
        root.setFocusTraversable(true);

        Pane padding = new Pane();
        padding.setPrefSize(512, 700);
        padding.setLayoutY(100);

        Group game = new Group();
        game.getChildren().add(canvas);

        padding.getChildren().add(game);
        padding.setPadding(new Insets(50, 50, 50, 50));
        padding.setStyle("-fx-background-color: #4a6741");

        for (int i = 0; i < 3; i++) {
            snake.add(new Point(5 + i, (SCREEN_WIDTH / CELL_SIZE / 2)));
        }
        snake.addFirst(snakeHead);

        timeline = new Timeline(new KeyFrame(Duration.millis(125), e -> runGame()));
        timeline.setCycleCount(Animation.INDEFINITE);

        start.setLayoutY(620);
        start.setLayoutX(195);
        start.setOnAction(event -> {
            timeline.play();
            start.setDisable(true);
        });

        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP) {
                    if (currentDirection != DOWN) {
                        currentDirection = UP;
                    }
                } else if (event.getCode() == KeyCode.DOWN) {
                    if (currentDirection != UP) {
                        currentDirection = DOWN;
                    }
                } else if (event.getCode() == KeyCode.LEFT) {
                    if (currentDirection != RIGHT) {
                        currentDirection = LEFT;
                    }
                } else if (event.getCode() == KeyCode.RIGHT) {
                    if (currentDirection != LEFT) {
                        currentDirection = RIGHT;
                    }
                }
            }
        });

        BananaFood.generateBanana();
        CanvasDrawing.drawScore(scoreLabel, score);

        root.getChildren().addAll(scoreLabel, padding, start);
        return root;
    } //end createGameScreen()

    /**
     * runs the game
     */
    private void runGame() {
        if (gameOver) {
            graphicsContext.setFill(Color.RED);
            graphicsContext.setFont(new Font("Elephant", 70));
            graphicsContext.fillText("Game Over", SCREEN_WIDTH/9.0, SCREEN_HEIGHT/2.0);
            if (checkScore()) {
                monkeyLabel.setText("How is that possible! \nWell fair is fair, you win. \nI'll let you pass.");
            } else {
                monkeyLabel.setText("Hah! My score is unbeatable.");
            }
            exitButton.setVisible(true);
            timeline.stop();
            return;
        }

        CanvasDrawing.drawBackground(graphicsContext, SCREEN_HEIGHT, SCREEN_WIDTH, CELL_SIZE);
        CanvasDrawing.drawSnake(graphicsContext, snake, snakeHead, CELL_SIZE);
        CanvasDrawing.drawScore(scoreLabel, score);
        BananaFood.drawBanana(graphicsContext);

        for (int i = snake.size() - 1; i >= 1; i--) {
           snake.get(i).x = snake.get(i - 1).x;
           snake.get(i).y = snake.get(i - 1).y;
        }


        switch (currentDirection) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }

        checkGameOver();
        BananaFood.eatFood();

    } //end runGame()

    /**
     * moves the snake up
     */
    private void moveUp() {
        snakeHead.y--;
    } //end moveUp()

    /**
     * moves the snake down
     */
    private void moveDown() {
        snakeHead.y++;
    } //end moveDown()

    /**
     * moves the snake left
     */
    private void moveLeft() {
        snakeHead.x--;
    } //end moveLeft()

    /**
     * moves the snake right
     */
    private void moveRight() {
        snakeHead.x++;
    } //end moveRight()

    /**
     * checks for game over
     */
    private void checkGameOver() {

        // checks to see if snake is out of bounds
        if (snakeHead.x < 0 || snakeHead.y < 0 || snakeHead.x * CELL_SIZE >= SCREEN_WIDTH || snakeHead.y * CELL_SIZE >= SCREEN_HEIGHT) {
            gameOver = true;
        }
        //  checks to see if snake kills itself
        for (int i = 1; i < snake.size(); i++) {
            if (snakeHead.x == snake.get(i).getX() && snakeHead.y == snake.get(i).getY()) {
                gameOver = true;
            }

        }

    } //end checkGameOver(0

    /**
     * checks for player score
     */
    public boolean checkScore() {
        return score > 30;
    } //end checkScore()

    /**
     * resets the game
     */
    public void resetGame() {
        snake.clear();
        snakeHead = new Point(8, SCREEN_WIDTH/CELL_SIZE/2);
        score = 0;
        gameOver = false;
        currentDirection = RIGHT;
        scoreLabel.setText("Score: " + score);
        start.setDisable(false);
        exitButton.setVisible(false);

        graphicsContext.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}
