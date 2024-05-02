package edu.sdccd.cisc191.leaderboard;

import edu.sdccd.cisc191.leaderboard.database.LeaderboardRepo;
import edu.sdccd.cisc191.leaderboard.database.Player;
import edu.sdccd.cisc191.leaderboard.services.LeaderboardService;
import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import edu.sdccd.cisc191.leaderboard.sorting.*;
import java.awt.*;
import java.util.*;
import java.util.List;

@SpringBootApplication
public class LeaderboardApplication extends Application {

    public ConfigurableApplicationContext springContext;
    public static List<Player> players;
    private static BinarySearchTree bst = new BinarySearchTree();

    public static VBox readFromLeaderboard() {

        VBox fastestTimesBox = new VBox();
        fastestTimesBox.setLayoutX(483);
        fastestTimesBox.setLayoutY(60);
        fastestTimesBox.setPrefSize(517, 500);
        fastestTimesBox.setStyle("-fx-background-color: #4a6741;");
        fastestTimesBox.setSpacing(10);
        //fastestTimesBox.setPadding(new Insets(10));

        bst = new BinarySearchTree();

        try {

            for(Player player : players) {

                String playerName = player.getPlayerName();
                String playerTime = player.getPlayerTime();

                // add player info to tree
                bst.root = bst.add(bst.root, playerName, playerTime);
            }


            bst.printInorder(bst.root, fastestTimesBox);

            return fastestTimesBox;

                } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void start(Stage stage) {
        LeaderboardService leaderboardService = springContext.getBean(LeaderboardService.class);
    }

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void stop() throws Exception {
        springContext.stop();
    }

    @Override
    public void init() throws Exception {
        springContext  = SpringApplication.run(LeaderboardService.class);

    }

    @Bean
    CommandLineRunner commandLineRunner(LeaderboardRepo player) {
        return args -> {
            Player player1 = new Player(1, "Kaden", "3:23");
            Player player2 = new Player(2, "Ekin", "9:56");
            player.save(player1);
            player.save(player2);

            players = player.findAll();
        };
    }
}