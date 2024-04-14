package edu.sdccd.cisc191;

public class BSTNode {

    private String playerName;
    private String playerTime ;
    private BSTNode left, right;

    public BSTNode(String playerName, String playerTime) {
        this.playerName = playerName;
        this.playerTime = playerTime;
        this.right = null;
        this.left = null;
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

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public BSTNode getRight() {
        return right;
    }
}
