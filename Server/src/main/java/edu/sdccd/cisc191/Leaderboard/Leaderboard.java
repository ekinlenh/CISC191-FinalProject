package edu.sdccd.cisc191.Leaderboard;

import edu.sdccd.cisc191.GameLabel;
import edu.sdccd.cisc191.Scenes.SceneController;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.net.*;
import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Scanner;
import java.sql.SQLException;


public class Leaderboard extends SceneController {

    private static BinarySearchTree bst = new BinarySearchTree();

    public void test(String name, String time) {
        try {

            URL url = new URL("https://kaid01.github.io/MonkeyGame.github.io/leaderboard.csv");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStream out = connection.getOutputStream();
            WritableByteChannel rbc = Channels.newChannel(out);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

            bw.write(name + time);

            bw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public VBox readFromLeaderboard() {

        VBox fastestTimesBox = new VBox();
        fastestTimesBox.setLayoutX(483);
        fastestTimesBox.setLayoutY(60);
        fastestTimesBox.setPrefSize(517, 500);
        fastestTimesBox.setStyle("-fx-background-color: #4a6741;");
        fastestTimesBox.setSpacing(10);
        fastestTimesBox.setPadding(new Insets(10));

        bst = new BinarySearchTree();

        try {
//            URL url = new URL("https://kaid01.github.io/MonkeyGame.github.io/leaderboard.csv");
//            URLConnection connection = url.openConnection();
//            connection.setDoOutput(true);

            // Reading
//            Scanner in = new Scanner(new InputStreamReader(connection.getInputStream()));

            File file = new File("Server/src/main/resources/leaderboardscores.txt");
            Scanner in = new Scanner(file);

            //W.I.P
            while (in.hasNext()) {
                //get each line in file
                String line = in.nextLine();
                String[] playerInfo = line.split(",");

                // grab player info
                String playerName = playerInfo[0];
                String playerTime = playerInfo[1];

                // add player info to tree
                bst.root = bst.add(bst.root, playerName, playerTime);
            }

            //print from best time to worst time
            bst.printInorder(bst.root, fastestTimesBox);

            //W.I.P finds player w/ their fastest time
            //BSTNode node = bst.searchPlayer(bst.root, "Ekin");
            //bst.printPlayer(node);

            in.close();
            return fastestTimesBox;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToLeaderboard() {
        String name = adventurer.getPlayerName();
        String time = timerLabel.getText();

        try {
            FileWriter fw = new FileWriter("Server/src/main/resources/leaderboardscores.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(name + ", " + time + "\n");
            bw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

