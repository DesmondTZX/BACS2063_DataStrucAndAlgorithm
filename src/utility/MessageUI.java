/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author Dong Wei Jie
 */
public class MessageUI {
    public static void displayInvalidChoiceMessage() {
        printFormattedText("Invalid choice!! Please Try Again!!\n", ConsoleColor.RED);
    }

    public static void displayExitMessage() {
        printFormattedText("\tExiting system...\n", ConsoleColor.GREEN);

    }

    public static void askAgainMessage() {
        printFormattedText("Invalid choice. Please enter 'y' for Yes or 'n' for No.", ConsoleColor.RED);
    }


    public static void displaySuccessConfirmationMessage(String val) {
        printFormattedText(val + " Successfully!!\n", ConsoleColor.GREEN);
    }
    
    public static void displaySuccessConfirmation() {
        printFormattedText("Successfully!!\n", ConsoleColor.GREEN);
    }

    public static void displayInvalidFormat() {
        printFormattedText("Your input is not in correct format: ", ConsoleColor.YELLOW);
    }
    
    public static void displayNotFound() {
        printFormattedText("Cannot Found This Student!! Please Try Again!!: ", ConsoleColor.RED);
    }

    public static void printFormattedText(String text, ConsoleColor color) {
        System.out.print(color + text + ConsoleColor.RESET);
    }
}
