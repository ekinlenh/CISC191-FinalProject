package com.example.leaderboard.repos;

import com.example.leaderboard.attributes.Player;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface LeaderboardRepo extends CrudRepository<Player, String> {

    List<Player> findByName(String name);
}
