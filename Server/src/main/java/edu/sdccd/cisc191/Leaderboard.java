package edu.sdccd.cisc191;
import edu.sdccd.cisc191.Scenes.SceneController;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Scanner;


public class Leaderboard extends SceneController {

    private BinarySearchTree bst = new BinarySearchTree();

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

    public void readFromLeaderboard() {

        System.out.println("addToLeaderboard Method Called");
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
            bst.printInorder(bst.root);


            //W.I.P finds player w/ their fastest time
            BSTNode node = bst.searchPlayer(bst.root, "Ekin");
            bst.printPlayer(node);

            in.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addToLeaderboard(String name, String time) {
        File file = new File("leaderboard.csv");
    }
}

