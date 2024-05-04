package edu.sdccd.cisc191.aFinalBossBattle;

public class Item extends FightingStage{

    private String name;
    private String description;
    private int amount;

    /**
     * constructor
     * @param name takes in item name
     * @param description takes in item description
     */
    public Item (String name, String description, int amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    } //end constructor

    /**
     * sets item name
     */
    public void setName() {
        this.name = name;
    } //end setName()

    /**
     * gets item name
     * @return item name
     */
    public String getName() {
        return name;
    } //end getName()

    /**
     * sets item description
     * @param description takes in item description
     */
    public void setDescription(String description) {
        this.description = description;
    } //end setDescription()

    /**
     * gets item description
     * @return item description
     */
    public String getDescription() {
        return description;
    } //end getDescription()

    /**
     * sets item amount
     * @param amount item amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    } //end setAmount()

    /**
     * gets item amount
     * @return item amount
     */
    public int getAmount() {
        return amount;
    } //end getAmount()

    /**
     * use item
     */
    public void useItem() {
            switch (name) {
                case "Banana Bliss":
                    rockyPlayer.setHealth(rockyPlayer.getHealth() + 30);

                    //ensure health doesn't go over cap
                    if (rockyPlayer.getHealth() > 100) {
                        rockyPlayer.setHealth(100);
                    }

                    break;
                case "Banana Elixir":
                    rockyPlayer.setHealth(rockyPlayer.getHealth() + 60);

                    //ensure health doesn't go over cap
                    if (rockyPlayer.getHealth() > 100) {
                        rockyPlayer.setHealth(100);
                    }

                    break;
                case "Mystic Melon":
                    rockyPlayer.setMana(rockyPlayer.getMana() + 10);

                    //ensure mana doesn't go over cap
                    if (rockyPlayer.getMana() > 30) {
                        rockyPlayer.setMana(30);
                    }

                    break;
                default:
                    System.out.println("Error. Item couldn't be used.");
            }
    } //end useItem()
}
