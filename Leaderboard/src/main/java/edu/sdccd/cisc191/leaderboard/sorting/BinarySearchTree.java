package edu.sdccd.cisc191.leaderboard.sorting;

import javafx.scene.layout.VBox;

public class BinarySearchTree {

    public BSTNode root;
    private int count = 0;

    public BinarySearchTree() {
        root = null;
    }

    public BSTNode add(BSTNode current, String playerName, String playerTime) {
        if (current == null) {
            return new BSTNode(playerName, playerTime);
        }

        if (playerTime.compareTo(current.getPlayerTime()) < 0) {
            current.setLeft(add(current.getLeft(), playerName, playerTime));
        } else if (playerTime.compareTo(current.getPlayerTime()) >= 0) {
            current.setRight(add(current.getRight(), playerName, playerTime));
        } else {
            return current;
        }
        return current;
    }

    public void printInorder(BSTNode node, VBox leaderboard) {
        if (node == null)
            return;

        //traverses left
        printInorder(node.getLeft(), leaderboard);

        //prints time to console
        //System.out.println(node.getPlayerName() + " -> " + node.getPlayerTime());

        //prints to leaderboard
        if (count < 10) {
            leaderboard.getChildren().add(new GameLabel(node.getPlayerName() + "\t\t\t\t\t" + node.getPlayerTime(), 517, 50, 24));
            count++;
        }

        //traverses right
        printInorder(node.getRight(), leaderboard);
    }

    public BSTNode searchPlayer(BSTNode current, String playerName) {
        if (current == null) {
            return current;
        }

        if (playerName.equals(current.getPlayerName())) {
            return current;
        }

        if (playerName.compareTo(current.getPlayerName()) < 0) {
            return searchPlayer(current.getLeft(), playerName);
        }

        return searchPlayer(current.getRight(), playerName);
    }

    public void printPlayer(BSTNode playerNode) {
        if (playerNode == null) {
            System.out.println("Player not found.");
        } else {
            System.out.println("Player found: " + playerNode.getPlayerName() + " -> " + playerNode.getPlayerTime());
        }
    }
}
