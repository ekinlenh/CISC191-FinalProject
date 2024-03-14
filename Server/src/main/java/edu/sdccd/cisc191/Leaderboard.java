package edu.sdccd.cisc191;
import edu.sdccd.cisc191.Scenes.SceneController;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;


public class Leaderboard extends SceneController {
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

    public void addToLeaderboard(String name, String time) {

        try {
            URL url = new URL("https://kaid01.github.io/MonkeyGame.github.io/leaderboard.csv");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);

            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(name + time);
            out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String leaderboard;
            while ((leaderboard = in.readLine()) != null) {
                System.out.println(leaderboard);
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

