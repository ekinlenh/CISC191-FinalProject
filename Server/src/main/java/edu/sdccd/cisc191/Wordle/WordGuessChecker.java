package edu.sdccd.cisc191.Wordle;

import edu.sdccd.cisc191.AlertBox;
import java.util.HashMap;

public class WordGuessChecker extends WordleGameScreen{

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

                //checks for right letters but wrong placements
                } else if (word.contains(String.valueOf(letter)) && letter != correctWord[i] && charCount.get(letter) > 0) {
                    labels[count][i].setStyle("-fx-background-color: #FFBF00");
                    charCount.put(letter, charCount.get(letter) - 1);

                //if not in word then gray out
                } else {
                    labels[count][i].setStyle("-fx-background-color: #808080");
                }
            }

            //if all 5 are in correct place, player won
            if (correctSoFar == 5) {
                submit.setDisable(true);
                exitButton.setVisible(true);
            }

        } else {
            AlertBox.display("Invalid Word", "Not a valid word.");
            count--;
        }
        count++;
        } //end checkGuess()
}
