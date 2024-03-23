package edu.sdccd.cisc191;

import edu.sdccd.cisc191.Wordish.WordSelection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Module5Test {

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
        assertFalse(WordSelection.checkValidWord("eeeee"));
    }
}

//IMPORTANT MESSAGE: For this to work, remove the "Server/" part of the directory in the WordSelection class
//"Server/" must be kept for the game to work; idk why