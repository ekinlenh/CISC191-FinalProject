package edu.sdccd.cisc191.Wordish;

import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class TitleAnimation extends WordishGameScreen{

    private static Label[] titleLabels;

    /**
     * creates title
     * @return the GridPane that contains the title name of game
     */
    public static GridPane createTitle() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setLayoutX(14);
        gridPane.setLayoutY(29);
        gridPane.setPrefHeight(105);
        gridPane.setPrefWidth(462);

        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(50);
        columnConstraints1.setPrefWidth(100);
        gridPane.getColumnConstraints().addAll(columnConstraints1, columnConstraints1, columnConstraints1, columnConstraints1, columnConstraints1, columnConstraints1, columnConstraints1);

        RowConstraints rowConstraints1 = new RowConstraints();
        rowConstraints1.setMinHeight(10);
        rowConstraints1.setPrefHeight(30);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        gridPane.getRowConstraints().add(rowConstraints1);

        Label labelW, labelO, labelR, labelD, labelI, labelS, labelH;
        labelW = createStyles("W");
        labelO = createStyles("O");
        labelR = createStyles("R");
        labelD = createStyles("D");
        labelI = createStyles("I");
        labelS = createStyles("S");
        labelH = createStyles("H");

        titleLabels = new Label[]{labelW, labelO, labelR, labelD, labelI, labelS, labelH};

        gridPane.add(labelW, 0, 0);
        gridPane.add(labelO, 1, 0);
        gridPane.add(labelR, 2, 0);
        gridPane.add(labelD, 3, 0);
        gridPane.add(labelI, 4, 0);
        gridPane.add(labelS, 5, 0);
        gridPane.add(labelH, 6, 0);

        return gridPane;
    } //end createTitle()

    /**
     * animates title name
     */
    public static void animateTitle() {
        for (int i = 0; i < 7; i++) {
            SequentialTransition st = new SequentialTransition();

            RotateTransition rt1 = new RotateTransition(Duration.seconds(0.5), titleLabels[i]);
            rt1.setAxis(Rotate.X_AXIS);
            rt1.setFromAngle(0);
            rt1.setToAngle(90);

            RotateTransition rt2 = new RotateTransition(Duration.seconds(0.5), titleLabels[i]);
            rt2.setAxis(Rotate.X_AXIS);
            rt2.setFromAngle(90);
            rt2.setToAngle(0);

            st.getChildren().addAll(rt1, rt2);
            st.play();
        }
    } //end animateTitle()

    /**
     * style title
     * @param text takes in a string to stylize
     * @return a label for the GridPane box
     */
    private static Label createStyles(String text) {
        Label label = new Label(text);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setMaxWidth(66);
        label.setMinWidth(61);
        label.setPrefHeight(105);
        label.setPrefWidth(61);
        label.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 20%;");
        label.setFont(new Font("Times New Roman", 64));

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.5));

        label.setEffect(dropShadow);

        return label;
    } //end createStyles

}
