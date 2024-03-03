package edu.sdccd.cisc191.Wordle;

import edu.sdccd.cisc191.AlertBox;
import javafx.animation.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.HashMap;

public class WordGuessChecker extends WordleGameScreen{

    private static final int FLIP_DURATION = 500;

    /**
     * checks if guess is right or not
     */
    public static void checkGuess() {
        int correctSoFar = 0;

        HashMap<Character, Integer> charCount = new HashMap<>();
        char[] correctWord = word.toCharArray();

        for (char c: correctWord) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        } //end for-loop to find occurrences of each character

        if (WordSelection.checkValidWord()) {
            //loops through guess word and checks if each letter is right or not
            for (int i = 0; i < guessWord.length(); i++) {
                char letter = guessWord.charAt(i);
                labels[count][i].setText(String.valueOf(letter));

                //checks for correct placements first
                if (letter == correctWord[i] && charCount.get(correctWord[i]) > 0) {
                    labels[count][i].setStyle("-fx-background-color: #228B22");
                    charCount.put(letter, charCount.get(letter) - 1);
                    correctSoFar++;
                }

                //if not in word then gray out
                else {
                    labels[count][i].setStyle("-fx-background-color: #808080");
                }
            } //end for loop checking for green/gray

            //loops again to check for right letters but wrong placements
            //must be done after checking for all possible correct placements
            for (int i = 0; i < guessWord.length(); i++) {
                char letter = guessWord.charAt(i);

                //checks for right letters but wrong placements
                if (word.contains(String.valueOf(letter)) && letter != correctWord[i] && charCount.get(letter) > 0) {
                    labels[count][i].setStyle("-fx-background-color: #FFBF00");
                    charCount.put(letter, charCount.get(letter) - 1);
                }
            } //end for loop checking for yellow

            guessesRemaining--;
        } else {
            AlertBox.display("Invalid Word", "Not a valid word.");
            count--;
        }
        count++;

        //if all 5 are in correct place, player won
        if (correctSoFar == 5) {
            AlertBox.display("Winner", "Congratulations, you won!");
            submit.setDisable(true);
            exitButton.setVisible(true);
        } else if (guessesRemaining == 0) {
            AlertBox.display("Loser", "Wow you suck. The word was " + word);
            submit.setDisable(true);
            exitButton.setVisible(true);
        }

    } //end checkGuess()

    // W.I.P
    public static void animateWord() {
        if (WordSelection.checkValidWord()) {

        } else {
                AlertBox.display("Invalid Word", "Not a valid word.");
        }
    }
}
