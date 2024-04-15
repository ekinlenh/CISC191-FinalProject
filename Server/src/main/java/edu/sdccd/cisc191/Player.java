package edu.sdccd.cisc191;

/**
 * The Player Class
 */
public class Player {
    protected String playerName;
    protected String playerTime;

    /**
     * no arg constructor
     */
    public Player() {
        playerName = "Player";
        playerTime = "00:00";
    } //end no-arg constructor

    /**
     * Constructor
     * @param playerName take in player's name
     * @param playerTime takes in player's time
     */
    public Player(String playerName, String playerTime) {
        this.playerName = playerName;
        this.playerTime = playerTime;
    } //end constructor

    /**
     * sets player name
     * @param playerName takes in player's name
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    } //end setPlayerName()

    /**
     * gets player name
     * @return player's name
     */
    public String getPlayerName() {
        return playerName;
    } //end getPlayerName()

    /**
     * gets player time
     * @return player time
     */
    public String getPlayerTime() {
        return playerTime;
    }

    /**
     * sets player time
     * @param playerTime takes in player time
     */
    public void setPlayerTime(String playerTime) {
        this.playerTime = playerTime;
    }

    /**
     * show player name and time
     * @return player name and time
     */
    public String toString() {
        return playerName + "," + playerTime;
    }
}
