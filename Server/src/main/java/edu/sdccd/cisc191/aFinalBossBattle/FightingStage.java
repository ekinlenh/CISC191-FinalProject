package edu.sdccd.cisc191.aFinalBossBattle;

import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class FightingStage extends SceneController {

    public void createFight() {
        Pane root = new Pane();
        root.setPrefSize(1000, 700);
        root.setBackground(ProgressScenes.getBackground());

        currentStage.setScene(new Scene(root));
    } //end createFight()
}
