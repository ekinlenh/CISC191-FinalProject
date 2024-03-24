package edu.sdccd.cisc191;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Module4Test {

    Player player = new Player();

    /**
     * tests to make sure player name is set
     */
    @Test
    public void testGetName() {
        player.setPlayerName("Rocky");
        assertEquals("Rocky", player.getPlayerName());
    } //end testGetName

    /**
     * tests to see if player health is set
     */
    @Test
    public void testGetHealth() {
        player.setHealth(100);
        assertEquals(100, player.getHealth());
    } //end testGetHealth()

    /**
     * tests to see if player health can be lowered
     */
    @Test
    public void testRemoveHealth() {
        player.subtractHealth(10);
        assertEquals(90, player.getHealth());
    } //end testRemoveHealth()
}
