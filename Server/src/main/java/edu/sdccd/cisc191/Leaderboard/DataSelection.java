package edu.sdccd.cisc191.Leaderboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DataSelection {

    public static ArrayList<String> readFromDB() {

        Connection c = null;
        Statement stmt = null;
        ArrayList<String> rows = null;

        try {
            //Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("monkey-leaderboard.cdtsluumhev4.us-east-1.rds.amazonaws.com","postgres", "masterpassword");
            //c.setAutoCommit(false);

            System.out.println("Successfully Connected.");

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery( "select * from public.\"leaderboard\" ;" );

            while ( rs.next() ) {

                String name = rs.getString("name");
                String time = rs.getString("time");
                String row = name + ", " + time;

                rows.add(row);
            }

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println(" Data Retrieved Successfully ..");
        return rows;
    }
}