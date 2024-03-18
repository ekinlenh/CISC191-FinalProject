package edu.sdccd.cisc191.RockPaperScissors;

import java.util.Random;

public class RPS_NPC_Controller extends RPS_GameScreen{

    /**
     * lets NPC make a move and then checks for a winner
     */
    public void makeNPCMove() {
        Random random = new Random();
        boolean draw = false;
        boolean playerWin = false;

        String[] choices = {"Rock", "Paper", "Scissors"};
        String npcChoice = choices[random.nextInt(3)];

        switch (npcChoice) {
            case "Paper":
                npcRockImg.setOpacity(0.5);
                npcScissorsImg.setOpacity(0.5);
                break;
            case "Scissors":
                npcRockImg.setOpacity(0.5);
                npcPaperImg.setOpacity(0.5);
                break;
            default:
                npcPaperImg.setOpacity(0.5);
                npcScissorsImg.setOpacity(0.5);
                break;
        }

        if (playerChoice.equalsIgnoreCase(npcChoice)) {
            draw = true;
        }

        if ((playerChoice.equals("Rock") && npcChoice.equals("Scissors")) ||
           (playerChoice.equals("Scissors") && npcChoice.equals("Paper")) ||
           (playerChoice.equals("Paper") && npcChoice.equals("Rock"))) {
            playerWin = true;
        }

        if (draw) {
            titleLabel.setText("Draw!");
            playerWins += 0.5;
            npcWins += 0.5;
            updateScoreLabel();
            endGame();
        }
        else if (playerWin) {
            titleLabel.setText("You win!");
            playerWins++;
            updateScoreLabel();
            endGame();
        }
        else {
            titleLabel.setText("You lost!");
            npcWins++;
            updateScoreLabel();
            endGame();
        }
    } //end makeNPCMove()
}
