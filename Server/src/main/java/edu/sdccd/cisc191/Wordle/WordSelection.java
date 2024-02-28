package edu.sdccd.cisc191.Wordle;

import java.io.*;
import java.util.*;

public class WordSelection extends WordleGameScreen {

    /**
     * choose a random word
     */
    public void chooseRandomWord() {
        try {
            File file = new File("words.txt");
            Scanner fileReader = new Scanner(file);
            String line = fileReader.nextLine();
            List<String> words = new ArrayList<String>();
            while (fileReader.hasNext()) {
                String[] wordsLine = line.split(" ");
                Collections.addAll(words, wordsLine);
                line = fileReader.nextLine();
            }

            Collections.shuffle(words);
            word = words.get(0).toUpperCase();
            fileReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } //end chooseRandomWord()
}
