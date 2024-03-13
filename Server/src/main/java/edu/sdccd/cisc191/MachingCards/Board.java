package edu.sdccd.cisc191.MachingCards;

import java.util.*;

public class Board {
    private int rows;
    private int cols;
    private Card[][] cards;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cards = new Card[rows][cols];
        initializeBoard();
    }

    private List<Character> generateSymbols() {
        List<Character> symbols = new ArrayList<>();
        char symbol = 'A';
        int pairs = (rows * cols) / 2;
        for (int i = 0; i < pairs; i++) {
            symbols.add(symbol);
            symbol++;
        }
        return symbols;
    }

    public void startGame() {
        // Implement the game logic here
        System.out.println("Welcome to Memory Card Game!");
    }

    private void initializeBoard() {
        char symbol = 'A'; // Starting symbol
        List<Character> symbols = new ArrayList<>();
        for (int i = 0; i < (rows * cols) / 2; i++) {
            symbols.add(symbol);
            symbols.add(symbol);
            symbol++;
        }
        Collections.shuffle(symbols);
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cards[i][j] = new Card(symbols.get(index++));
            }
        }
    }
}
