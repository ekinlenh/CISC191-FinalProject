package edu.sdccd.cisc191;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    /**
     * show an alert message when player does something bad
     * @param title takes in window title
     * @param message takes in message
     */
    public static void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(250);
        window.setResizable(false);

        Label label = new Label();
        label.setText(message);
        label.setStyle("-fx-font-weight: bold; -fx-text-fill: white");

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        BorderPane layout = new BorderPane();
        layout.setCenter(label);
        HBox close = new HBox();
        close.getChildren().add(closeButton);
        close.setAlignment(Pos.CENTER);
        layout.setBottom(close);
        layout.setStyle("-fx-background-color: #6F4E37");

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    } //end display()
}
