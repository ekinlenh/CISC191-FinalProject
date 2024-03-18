package edu.sdccd.cisc191.Scenes;
import edu.sdccd.cisc191.Riddles.RiddlesGameScreen;
import edu.sdccd.cisc191.BlackJack.BJlogic;
import edu.sdccd.cisc191.CoinFlip.CoinFlipGameScreen;
import edu.sdccd.cisc191.BananaGuessing.BananaGuessingGameScreen;
import edu.sdccd.cisc191.RockPaperScissors.RPS_GameScreen;
import edu.sdccd.cisc191.TicTacToe.TicTacToeGameScreen;
import edu.sdccd.cisc191.MOT.MOTGameScreen;
import edu.sdccd.cisc191.Wordish.WordishGameScreen;
import edu.sdccd.cisc191.MemoryCard.MemoryCardGameScreen;


/**
 * The RandomEvent Class
 */
public class RandomEvent extends SceneController {

    /**
     * random # generator to select random event
     */
    public void generateRandomEvent() {

        String eventName = games.get(count);
        switch (eventName) {
            case "TicTacToe":
                playTicTacToe();
                break;
            case "CoinFlip":
                playCoinFlip();
                break;
            case "BananaGuess":
                playBananaGuess();
                break;
            case "BlackJack":
                playBlackjack();
                break;
            case "RockPaperScissors":
                playRockPaperScissors();
                break;
            case "Wordish":
                playWordish();
                break;
            case "Riddle":
                playRiddles();
                break;
            case "MOT":
                playMOT();
                break;
            case "MemoryCard":
                playMemoryCard();
                break;
            default:
                System.out.println("hellloo");
                break;
        }
    } //end generateRandomEvent()

    /**
     * TicTacToe Game
     */
    public void playTicTacToe() {
        TicTacToeGameScreen game = new TicTacToeGameScreen();
        game.createTicTacToe();
    } //end playTicTacToe()

    /**
     * Coin Flip game
     */
    public void playCoinFlip() {
        CoinFlipGameScreen game = new CoinFlipGameScreen();
        game.createCoinFlipScreen();
    } //end playTestGame2()

    /**
     * plays bananaguess game
     */
    public void playBananaGuess() {
        BananaGuessingGameScreen game3 = new BananaGuessingGameScreen();
        game3.createBananaGuessScreen();
    } //end playTestGame3()

    /**
     * BlackJack game
     */
    public void playBlackjack() {
        BJlogic game4 = new BJlogic();
        game4.createContent();
    }

    /**
     * RPS game
     */
    public void playRockPaperScissors() {
        RPS_GameScreen game5 = new RPS_GameScreen();
        game5.createRockPaperScissorsScreen();
    }

    /**
     * WordishGame
     */
    public void playWordish() {
        WordishGameScreen game6 = new WordishGameScreen();
        game6.createWordish();
    }

    /**
     * Riddle game
     */
    public void playRiddles() {
        RiddlesGameScreen game7 = new RiddlesGameScreen();
        game7.createRiddleScreen();
    }

    /**
     * MOT game
     */
    public void playMOT() {
        MOTGameScreen game8 = new MOTGameScreen();
        game8.createMOT();
    }

    /**
     * MemoryCard game
     */
    public void playMemoryCard(){
        MemoryCardGameScreen game9 = new MemoryCardGameScreen();
        game9.createGameScreen();
    }
}
