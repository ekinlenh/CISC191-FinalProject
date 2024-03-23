package edu.sdccd.cisc191;

import edu.sdccd.cisc191.Scenes.ProgressScenes;
import edu.sdccd.cisc191.Wordish.WordSelection;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Module4Test {

    /**
     * Tests to make sure word is not null when randomizing
     */
    @Test
    public void testWordishRandomizedWord() {
        assertNotNull(WordSelection.chooseRandomWord());
    }

    /**
     * Tests to make sure player word is valid word
     */
    @Test
    public void testWordishValidWord() {
        assertTrue(WordSelection.checkValidWord("CRANE"));
    }
}
