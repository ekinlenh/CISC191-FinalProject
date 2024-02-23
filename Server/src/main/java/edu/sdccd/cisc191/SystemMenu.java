package edu.sdccd.cisc191;
import java.util.*;

/**
 * The SystemMenu Class
 */
public class SystemMenu extends Player {

    protected static Player adventurer = new Player();
    protected Scanner keyboard = new Scanner(System.in);

    /**
     * main screen used for system menu, giving player options to choose from
     */
    public void mainMenu() {

        String cont;

        System.out.println("\nDo you want to open the Main Menu? (Y/N)");
        cont = keyboard.nextLine();

        while (cont.equalsIgnoreCase("Y")) {

            System.out.println("What do you want to do?");
            System.out.println("Explore      Store      Bag      Profile");

            switch (keyboard.nextLine().toUpperCase()) {
                case "EXPLORE":
                    explore();
                    break;
                case "STORE":
                    System.out.println("STORE WORK IN PROGRESS"); //go to store
                    break;
                case "BAG":
                    potionMenu(); //go to bag
                    break;
                case "PROFILE":
                    System.out.println("Welcome " + adventurer.getPlayerName() + ". " + adventurer); //go to profile
                    break;
                default:
                    System.out.println("Sorry, we did not recognize your choice. Please try again.");
                    mainMenu();
                    break;
            }
            System.out.println("\nDo you want to reopen the Main Menu? (Y/N)");
            cont = keyboard.nextLine();
        }
    } //end mainScreen()

    /**
     * starts classCreation for the user
     */
    public void classCreation() {

        //player testing
        String[] classes = {"Warrior", "Tank", "Assassin"};
        System.out.println("To begin your journey, please select your class. " + Arrays.toString(classes));

        switch (keyboard.nextLine().toUpperCase()) {
            case "WARRIOR":
                adventurer = new Player("Warrior", 100, 90, 60);
                System.out.println("Welcome " + adventurer.getPlayerName() + ". " + adventurer);
                nameCreation();
                break;
            case "TANK":
                adventurer = new Player("Tank", 135, 30, 85);
                System.out.println("Welcome " + adventurer.getPlayerName() + ". " + adventurer);
                nameCreation();
                break;
            case "ASSASSIN":
                adventurer = new Player("Assassin", 80, 125, 45);
                System.out.println("Welcome " + adventurer.getPlayerName() + ". " + adventurer);
                nameCreation();
                break;
            default:
                System.out.println("Sorry, we did not recognize your class. Please try again.");
                classCreation();
                break;
        }
    } // end classCreation()

    /**
     * asks player for their name
     */
    public void nameCreation() {

        System.out.println("Is there a name you go by?");
        adventurer.setPlayerName(keyboard.nextLine());

        System.out.println("I see. I wish you the best of luck on your journey, " + adventurer.getPlayerName() + ".\n");

    } // end nameCreation()

    /**
     * potion menu that lets player interact with potions they have
     * can drink/pour potion
     * if player drinks, adds related buffs
     */
    public void potionMenu() {

        String action, type, cont;

        System.out.println("\nDo you want to open the Potion menu? (Y/N)");
        cont = keyboard.nextLine();

        while (cont.equalsIgnoreCase("Y")) {

            System.out.println("What action do want to do to the potion?\n(Drink or Pour)");
            action = keyboard.nextLine();

            System.out.println("What type of potion?\n(Shield or Strength)");
            type = keyboard.nextLine();

            if (action.equalsIgnoreCase("Drink")) { // Checking action
                switch (type.toUpperCase()) {
                    case "SHIELD": // Checking Potion Type
                        System.out.println("You drank a shield potion! Increasing current health and defense...");
                        adventurer.addHealth(25);
                        adventurer.addDefense(25);
                        break;
                    case "STRENGTH": // Checking Potion Type
                        System.out.println("You drank a strength potion! Increasing strength...");
                        adventurer.addStrength(25);
                        break;
                    default: // Checking Potion Type
                        System.out.println("Invalid Potion Type.");
                        break;
                }
                System.out.println("Done! " + adventurer);
            } else if (action.equalsIgnoreCase("Pour")) { // Checking action
                switch (type.toUpperCase()) {
                    case "SHIELD": // Checking Potion Type
                        System.out.println("You poured a shield potion! A blue lily grew in its place.");
                        break;
                    case "STRENGTH": // Checking Potion Type
                        System.out.println("You poured a strength potion! A thorny red rose grew in its place.");
                        break;
                    default: // Checking Potion Type
                        System.out.println("Invalid Potion Type.");
                        break;
                }
            } else { // Checking action
                System.out.println("Invalid Action");
                potionMenu();
            }

            System.out.println("\nDo you want to open the Potion menu again? (Y/N)");
            cont = keyboard.nextLine();
        }
    } // end potion()

    /**
     * one of the options available in the system menu
     */
    public void explore() {
        System.out.println();
        RandomEvent random = new RandomEvent();
    }
} // end class
