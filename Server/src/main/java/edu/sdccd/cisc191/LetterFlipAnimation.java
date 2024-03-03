package edu.sdccd.cisc191;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LetterFlipAnimation extends Application {

    private static final String word = "HELLO";
    private static final int FLIP_DURATION = 500;

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setHgap(10);

        for (int i = 0; i < word.length(); i++) {
            Label letterLabel = new Label();
            letterLabel.setText(String.valueOf(word.charAt(i)));
            letterLabel.setFont(new Font("Arial", 24));
            letterLabel.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 5px;");
            root.add(letterLabel, i, 0);

            animateLetter(letterLabel);
        }

        Scene scene = new Scene(root, 400, 100);
        primaryStage.setTitle("Letter Flip Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void animateLetter(Label label) {
        RotateTransition rt1 = new RotateTransition(Duration.millis(FLIP_DURATION), label);
        rt1.setAxis(Rotate.X_AXIS);
        rt1.setFromAngle(0);
        rt1.setToAngle(90);
        rt1.setInterpolator(Interpolator.LINEAR);

        PauseTransition pause = new PauseTransition(Duration.millis(FLIP_DURATION));

        RotateTransition rt2 = new RotateTransition(Duration.millis(FLIP_DURATION), label);
        rt2.setAxis(Rotate.X_AXIS);
        rt2.setFromAngle(90);
        rt2.setToAngle(0);
        rt2.setInterpolator(Interpolator.LINEAR);

        SequentialTransition sequentialTransition = new SequentialTransition(rt1, pause, rt2);
        sequentialTransition.setCycleCount(1);

        sequentialTransition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
