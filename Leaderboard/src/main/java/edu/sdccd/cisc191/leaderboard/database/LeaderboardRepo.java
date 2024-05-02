package edu.sdccd.cisc191.leaderboard.database;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface LeaderboardRepo extends JpaRepository<Player, Integer> {

    List<Player> findByName(String playerName);
}