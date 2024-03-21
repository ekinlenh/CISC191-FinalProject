package edu.sdccd.cisc191.RockPaperScissors;

import java.util.Random;

public class RPS_NPC_Controller extends RPS_GameScreen{

    private static boolean draw = false;
    private static boolean playerWin = false;

    /**
     * lets NPC make a move and then checks for a winner
     */
    public void makeNPCMove() {
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};
        String npcChoice = choices[random.nextInt(3)];

        switch (npcChoice) {
            case "Rock":
                npcPaperImg.setOpacity(0.5);
                npcScissorsImg.setOpacity(0.5);
                break;
            case "Paper":
                npcRockImg.setOpacity(0.5);
                npcScissorsImg.setOpacity(0.5);
                break;
            case "Scissors":
                npcRockImg.setOpacity(0.5);
                npcPaperImg.setOpacity(0.5);
                break;
            default:
                System.out.println("code broke!!");
                break;
        }
        checkWinner(npcChoice);
    } //end makeNPCMove()

    /**
     * checks who won
     */
    private void checkWinner(String npc) {

        if ((playerChoice.equals("Rock") && npc.equals("Scissors")) ||
                (playerChoice.equals("Scissors") && npc.equals("Paper")) ||
                (playerChoice.equals("Paper") && npc.equals("Rock"))) {
            playerWin = true;
        } else if (playerChoice.equals(npc)) {
            draw = true;
        }

        if (draw) {
            titleLabel.setText("Draw!");
            playerWins += 0.5;
            npcWins += 0.5;
            updateScoreLabel();
            endGame();
        } else if (playerWin) {
            titleLabel.setText("You win!");
            playerWins++;
            updateScoreLabel();
            endGame();
        } else {
            titleLabel.setText("You lost!");
            npcWins++;
            updateScoreLabel();
            endGame();
        }
        draw = false;
        playerWin = false;
    } //end checkWinner()
}
