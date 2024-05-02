package com.example.leaderboard;

import com.example.leaderboard.attributes.Player;
import com.example.leaderboard.services.LeaderboardService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

@SpringBootApplication
public class LeaderboardApplication extends Application {

    public ConfigurableApplicationContext springContext;

    public static void main(String[] args) {
        launch(LeaderboardApplication.class, args);
        //SpringApplication.run(LeaderboardApplication.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        LeaderboardService leaderboardService = springContext.getBean(LeaderboardService.class);
        stage.setTitle("LeaderBoardSort");
        VBox root = new VBox();

        for (Player player: leaderboardService.findAll()) {
            Button btn = new Button();
            btn.setText(player.getPlayerName());
            btn.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("LeaderBoardSort");

            });
            root.getChildren().add(btn);
        }

        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        springContext.stop();
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(LeaderboardApplication.class);

        LeaderboardService leaderboardService = springContext.getBean(LeaderboardService.class);

        Player kaden = new Player("Kaden", "3:23");
        leaderboardService.save(kaden);

        List<Player> players = new ArrayList<>();
        players.add(kaden);

        for (Player player : players) {
            System.out.println(player.toString());
        }

    }

    public Server inMemoryDBServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "3306");
    }
}
