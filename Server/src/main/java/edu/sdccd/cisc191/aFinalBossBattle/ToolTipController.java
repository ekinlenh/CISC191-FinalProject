package edu.sdccd.cisc191.aFinalBossBattle;

import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ToolTipController {

    public static void createSkillTooltip(CombatButton button, String name, String description, int manaCost) {
        Tooltip tooltip = new Tooltip();

        VBox content = new VBox();
        content.setPrefSize(182,200);

        //skill name
        Label skillName = new Label(name);
        skillName.setPrefSize(182,62);
        skillName.setTextFill(Color.WHITE);
        skillName.setFont(Font.font("Elephant", 18.0));

        //skill description
        Label descriptionLabel = new Label(description);
        descriptionLabel.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        descriptionLabel.setPrefSize(182,111);
        descriptionLabel.setTextFill(Color.WHITE);
        descriptionLabel.setFont(Font.font("Elephant", 14.0));

        //mana cost
        HBox manaCostBox = new HBox();
        manaCostBox.setAlignment(javafx.geometry.Pos.CENTER);
        manaCostBox.setPrefHeight(48.0);
        manaCostBox.setPrefWidth(182.0);

        Label manaLabel = new Label("" + manaCost);
        manaLabel.setPrefHeight(41.0);
        manaLabel.setPrefWidth(42.0);
        manaLabel.setTextFill(Color.WHITE);
        manaLabel.setFont(Font.font("Elephant", 18.0));

        ImageView manaImage = new ImageView(new Image("CharacterImages/mana.png"));
        manaImage.setFitHeight(31.0);
        manaImage.setFitWidth(22.0);

        manaCostBox.getChildren().addAll(manaLabel, manaImage);

        content.getChildren().addAll(skillName, descriptionLabel, manaCostBox);
        tooltip.setGraphic(content);

        button.setOnMouseEntered(e -> {
            tooltip.show(button, e.getScreenX(), e.getScreenY() - 300);
        });
        button.setOnMouseExited(e -> tooltip.hide());
    } //end createTooltipContent

    public static void createSnacksToolTip(CombatButton button, String name, String description) {
        Tooltip tooltip = new Tooltip();

        VBox content = new VBox();
        content.setPrefSize(182,200);

        //skill name
        Label skillName = new Label(name);
        skillName.setPrefSize(182,62);
        skillName.setTextFill(Color.WHITE);
        skillName.setFont(Font.font("Elephant", 18.0));

        //skill description
        Label descriptionLabel = new Label(description);
        descriptionLabel.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        descriptionLabel.setPrefSize(182,111);
        descriptionLabel.setTextFill(Color.WHITE);
        descriptionLabel.setFont(Font.font("Elephant", 14.0));

        content.getChildren().addAll(skillName, descriptionLabel);
        tooltip.setGraphic(content);

        button.setOnMouseEntered(e -> {
            tooltip.show(button, e.getScreenX(), e.getScreenY() - 300);
        });
        button.setOnMouseExited(e -> tooltip.hide());
    } //end createSnacksToolTip()

}
