package edu.sdccd.cisc191.aFinalBossBattle;

import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.util.Duration;

public class FightingStage extends SceneController {

    private static ProgressBar monoHealth = new ProgressBar(1.0);
    private static Label bossText = new Label();;
    private static FadeTransition fadeIn, fadeOut;
    private static RockyPlayer rockyPlayer = new RockyPlayer();
    //buttons
    private static Button fightButton = new Button("FIGHT!");
    private static Button runButton = new Button("RUN...");
    private GridPane mainMenu = createCombatMenus("MainMenu");
    private GridPane skillsMenu = createCombatMenus("Skills");
    private GridPane snacksMenu = createCombatMenus("Snacks");

    /**
     * creates the boss battle fighting stage
     */
    public void createFight() {
        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        root.setBackground(ProgressScenes.getBackground());

        //el monos health bar
        monoHealth.setLayoutX(186);
        monoHealth.setLayoutY(61);
        monoHealth.setPrefSize(628, 20);
        monoHealth.setStyle("-fx-border-radius: 20%; -fx-control-inner-background: #800020; -fx-accent: #800020; -fx-border-color: #800020;");

        //boss name
        Label elMonoBoss = new Label("EL MONO");
        elMonoBoss.setFont(Font.font("Elephant", FontWeight.BOLD, 48));
        elMonoBoss.setTextFill(Color.BLACK);
        elMonoBoss.setAlignment(Pos.CENTER);
        elMonoBoss.setPrefSize(628, 69);
        elMonoBoss.setLayoutX(186);
        elMonoBoss.setLayoutY(2);

        //boss image
        ImageView elMonoImage = new ImageView(new Image("CharacterImages/elMonoSuper.png"));
        elMonoImage.setFitWidth(500);
        elMonoImage.setFitHeight(500);
        elMonoImage.setLayoutX(250);
        elMonoImage.setLayoutY(100);

        //boss text
        bossText = new Label("You may have defeated my domain...\nbut let's see how you fair up against \nme at my best.");
        bossText.setFont(Font.font("Elephant", 24));
        bossText.setTextFill(Color.WHITE);
        bossText.setPrefSize(468, 132);
        bossText.setAlignment(javafx.geometry.Pos.CENTER);
        bossText.setStyle("-fx-background-color: #4a6741;");
        bossText.setLayoutX(267);
        bossText.setLayoutY(352);

        //rocky image
        Rectangle rectangle1 = new Rectangle(200, 250, Color.web("#355e3b"));
        rectangle1.setLayoutX(14);
        rectangle1.setLayoutY(418);
        Rectangle rectangle2 = new Rectangle(169, 158, Color.WHITE);
        rectangle2.setLayoutX(30);
        rectangle2.setLayoutY(420);
        ImageView rockyImage = new ImageView(new Image("CharacterImages/rockyProfile.png"));
        rockyImage.setFitWidth(150);
        rockyImage.setFitHeight(200);
        rockyImage.setLayoutX(39);
        rockyImage.setLayoutY(378);

        ImageView heart = new ImageView(new Image("CharacterImages/heart.png"));
        heart.setFitWidth(37);
        heart.setFitHeight(37);
        heart.setLayoutX(22);
        heart.setLayoutY(584);

        ImageView manaImage = new ImageView(new Image("CharacterImages/mana.png"));
        manaImage.setFitWidth(22);
        manaImage.setFitHeight(31);
        manaImage.setLayoutX(29);
        manaImage.setLayoutY(630);

        //fight and run buttons
        runButton.setFont(Font.font("Elephant", FontWeight.BOLD, 36));
        runButton.setTextFill(Color.WHITE);
        runButton.setStyle("-fx-background-color: #355E3B;");
        runButton.setPrefSize(559, 69);
        runButton.setLayoutX(221);
        runButton.setLayoutY(598);
        runButton.setOnMouseClicked(e -> {
            fadeIn.play();
            fadeOut.play();
            bossText.setVisible(true);
            bossText.setText("Did you really think you could run? \nI won't let you escape. \nOnly one of us will make it out.");
        });

        fightButton.setFont(Font.font("Elephant", FontWeight.BOLD, 36));
        fightButton.setTextFill(Color.WHITE);
        fightButton.setStyle("-fx-background-color: #355E3B; -fx-border-radius: 20%;");
        fightButton.setPrefSize(559, 69);
        fightButton.setLayoutX(221);
        fightButton.setLayoutY(519);
        fightButton.setOnMouseClicked(e -> {
            fightButton.setVisible(false);
            runButton.setVisible(false);
            mainMenu.setVisible(true);
            mainMenu.setDisable(false);
        });

        //cool fade in and out animation for boss text
        fadeIn = new FadeTransition(Duration.seconds(1), bossText);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        fadeOut = new FadeTransition(Duration.seconds(1), bossText);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setDelay(Duration.seconds(3));
        fadeOut.setOnFinished(e -> bossText.setVisible(false));
        fadeOut.play();

        rockyPlayer.updateBarsAndLabels();
        //adding all children to scene
        root.getChildren().addAll(monoHealth, elMonoBoss, elMonoImage, bossText,
                                  rectangle1, rectangle2, fightButton, runButton,
                                  rockyImage, heart, manaImage,
                                    rockyPlayer.getRockyHealthBar(), rockyPlayer.getRockyManaBar(),
                                  rockyPlayer.getRockyHealthLabel(), rockyPlayer.getRockyManaLabel(),
                                  mainMenu, skillsMenu, snacksMenu);
        currentStage.setScene(new Scene(root));
    } //end createFight()

