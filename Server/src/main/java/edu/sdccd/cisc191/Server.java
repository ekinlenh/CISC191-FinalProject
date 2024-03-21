package edu.sdccd.cisc191;

import java.net.*;
import java.io.*;

/**
 * This program is a server that takes connection requests on
 * the port specified by the constant LISTENING_PORT.  When a
 * connection is opened, the program sends the current time to
 * the connected socket.  The program will continue to receive
 * and process connections until it is killed (by a CONTROL-C,
 * for example).  Note that this server processes each connection
 * as it is received, rather than creating a separate thread
 * to process the connection
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            File file = new File("LeaderboardScores.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            String string = in.readLine();
            System.out.println(string);
            fileWriter.write(string);
        } catch (Exception e)
        {e.printStackTrace();}
    }


    public static void main(String[] args) {
        Server server = new Server();
        server.start(5555);
    }

} //end class Server
