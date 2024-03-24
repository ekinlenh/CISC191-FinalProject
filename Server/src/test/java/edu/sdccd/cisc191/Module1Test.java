package edu.sdccd.cisc191;

import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.TicTacToe.TicTacToeButtonController;
import edu.sdccd.cisc191.Wordish.WordSelection;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Module1Test {

    ArrayList<String> games = new ArrayList<>();

    /**
     * Sets up the test fixture with some arrays to test.
     * This method is called before every test case method.
     */
    @BeforeAll
    public void setUp() {
        //set up 1d array
        games = ProgressScenes.randomizeGameOrder();
    }

    /**
     * Tests to make sure array is not empty
     */
    @Test
    public void test1DArrays() {
        assertTrue(games.contains("TicTacToe"));
    }
}
