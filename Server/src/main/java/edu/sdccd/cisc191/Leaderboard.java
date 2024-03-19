package edu.sdccd.cisc191;
import edu.sdccd.cisc191.Scenes.SceneController;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;



public class Leaderboard extends SceneController {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    public void addToLeaderboard(String name, String time) {


        try {
            clientSocket = new Socket("127.0.0.1", 5555);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println(name + "," + time);
            stopConnection();

        }  catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}

