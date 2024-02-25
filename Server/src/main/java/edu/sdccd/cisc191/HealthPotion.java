package edu.sdccd.cisc191;

public class HealthPotion implements Items {
    private final String name;
    private final int price;

    private final int healingAmount;

    /**
     * health potion that player can buy and use
     * @param name takes in health potion's name
     * @param price takes in health potion's price
     * @param healingAmount takes in how much potion heals
     */
    public HealthPotion(String name, int price, int healingAmount) {
        this.name = name;
        this.price = price;
        this.healingAmount = healingAmount;
    }

    /**
     * gets item's name
     * @return item's name
     */
    @Override
    public String getItemName() {
        return name;
    } //end getItemName()

    /**
     * get item's price
     * @return item's price
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * use item on player
     * @param player takes in player
     */
    @Override
    public void use(Player player) {
        player.addHealth(healingAmount);
    } //end use()
}
