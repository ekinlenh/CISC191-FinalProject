package edu.sdccd.cisc191.Scenes;
import edu.sdccd.cisc191.MemoryCard.MemoryCardGameScreen;
import edu.sdccd.cisc191.Riddles.RiddlesGameScreen;
import edu.sdccd.cisc191.BlackJack.BJlogic;
import edu.sdccd.cisc191.CoinFlip.CoinFlipGameScreen;
import edu.sdccd.cisc191.BananaGuessing.BananaGuessingGameScreen;
import edu.sdccd.cisc191.RockPaperScissors.RPS_GameScreen;
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
            case "TicTacToet":
                playTicTacToe();
                break;
            case "CoinFlipt":
                playCoinFlip();
                break;
            case "BananaGuessingt":
                playNumberGuessing();
                break;
            case "BlackJackt":
                playBlackjack();
                break;
            case "RockPaperScissorst":
                playRockPaperScissors();
                break;
            case "Wordisht":
                playWordle();
                break;
            case "Riddlet":
                playRiddles();
                break;
            case "UNOt":
                playUNO();
                break;
            case "MemoryCards":
                playMemoryCard();
                break;
            default:
                playMemoryCard();
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

    public void playUNO() {
        MOTGameScreen game8 = new MOTGameScreen();
        game8.createMOT();
    }

    public void playMemoryCard(){
        MemoryCardGameScreen game9 = new MemoryCardGameScreen();
        game9.createMemoryCard();
    }


}
