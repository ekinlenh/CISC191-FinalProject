package edu.sdccd.cisc191.Wordish;

import edu.sdccd.cisc191.GUI;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordSelection {

    public static final String RESOURCES_PATH = "Server/src/main/resources";

    /**
     * choose a random word
     * @return a random word
     */
    public static String chooseRandomWord() {
        String word = null;
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(RESOURCES_PATH + "/" + "chosenwords.txt"));
            Scanner fileReader = new Scanner(inputStream);
            String line = fileReader.nextLine();
            List<String> words = new ArrayList<>();
            while (fileReader.hasNext()) {
                Collections.addAll(words, line);
                line = fileReader.nextLine();
            }

            Collections.shuffle(words);
            fileReader.close();
            word = words.get(0).toUpperCase();
            return word;

        } catch (IOException e) {
            System.out.println("File could not be found.");
        }
        return word;
    } //end chooseRandomWord()

    /**
     * checks to see if word is a valid wor
     * @return if word is valid or not
     */
    public static boolean checkValidWord(String guessWord) {
        try {
            File file = new File(RESOURCES_PATH + "/" + "possiblewords.txt");
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
