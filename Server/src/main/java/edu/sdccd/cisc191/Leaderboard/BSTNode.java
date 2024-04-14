package edu.sdccd.cisc191.Leaderboard;

public class BSTNode {

    private String playerName;
    private String playerTime ;
    private BSTNode left, right;

    /**
     * constructor
     * @param playerName takes in playerName
     * @param playerTime takes in playerTime
     */
    public BSTNode(String playerName, String playerTime) {
        this.playerName = playerName;
        this.playerTime = playerTime;
        this.right = null;
        this.left = null;
    }

    /**
     * gets player name
     * @return player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * sets player name
     * @param playerName player name
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * gets player time
     * @return player time
     */
    public String getPlayerTime() {
        return playerTime;
    }

    /**
     * sets player time
     * @param playerTime player time
     */
    public void setPlayerTime(String playerTime) {
        this.playerTime = playerTime;
    }

    /**
     * sets left node
     * @param left left node
     */
    public void setLeft(BSTNode left) {
        this.left = left;
    }

    /**
     * gets left node
     * @return left node
     */
    public BSTNode getLeft() {
        return left;
    }

    /**
     * sets right node
     * @param right right node
     */
    public void setRight(BSTNode right) {
        this.right = right;
    }

    /**
     * gets right node
     * @return right node
     */
    public BSTNode getRight() {
        return right;
    }
}
