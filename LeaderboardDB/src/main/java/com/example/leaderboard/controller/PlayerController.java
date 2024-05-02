package com.example.leaderboard.controller;

import com.example.leaderboard.attributes.Player;
import com.example.leaderboard.services.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    @Autowired
    private LeaderboardService playerService;

    @PostMapping("/players")
    public void createPlayer(@RequestBody Player Player) {
        playerService.save(Player);
    }
}
