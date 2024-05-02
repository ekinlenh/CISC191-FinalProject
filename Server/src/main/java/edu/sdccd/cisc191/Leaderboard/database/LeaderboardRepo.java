package edu.sdccd.cisc191.Leaderboard.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaderboardRepo extends CrudRepository<Player, Integer> {

    List<Player> findByName(String playerName);
}