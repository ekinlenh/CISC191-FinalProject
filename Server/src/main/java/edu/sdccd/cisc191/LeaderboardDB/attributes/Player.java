package edu.sdccd.cisc191.LeaderboardDB.attributes;

@Entity
@Table(name="players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String playerName;
    private String playerTime;

    public Player() {
    }

    public Player(String playerName, String playerTime) {
        this.playerName = playerName;
        this.playerTime = playerTime;
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
        return "H2Player{" +
                "playerName='" + playerName + '\'' +
                ", playerTime='" + playerTime + '\'' +
                '}';
    }
}
