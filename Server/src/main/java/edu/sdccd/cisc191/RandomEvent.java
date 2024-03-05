package edu.sdccd.cisc191;
import edu.sdccd.cisc191.BlackJack.BJlogic;
import edu.sdccd.cisc191.CoinFlip.CoinFlipGameScreen;
import edu.sdccd.cisc191.NumberGuessing.NumberGuessingGameScreen;
import edu.sdccd.cisc191.RockPaperScissors.RPS_GameScreen;
import edu.sdccd.cisc191.TicTacToe.TicTacToeGameScreen;
import edu.sdccd.cisc191.Wordish.WordishGameScreen;
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

        int numOfEvents = 6; // Change this value to how many events there are
        String[] events = new String[numOfEvents]; //Create an array according to how many events there are
        String eventName;

        //assign games
        events[0] = "TicTacToe";
        events[1] = "CoinFlip";
        events[2] = "NumberGuessing";
        events[3] = "BlackJack";
        events[4] = "RockPaperScissors";
        events[5] = "Wordish";
        // events[1] = "TestGame2";

        //betting games
        String[] bettingGames = new String[2];
        bettingGames[0] = "CoinFlip";
        bettingGames[1] = "BlackJack";

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
            case "aTicTacToe":
                playTicTacToe();
                break;
            case "aCoinFlip":
                playCoinFlip();
                break;
            case "aNumberGuessing":
                playNumberGuessing();
                break;
            case "aBlackJack":
                playBlackjack();
                break;
            case "aRockPaperScissors":
                playRockPaperScissors();
                break;
            case "Wordish":
                playWordish();
                break;
            default:
                System.out.println("hellloo");
                playWordish();
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

    public void playBlackjack() {
        BJlogic game4 = new BJlogic();
        game4.createContent();
    }

    public void playRockPaperScissors() {
        RPS_GameScreen game5 = new RPS_GameScreen();
        game5.createRockPaperScissorsScreen();
    }

    public void playWordish() {
        WordishGameScreen game6 = new WordishGameScreen();
        game6.createWordish();
    }
}
