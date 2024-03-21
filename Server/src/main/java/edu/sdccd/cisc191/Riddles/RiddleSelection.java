package edu.sdccd.cisc191.Riddles;

import java.io.*;
import java.util.*;

public class RiddleSelection extends RiddlesGameScreen {

    private static String[] multipleChoice;

    /**
     * chooses a random riddle from a file
     *
     * @return
     */
    public static String[] chooseRandomRiddle() {
        try {
            File file = new File("Server\\src\\main\\resources\\riddle.txt");
            Scanner fileReader = new Scanner(file);
            List<String[]> words = new ArrayList<>();
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();
                String[] qAndA = line.split("&");
                words.add(qAndA);
            }

            //get a random riddle and then have a multiple choice with one correct answer
            Collections.shuffle(words);
            riddle = words.get(0)[0];
            String answerSelection = words.get(0)[1];
            multipleChoice = answerSelection.split(",");
            fileReader.close();
        } catch (IOException e) {
            System.out.println("File could not be found.");
        }
        return multipleChoice;
    }
}