package edu.sdccd.cisc191;

import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.TicTacToe.TicTacToeButtonController;
import edu.sdccd.cisc191.Wordish.WordSelection;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Module2Test {

    private static Button[][] buttonsArray = new Button[3][3];
    private TicTacToeButtonController buttonController = new TicTacToeButtonController();
    /**
     * Sets up the test fixture with some arrays to test.
     * This method is called before every test case method.
     */
    @BeforeAll
    public void setUp() {
        //set up 2d array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                buttonsArray[i][j] = button;
            }
        }
        buttonsArray[0][0].setText("X");
        buttonsArray[0][1].setText("X");
        buttonsArray[0][2].setText("X");
    }

    /**
     * Tests if 2d Array code works
     */
    @Test
    public void testTicTacToeGameOver() {
        assertTrue(buttonController.checkGameOver(buttonsArray));
    }
}
