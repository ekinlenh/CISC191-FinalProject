package edu.sdccd.cisc191.Wordish;

import java.io.*;
import java.util.*;

public class WordSelection extends WordleGameScreen {

    /**
     * choose a random word
     */
    public static void chooseRandomWord() {
        try {
            File file = new File("Server\\src\\main\\resources\\chosenwords.txt");
            Scanner fileReader = new Scanner(file);
            String line = fileReader.nextLine();
            List<String> words = new ArrayList<>();
            while (fileReader.hasNext()) {
                Collections.addAll(words, line);
                line = fileReader.nextLine();
            }

            Collections.shuffle(words);
            word = words.get(0).toUpperCase();
            fileReader.close();

        } catch (IOException e) {
            System.out.println("File could not be found.");
        }
    } //end chooseRandomWord()

    /**
     * checks to see if word is a valid wor
     * @return if word is valid or not
     */
    public static boolean checkValidWord() {
        try {
            File file = new File("Server\\src\\main\\resources\\possiblewords.txt");
            Scanner fileReader = new Scanner(file);
            String line = fileReader.nextLine();

            while (fileReader.hasNext()) {
                if (guessWord.equalsIgnoreCase(line)) {
                    return true;
                }
                line = fileReader.nextLine();
            }

            fileReader.close();
            return false;
        } catch (IOException e) {
            System.out.println("File could not be found.");
        }
        return false;
    } //checkValidWord();
}
