package edu.sdccd.cisc191;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Region;

public class JavaFXStyles<T extends Region> {

    private final T node;

    public JavaFXStyles(T node) {
        this.node = node;
    }
    public void setFXStyle() {
        node.setStyle("-fx-font-family: Elephant; -fx-font-size: 18; -fx-background-color: #4a6741; -fx-text-fill: white; -fx-background-radius: 20%");
    } //end setStyle()

}
