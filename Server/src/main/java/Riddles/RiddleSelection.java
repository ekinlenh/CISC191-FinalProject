package Riddles;

import java.io.*;
import java.util.*;

public class RiddleSelection {
    static String[] qAndA;
    static final Random random = new Random();
    static int i = random.nextInt(10);

    static public String chooseRandomRiddle() {
        String tempRiddle = null;

        try {
            File file = new File("Server\\src\\main\\resources\\chosenriddles.txt");
            Scanner fileReader = new Scanner(file);
            String line = fileReader.nextLine();
            //List<String> words = new ArrayList<>();
            while (fileReader.hasNext()) {
                //Collections.addAll(words, line);
                line = fileReader.nextLine();
                String[] qAndA = line.split("&");
            }

            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9) {
                i++;
            }
            tempRiddle = qAndA[i];
            fileReader.close();

        } catch (IOException e) {
            System.out.println("File could not be found.");
        }
        return tempRiddle;
    }

    static public String findRiddleAnswer() {
        String tempAnswer = null;
            tempAnswer = qAndA[i + 1];
        return tempAnswer;
    }
}