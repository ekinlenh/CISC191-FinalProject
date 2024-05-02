package edu.sdccd.cisc191.leaderboard.services;

import edu.sdccd.cisc191.leaderboard.database.LeaderboardRepo;
import edu.sdccd.cisc191.leaderboard.database.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LeaderboardService {

    @Autowired
    LeaderboardRepo leaderboardRepo;

    public void save(Player player) {
        leaderboardRepo.save(player);
    }

    public List<Player> findAll() {
        return (List<Player>) leaderboardRepo.findAll();
    }
}
