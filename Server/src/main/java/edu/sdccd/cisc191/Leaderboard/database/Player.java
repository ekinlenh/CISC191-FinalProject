package edu.sdccd.cisc191.Leaderboard.database;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(schema = "public", name="players")
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "playerName", nullable = false)
    private String playerName;

    @Column(name = "playerTime", nullable = false)
    private String playerTime;

    public Player() {
    }

    public Player(Integer id, String playerName, String playerTime) {
        this.id = id;
        this.playerName = playerName;
        this.playerTime = playerTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerTime() {
        return playerTime;
    }

    public void setPlayerTime(String playerTime) {
        this.playerTime = playerTime;
    }

    @Override
    public String toString() {
        return "Player{" +
            "id=" + id +    
            "playerName='" + playerName + '\'' +
                ", playerTime='" + playerTime + '\'' +
                '}';
    }
}