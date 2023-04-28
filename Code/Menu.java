import java.util.*;

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== SIM GAME MENU =====");
            System.out.println("1. Start Game");
            System.out.println("2. Help");
            System.out.println("3. Exit");
            System.out.println("4. View Sim Info");
            System.out.println("5. View Current Location");
            System.out.println("6. View Inventory");
            System.out.println("7. Upgrade House");
            System.out.println("8. Move Room");
            System.out.println("9. Edit Room");
            System.out.println("10. Add Sim");
            System.out.println("11. Change Sim");
            System.out.println("12. List Object");
            System.out.println("13. Go To Object");
            System.out.println("14. Action");

            System.out.print("\nEnter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Starting game...");
                    // code to start the game
                    break;
                case 2:
                    System.out.println("Help information...");
                    // code to display game instructions and help information
                    break;
                case 3:
                    System.out.println("Exiting game...");
                    // code to exit the game
                    break;
                case 4:
                    System.out.println("Viewing Sim info...");
                    // code to display Sim's attributes
                    break;
                case 5:
                    System.out.println("Viewing current location...");
                    // code to display Sim's current location
                    break;
                case 6:
                    System.out.println("Viewing inventory...");
                    // code to display Sim's inventory
                    break;
                case 7:
                    System.out.println("Upgrading house...");
                    // code to upgrade Sim's house
                    break;
                case 8:
                    System.out.println("Moving room...");
                    // code to move to another room in the Sim's house
                    break;
                case 9:
                    System.out.println("Editing room...");
                    // code to buy new objects for the room or move objects around
                    break;
                case 10:
                    System.out.println("Adding new Sim...");
                    // code to add a new Sim to the game
                    break;
                case 11:
                    System.out.println("Changing Sim...");
                    // code to switch to a different Sim being played
                    break;
                case 12:
                    System.out.println("Listing objects...");
                    // code to list objects in the current room
                    break;
                case 13:
                    System.out.println("Going to object...");
                    // code to move to a specific object in the room
                    break;
                case 14:
                    System.out.println("Performing an action...");
                    // code to perform an action on an object in the room
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid menu option.");
                    break;
            }

        } while (choice != 3);
    }
}

