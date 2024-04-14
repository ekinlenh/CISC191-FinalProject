package edu.sdccd.cisc191;

public class BinarySearchTree {

    private BSTNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(BSTNode root) {
        this.root = root;
    }

    public void processLine(String[] array) {

        String playerName = array[0];
        String playerTime = array[1];

        root = add(root, playerName, playerTime);
    }

    public BSTNode add(BSTNode current, String playerName, String playerTime) {
        if (current == null) {
            return new BSTNode(playerName, playerTime);
        }

        if (playerTime.compareTo(current.getPlayerTime()) > 0) {
            current.setLeft(add(current.getLeft(), playerName, playerTime));
        } else if (playerTime.compareTo(current.getPlayerTime()) < 0) {
            current.setRight(add(current.getRight(), playerName, playerTime));
        } else {
            return current;
        }
        return current;
    }
}
