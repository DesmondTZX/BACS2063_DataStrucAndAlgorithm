import java.util.Scanner;
import control.*;
import static control.TutorGroupManagement.autoGenerate;

/**
 *
 * @author Desmond
 */
public class ClientMainDriver {
    Scanner scanner = new Scanner(System.in);
    
    public int getSystemChoice() {
        int choice;
        while (true) {
            System.out.println("\nUniversity Programme, Tutorial Group, Tutor Management Systems");
            System.out.println("1. Programme Management");
            System.out.println("2. Tutorial Group Management");
            System.out.println("3. Tutor Management");
            System.out.println("0. Quit");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= 3) {
                    break; // Valid choice, exit the loop
                } else {
                    System.out.println("Invalid choice. Please enter a number between 0 and 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }

        scanner.nextLine(); // Consume the newline character
        System.out.println();
        return choice;
    }
    
    public static void main(String[] args) {
        ClientMainDriver client = new ClientMainDriver(); // Create an instance of ClientMainDriver
        int choice = client.getSystemChoice(); // Call getSystemChoice on the instance

        while (choice != 0) {
            switch (choice) {
                case 1 -> {
                    ProgrammeManagement programmeManagement = new ProgrammeManagement();
                    programmeManagement.start();
                }
                case 2 -> {
                    TutorGroupManagement tutGroupManagement = new TutorGroupManagement();
                    autoGenerate(tutGroupManagement);
                    tutGroupManagement.mainMenu();
                }   
                case 3 -> {
                    TutorManagement tutorManagement = new TutorManagement();
                    tutorManagement.runTutorManagement();
                }
                default -> System.out.println("\nInvalid choice");
            }

            choice = client.getSystemChoice(); // Update the choice for the next iteration
        }

        System.out.println("\nExiting program.");
    }
}
