package edu.sdccd.cisc191.Wordish;

import edu.sdccd.cisc191.Scenes.AlertBox;
import edu.sdccd.cisc191.Scenes.ProgressScenes;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.util.HashMap;

public class WordGuessChecker extends WordishGameScreen{

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
                labels[counter][i].setText(String.valueOf(letter));

                //checks for correct placements first
                if (letter == correctWord[i] && charCount.get(correctWord[i]) > 0) {
                    labels[counter][i].setStyle("-fx-background-color: #4a6741");
                    charCount.put(letter, charCount.get(letter) - 1);
                    correctSoFar++;
                }

                //if not in word then gray out
                else {
                    labels[counter][i].setStyle("-fx-background-color: #6F4E37");
                }
            } //end for loop checking for green/gray

            //loops again to check for right letters but wrong placements
            //must be done after checking for all possible correct placements
            for (int i = 0; i < guessWord.length(); i++) {
                char letter = guessWord.charAt(i);

                //checks for right letters but wrong placements
                if (word.contains(String.valueOf(letter)) && letter != correctWord[i] && charCount.get(letter) > 0) {
                    labels[counter][i].setStyle("-fx-background-color: #E1C16E");
                    charCount.put(letter, charCount.get(letter) - 1);
                }
            } //end for loop checking for yellow

            guessesRemaining--;
        } else {
            AlertBox.display("Invalid Word", "Not a valid word.");
            counter--;
        }
        counter++;

        //if all 5 are in correct place, player won
        if (correctSoFar == 5) {
            won++;
            rect.setFill(new ImagePattern(new Image("CharacterImages/librarianLost.png")));
            submit.setDisable(true);
            exitButton.setVisible(true);
            gamesWon++;
            ProgressScenes.changeScene();
        } else if (guessesRemaining == 0) {
            AlertBox.display("Loser", "Wow you suck. The word was " + word);
            submit.setDisable(true);
            exitButton.setVisible(true);
            updateLosses();
        }

    } //end checkGuess()

}
