package edu.sdccd.cisc191.Riddles;

import java.io.*;
import java.util.*;

public class RiddleSelection extends RiddlesGameScreen {
    private static final ArrayList<String[]> words = new ArrayList<>();
    private static String question;

    public static String chooseRandomRiddle() {
        try {
            File file = new File("Server\\src\\main\\resources\\riddle.txt");
            Scanner fileReader = new Scanner(file);
            List<String[]> words = new ArrayList<>();
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();
                String[] qAndA = line.split("&");
                words.add(qAndA);
            }

            Collections.shuffle(words);
            question = words.get(0)[0];
            answer = words.get(0)[1];
            System.out.println(words.get(0)[0]);
            System.out.println(words.get(0)[1]);

            fileReader.close();

        } catch (IOException e) {
            System.out.println("File could not be found.");
        }
        return question;
    }
}