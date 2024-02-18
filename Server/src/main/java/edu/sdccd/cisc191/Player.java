package edu.sdccd.cisc191;

/**
 * The Player Class
 */
public class Player {
    protected String playerName;
    protected int health, strength, defense, gold=10;

    /**
     * no-arg constructor
     */
    public Player() {
        playerName = "Adventurer";
        health = 100;
        strength = 75;
        defense = 75;
    } //end no-arg constructor

    /**
     * Constructor
     * @param playerName take in player's name
     * @param health takes in player's health
     * @param strength takes in player's strength stat
     * @param defense takes in player's defense stat
     */
    public Player(String playerName, int health, int strength, int defense) {
        this.playerName = playerName;
        this.health = health;
        this.strength = strength;
        this.defense = defense;
    } //end constructor

    /**
     * sets player name
     * @param playerName takes in player's name
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    } //end setPlayerName()

    /**
     * gets player name
     * @return player's name
     */
    public String getPlayerName() {
        return playerName;
    } //end getPlayerName()

    /**
     * sets player's health
     * @param health takes in player's health
     */
    public void setHealth(int health) {
        this.health = health;
    } //end setHealth()

    /**
     * adds player's health
     * @param health takes in player's health
     */
    public void addHealth(int health) {
        this.health += health;
    } //end addHealth()

    /**
     * gets player's health
     * @return player's health
     */
    public int getHealth() {
        return health;
    } //end getHealth()

    /**
     * sets player's strength stat
     * @param strength takes in player's strength stat
     */
    public void setStrength(int strength) {
        this.strength = strength;
    } //end setStrength()

    /**
     * adds player's strength stat
     * @param strength takes in player's strength stat
     */
    public void addStrength(int strength) {
        this.strength += strength;
    } //end addStrength()

    /**
     * gets player's strength stat
     * @return player's strength stat
     */
    public int getStrength() {
        return strength;
    } //end getStrength()

    /**
     * sets player's defense stat
     * @param defense takes in player's defense stat
     */
    public void setDefense(int defense) {
        this.defense = defense;
    } //end setDefense()

    /**
     * adds player's defense stat
     * @param defense takes in player's defense stat
     */
    public void addDefense(int defense) {
        this.defense += defense;
    } //end addDefense()

    /**
     * gets player's defense stat
     * @return player's defense stat
     */
    public int getDefense() {
        return defense;
    } //end getDefense()

    /**
     * sets player's gold
     * @param gold takes in player's gold
     */
    public void setGold(int gold) {
        this.gold = gold;
    } //end setGold()

    /**
     * adds player's gold
     * @param gold takes in gold to add
     */
    public void addGold(int gold) {
        this.gold += gold;
    } //end addGold()

    /**
     * subtracts player's gold
     * @param gold takes in gold to subtract
     */
    public void subtractGold(int gold) {
        this.gold -= gold;
    } //end subtractGold()

    /**
     * gets player's gold
     * @return player's gold
     */
    public int getGold() {
        return gold;
    } //end getGold()

    /**
     * Tells current stats of player
     * @return player data
     */
    public String toString() {
        return "These are your current stats: " + getHealth() + " health, " +
                getStrength() + " strength, " + getDefense() + " defense, " + getGold() + " gold.";
    } //end toString()
}
