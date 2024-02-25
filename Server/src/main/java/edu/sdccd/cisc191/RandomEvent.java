package edu.sdccd.cisc191;
import edu.sdccd.cisc191.CoinFlip.CoinFlipGameScreen;
import edu.sdccd.cisc191.NumberGuessing.NumberGuessingGameScreen;
import edu.sdccd.cisc191.TicTacToe.TicTacToeGameScreen;

import java.util.*;

/**
 * The RandomEvent Class
 */
public class RandomEvent extends SystemMenu {

    /**
     * Asks user a random event
     */
    public void askRandomEvent() {
        System.out.println("A random event has popped up!");
        System.out.println("If you clear this then you get rewards!");
        System.out.println("But if you fail, then you will get punished...");
        System.out.println("Will you take the chance? (Y/N)");

        if (keyboard.next().equalsIgnoreCase("Y")) {
            System.out.println("A random event has been chosen!");
            generateRandomEvent();
        }
        else {
            System.out.println("Ah, feeling unlucky today, I see.");
        }
    } //end askRandomEvent()

    /**
     * random # generator to select random event
     */
    public void generateRandomEvent() {

        Random rand = new Random();

        int numOfEvents = 3; // Change this value to how many events there are
        String[] events = new String[numOfEvents]; //Create an array according to how many events there are

        //assign games
        events[0] = "TicTacToe";
        events[1] = "CoinFlip";
        events[2] = "NumberGuessing";
        // events[1] = "TestGame2";

        //switch to decide what game to play
        String eventName = events[rand.nextInt(numOfEvents)];
        switch (eventName) {
            case "TicTacToe":
                playTicTacToe();
                break;
            case "CoinFlip":
                playCoinFlip();
                break;
            case "NumberGuessing":
                playNumberGuessing();
                break;
            default:
                System.out.println("ur code brokee");
                break;
        }
    } //end generateRandomEvent()

    /**
     * responds when player wins the random event
     */
    public void winGame() {
        System.out.println("Congratulations! " + adventurer.getPlayerName() + ", you won!");
        System.out.println("As your reward, you have acquired 5 gold.");
        adventurer.addGold(5);
    }

    /**
     * responds when player loses the random event
     */
    public void loseGame() {
        System.out.println("Ouch! Better luck next time.");
        System.out.println("As you lost, you pay the opponent 5 gold.");
        adventurer.subtractGold(5);
    } //end loseGame()

    /**
     * TicTacToe Game
     */
    public void playTicTacToe() {
        TicTacToeGameScreen game = new TicTacToeGameScreen();
        game.createTicTacToe();
    } //end playTicTacToe()

    /**
     * TestGame2 Game
     */
    public void playCoinFlip() {
        CoinFlipGameScreen game = new CoinFlipGameScreen();
        game.createCoinFlipScreen();
    } //end playTestGame2()

    public void playNumberGuessing() {
        NumberGuessingGameScreen game3 = new NumberGuessingGameScreen();
        game3.createNumberGuessingScreen();
    } //end playTestGame3()
}
