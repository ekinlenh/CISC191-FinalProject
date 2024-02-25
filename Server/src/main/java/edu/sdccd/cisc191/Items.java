package edu.sdccd.cisc191;

public interface Items {

    /**
     * gets item's name
     * @return item's name
     */
    String getItemName();

    /**
     * get item's price
     * @return item's price
     */
    public int getPrice();

    /**
     * use item on player
     * @param player takes in player
     */
    void use(Player player);
}
