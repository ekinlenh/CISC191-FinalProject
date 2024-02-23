package edu.sdccd.cisc191;
import edu.sdccd.cisc191.CoinFlip.CoinFlipGameScreen;
import edu.sdccd.cisc191.TicTacToe.TicTacToeGameScreen;

import java.util.*;

/**
 * The RandomEvent Class
 */
public class RandomEvent extends SceneController {

    /**
     * random # generator to select random event
     */
    public void generateRandomEvent() {

        Random rand = new Random();

        int numOfEvents = 2; // Change this value to how many events there are
        String[] events = new String[numOfEvents]; //Create an array according to how many events there are
        String eventName;

        //assign games
        events[0] = "TicTacToe";
        events[1] = "CoinFlip";
        // events[1] = "TestGame2";

        //betting games
        String[] bettingGames = new String[1];
        bettingGames[0] = "CoinFlip";

        //switch to decide what game to play
        //if selects a betting game, make sure user has enough to bet; or else get new game
        boolean safe;
        do {
            safe = true;
            eventName = events[rand.nextInt(numOfEvents)];
            for (String bettingGame : bettingGames) {
                if (eventName.equalsIgnoreCase(bettingGame)) {
                    if (adventurer.getGold() < 5) {
                        safe = false;
                    }
                }
            }
        }while (!safe);


        switch (eventName) {
            case "TicTacToe":
                playTicTacToe();
                break;
            case "CoinFlip":
                playCoinFlip();
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
}