    /**
     * creates the combat menus for the boss battle
     * @param text takes in what combat menu to create
     * @return the combat menu as a grid pane
     */
    private GridPane createCombatMenus(String text) {
        //basic setup
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setLayoutX(221);
        gridPane.setLayoutY(519);
        gridPane.setPrefSize(559, 158);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setDisable(true);
        gridPane.setVisible(false);
        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        RowConstraints rowConstraints1 = new RowConstraints();
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        RowConstraints rowConstraints2 = new RowConstraints();
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        gridPane.getColumnConstraints().addAll(columnConstraints1, columnConstraints2);
        gridPane.getRowConstraints().addAll(rowConstraints1, rowConstraints2);

        //adding buttons to grid pane
        if (text.equalsIgnoreCase("MainMenu")) {
            CombatButton attackButton = new CombatButton("Attack", 24);
            CombatButton skillButton = new CombatButton("Skill", 24);
            skillButton.setOnMouseClicked(e -> {
                skillsMenu.setVisible(true);
                skillsMenu.setDisable(false);
            });
            CombatButton snackButton = new CombatButton("Snack", 24);
            snackButton.setOnMouseClicked(e -> {
                snacksMenu.setVisible(true);
                snacksMenu.setDisable(false);
            });
            CombatButton backButton = new CombatButton("Back ➪", 24);
            backButton.setOnMouseClicked(e -> {
                mainMenu.setVisible(false);
                mainMenu.setDisable(true);
                fightButton.setVisible(true);
                runButton.setVisible(true);
            });

            gridPane.add(attackButton, 1, 1);
            gridPane.add(skillButton, 2, 1);
            gridPane.add(snackButton, 1, 2);
            gridPane.add(backButton, 2, 2);
        }

        if (text.equalsIgnoreCase("Skills")) {
            CombatButton bananaBarrage = new CombatButton("Banana Barrage", 16);
            Tooltip tooltip1 = new Tooltip();
            tooltip1.setGraphic(createSkillTooltip("Banana Barrage", "Hurls a series of explosive\nbananas at their enemies,\ndealing great damage.", 5));
            bananaBarrage.setOnMouseEntered(e -> {
                tooltip1.show(bananaBarrage, e.getSceneX() + 300, e.getSceneY() - 150);
            });
            bananaBarrage.setOnMouseExited(e -> tooltip1.hide());

            CombatButton leafShield = new CombatButton("Spiky Shield", 16);
            Tooltip tooltip2 = new Tooltip();
            tooltip2.setGraphic(createSkillTooltip("Spiky Shield", "Creates a barrier.\nWhen used, blocks any\ndamage dealt by the\nenemy, dealing damage in\nreturn to the foe.", 10));
            leafShield.setOnMouseEntered(e -> {
                tooltip2.show(leafShield, e.getSceneX() + 300, e.getSceneY() - 150);
            });
            leafShield.setOnMouseExited(e -> tooltip2.hide());

            CombatButton bananaBalm = new CombatButton("Banana Balm", 16);
            Tooltip tooltip3 = new Tooltip();
            tooltip3.setGraphic(createSkillTooltip("Banana Balm", "A healing skill that\nharnesses the soothing\nproperties of bananas.\nUsing banana extracts,\nheals the user.", 15));
            bananaBalm.setOnMouseEntered(e -> {
                tooltip3.show(bananaBalm, e.getSceneX() + 300, e.getSceneY() - 150);
            });
            bananaBalm.setOnMouseExited(e -> tooltip3.hide());

            CombatButton backButton = new CombatButton("Back ➪", 16);
            backButton.setOnMouseClicked(e -> {
                skillsMenu.setVisible(false);
                skillsMenu.setDisable(true);
                mainMenu.setVisible(true);
                mainMenu.setDisable(false);
            });

            gridPane.add(bananaBarrage, 1, 1);
            gridPane.add(leafShield, 2, 1);
            gridPane.add(bananaBalm, 1, 2);
            gridPane.add(backButton, 2, 2);
        }

        if (text.equalsIgnoreCase("Snacks")) {
            CombatButton bananaBliss = new CombatButton("Banana Bliss x2", 16);
            CombatButton powerFruit = new CombatButton("Power Fruit x1", 16);
            CombatButton mysticMelon = new CombatButton("Mystic Melon x2", 16);
            CombatButton backButton = new CombatButton("Back ➪", 16);
            backButton.setOnMouseClicked(e -> {
                snacksMenu.setVisible(false);
                snacksMenu.setDisable(true);
                mainMenu.setVisible(true);
                mainMenu.setDisable(false);
            });

            gridPane.add(bananaBliss, 1, 1);
            gridPane.add(powerFruit, 2, 1);
            gridPane.add(mysticMelon, 1, 2);
            gridPane.add(backButton, 2, 2);
        }

        return gridPane;
    } //end createCombatMenus()

    private VBox createSkillTooltip(String name, String description, int manaCost) {
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
        return content;
    } //end createTooltipContent
}
