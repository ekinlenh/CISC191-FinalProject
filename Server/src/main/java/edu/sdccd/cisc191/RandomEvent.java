package edu.sdccd.cisc191;
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

        int numOfEvents = 1; // Change this value to how many events there are
        String[] events = new String[numOfEvents]; //Create an array according to how many events there are

        //assign games
        events[0] = "TicTacToe";
        // events[1] = "TestGame2";

        //switch to decide what game to play
        String eventName = events[rand.nextInt(numOfEvents)];
        switch (eventName) {
            case "TicTacToe":
                playTicTacToe();
                break;
            case "TestGame2":
                // another game
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
        TicTacToe game = new TicTacToe();
        System.out.println("Random Event: TicTacToe");
        game.drawBoard();
        game.beginGame();
        System.out.println("Here is your current gold: " + adventurer.getGold());
    } //end playTicTacToe()

    /**
     * TestGame2 Game
     */
    public void playTestGame2() {
        System.out.println("TestGame2"); // temp code
    } //end playTestGame2()
}
