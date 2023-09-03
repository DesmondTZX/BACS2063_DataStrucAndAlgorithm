/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author Jack
 */
public class MessageUI {
    public static void displayInvalidChoiceMessage() {
        printFormattedText("\nInvalid choice\n", ConsoleColor.RED);
    }

    public static void displayExitMessage() {
        printFormattedText("\nExiting system...\n", ConsoleColor.GREEN);

    }

    public static void askConfirmationMessage(String val) {
        printFormattedText("Are you sure to " + val + " it?(1 is Yes and 0 is No): ", ConsoleColor.BRIGHTBLUE);
    }

    public static void displaySuccessConfirmationMessage(String val) {
        printFormattedText(val + " Successfully!\n", ConsoleColor.GREEN);
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
