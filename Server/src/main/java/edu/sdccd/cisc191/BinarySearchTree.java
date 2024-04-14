package edu.sdccd.cisc191;

public class BinarySearchTree {

    BSTNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BSTNode add(BSTNode current, String playerName, String playerTime) {
        if (current == null) {
            return new BSTNode(playerName, playerTime);
        }

        if (playerTime.compareTo(current.getPlayerTime()) < 0) {
            current.setLeft(add(current.getLeft(), playerName, playerTime));
        } else if (playerTime.compareTo(current.getPlayerTime()) > 0) {
            current.setRight(add(current.getRight(), playerName, playerTime));
        } else {
            return current;
        }
        return current;
    }

    public void printInorder(BSTNode node)
    {
        if (node == null)
            return;

        printInorder(node.getLeft());
        System.out.println(node.getPlayerName() + " -> " + node.getPlayerTime());
        printInorder(node.getRight());
    }
}
