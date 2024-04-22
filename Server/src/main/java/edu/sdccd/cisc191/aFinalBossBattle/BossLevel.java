package edu.sdccd.cisc191.aFinalBossBattle;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class BossLevel extends BossBattle {

    public static String[] bossScene = new String[] {
            "0000000000000000000000000",
            "0000000000000000000000000",
            "0M00000000000000000000000",
            "00000B0000000000000000000",
            "0111111111111111111133110",
            "0000000000000000000020000",
            "0000000000000000000020000",
            "0000000000000000000000000",
            "00B0000000000000000B00000",
            "0113311111111111111111110",
            "0000200000000000000000000",
            "0000200000000000000000000",
            "0000000000000000000000000",
            "000B000000000000000000B00",
            "0111111111111111111133110",
            "0000000000000000000020000",
            "0000000000000000000020000",
            "0000000000000000000000000",
            "0000000000000B00000000B00",
            "0111111111111111111111110"
    };
    public static ArrayList<Node> platforms = new ArrayList<Node>();
    public static ArrayList<Node> ladders = new ArrayList<Node>();
    public static ArrayList<Barrel> barrels = new ArrayList<Barrel>();
    public static ImageView elMono;


    /**
     * creates the boss level
     */
    public void createBossLevel() {
        for (int i = 0; i < bossScene.length; i++) {
            String currentLine = bossScene[i];
            for (int j = 0; j < currentLine.length(); j++) {

                //draws EL MONO
                if (currentLine.charAt(j) == 'M') {
                    elMono = new ImageView(new Image("CharacterImages/elMono.png"));
                    elMono.setFitHeight(150);
                    elMono.setFitWidth(150);
                    elMono.setPreserveRatio(true);
                    elMono.setLayoutX(j * 40);
                    elMono.setLayoutY(i);

                    root.getChildren().add(elMono);
                }

                //draws the platform
                if (currentLine.charAt(j) == '1') {
                    Node platform = drawPlatform(j * 40, i * 35, 40, 35, new Image("platform.png"));
                    platforms.add(platform);
                }

                //draws the ladders
                if (currentLine.charAt(j) == '2') {
                    Node ladder = drawLadder(j * 40, i * 35, 40, 80, new Image("vines1.png"));
                    ladders.add(ladder);
                }

                //draws vines overlay on platforms
                if (currentLine.charAt(j) == '3') {
                    Node ladderPlatform = drawLadder(j * 40, i * 35, 42, 35, new Image("vinesplatform.png"));
                    ladders.add(ladderPlatform);
                }

                //draws the barrels
                if (currentLine.charAt(j) == 'B') {
                    Barrel barrel = drawBarrel(j * 40, i * 35, 45, 40, new Image("barrel.png"));
                    barrels.add(barrel);
                }
            }
        }
    } //end createBossLevel()

    /**
     * draws the platform
     * @param x takes in x position
     * @param y takes in y position
     * @param w takes in platform width
     * @param h takes in platform height
     * @param image takes in image of platform
     * @return the platform
     */
    private Node drawPlatform(int x, int y, int w, int h, Image image) {
        Rectangle entity = new Rectangle(w, h);
        entity.setTranslateX(x);
        entity.setTranslateY(y);
        entity.setFill(new ImagePattern(image));

        root.getChildren().add(entity);

        return entity;
    }//end drawPlatform()

    /**
     * draws the ladders
     * @param x takes in x position
     * @param y takes in y position
     * @param w takes in ladder width
     * @param h takes in ladder height
     * @param image takes in ladder image
     * @return the ladder
     */
    private Node drawLadder(int x, int y, int w, int h, Image image) {
        Rectangle entity = new Rectangle(w, h);
        entity.setTranslateX(x);
        entity.setTranslateY(y);

        entity.setFill(new ImagePattern(image));

        root.getChildren().add(entity);

        return entity;
    }//end drawLadder()

    private Barrel drawBarrel(double x, double y, int w, int h, Image image) {
        Barrel barrel = new Barrel(image, x, y, w, h, 0.5);

        root.getChildren().add(barrel);

        return barrel;
    }//end drawBarrel()
}
