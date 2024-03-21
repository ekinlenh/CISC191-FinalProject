package edu.sdccd.cisc191.Scenes;
import edu.sdccd.cisc191.MemoryCard.MemoryCardGameScreen;
import edu.sdccd.cisc191.Riddles.RiddlesGameScreen;
import edu.sdccd.cisc191.BlackJack.BJlogic;
import edu.sdccd.cisc191.CoinFlip.CoinFlipGameScreen;
import edu.sdccd.cisc191.BananaGuessing.BananaGuessingGameScreen;
import edu.sdccd.cisc191.RockPaperScissors.RPS_GameScreen;
import edu.sdccd.cisc191.Scenes.SceneController;
import edu.sdccd.cisc191.TicTacToe.TicTacToeGameScreen;
import edu.sdccd.cisc191.MOT.MOTGameScreen;
import edu.sdccd.cisc191.Wordish.WordishGameScreen;

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
                playNumberGuessing();
                break;
            case "BlackJack":
                playBlackjack();
                break;
            case "RockPaperScissors":
                playRockPaperScissors();
                break;
            case "Wordish":
                playWordle();
                break;
            case "Riddle":
                playRiddles();
                break;
            case "MOT":
                playMOT();
                break;
            //case "MatchingCards":
                //playMatchingCards();
                //break;
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
     * TestGame2 Game
     */
    public void playCoinFlip() {
        CoinFlipGameScreen game = new CoinFlipGameScreen();
        game.createCoinFlipScreen();
    } //end playTestGame2()

    public void playNumberGuessing() {
        BananaGuessingGameScreen game3 = new BananaGuessingGameScreen();
        game3.createBananaGuessScreen();
    } //end playTestGame3()

    public void playBlackjack() {
        BJlogic game4 = new BJlogic();
        game4.createContent();
    }

    public void playRockPaperScissors() {
        RPS_GameScreen game5 = new RPS_GameScreen();
        game5.createRockPaperScissorsScreen();
    }

    public void playWordle() {
        WordishGameScreen game6 = new WordishGameScreen();
        game6.createWordish();
    }

    public void playRiddles() {
        RiddlesGameScreen game7 = new RiddlesGameScreen();
        game7.createRiddleScreen();
    }

    public void playMOT() {
        MOTGameScreen game8 = new MOTGameScreen();
        game8.createMOT();
    }

    public void playMatchingCards() {
        MemoryCardGameScreen game9 = new MemoryCardGameScreen();
        game9.createGameScreen();
    }
}
