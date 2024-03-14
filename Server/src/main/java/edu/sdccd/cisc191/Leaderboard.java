package edu.sdccd.cisc191;
import edu.sdccd.cisc191.Scenes.SceneController;

import java.awt.*;
import java.net.*;
import java.io.*;


public class Leaderboard extends SceneController {

    private Socket clientSocket;
    private PrintWriter out;


    public void startConnection() {
        try {
            clientSocket = new Socket("127.0.0.1", 5555);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void timerInfo(String name, String time) {

        out.print(name + time);

    }
}

