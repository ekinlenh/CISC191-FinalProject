package edu.sdccd.cisc191.LeaderboardDB.attributes.services;

import com.example.leaderboard.attributes.Player;
import com.example.leaderboard.repos.LeaderboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
