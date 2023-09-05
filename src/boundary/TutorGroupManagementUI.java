/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import java.util.Scanner;
import entity.Student;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utility.MessageUI;

/**
 *
 * @author Jack
 */
public class TutorGroupManagementUI {

    Scanner scanner = new Scanner(System.in);

    // main choice
    public int getMenuChoice() {
        try {
            System.out.println("\t=========================");
            System.out.println("\tTutorial Group Management");
            System.out.println("\t=========================");
            System.out.println("1. Add new students to tutorial group");
            System.out.println("2. Remove student from tutorial group");
            System.out.println("3. Change tutorial group for student");
            System.out.println("4. Find student in tutorial group");
            System.out.println("5. Display student in tutorial group");
            System.out.println("6. Generate Relevant Reports");
            System.out.println("0. Quit");
            System.out.print("Please Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            MessageUI.displayInvalidChoiceMessage();
            return -1; // Return a sentinel value or handle the error accordingly
        }
    }

    //input student detail
    public int inputStudentID() {
        int studentID;
        while (true) {
            System.out.print("Enter Student ID (between 2300001 till 2399999):  ");
            if (scanner.hasNextInt()) {
                studentID = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                // Add additional validation checks if needed
                // For example, check if studentID is within a specific range
                if (isValidStudentID(studentID)) {
                    break; // Valid input, exit the loop
                } else {
                    System.out.println("Invalid Student ID. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid Student ID.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        return studentID;
    }

    public String inputStudentName() {
        String studentName;
        do {
            System.out.print("Enter Student Name:  ");
            studentName = scanner.nextLine().trim(); // Trim to remove leading/trailing spaces
            if (isValidName(studentName)) {
                return studentName;
            } else {
                System.out.println("Invalid input. Please enter a valid student name.");
            }
        } while (true); // Keep prompting until a valid name is entered
    }

    public String inputStudentEmail() {
        String studentEmail;
        do {
            System.out.print("Enter Student Email:  ");
            studentEmail = scanner.nextLine().trim(); // Trim to remove leading/trailing spaces
            if (isValidEmail(studentEmail)) {
                return studentEmail;
            } else {
                System.out.println("Invalid email format. Please enter a valid email address.");
            }
        } while (true); // Keep prompting until a valid email is entered
    }

    public String inputGender() {
        String gender;
        do {
            System.out.print("Enter Student Gender (Male/Female):  ");
            gender = scanner.nextLine().trim(); // Trim and convert to lowercase
            if (isValidGender(gender)) {
                return gender;
            } else {
                System.out.println("Invalid gender. Please enter 'Male' 'Female'");
            }
        } while (true); // Keep prompting until a valid gender is entered
    }

    public String inputMode() {
        String mode;

        while (true) {
            System.out.print("Enter Mode (FullTime or PartTime): ");
            mode = scanner.nextLine(); // Convert input to lowercase for case-insensitive comparison

            if (mode.equals("FullTime") || mode.equals("PartTime")) {
                break; // Valid input, exit the loop
            } else {
                System.out.println("Invalid mode. Please enter 'FullTime' or 'PartTime'.");
            }
        }

        return mode;
    }

    public Student inputStudentDetails() {
        System.out.println("\nPlease Key In the following Student Details:");

        String studentName = inputStudentName();
        int studentID = inputStudentID();
        String studentEmail = inputStudentEmail();
        String mode = inputMode();
        String gender = inputGender();

        return new Student(studentName, studentID, studentEmail, mode, gender);
    }

    //choices
    public int getGroupChoice() {
        try {
            System.out.println("\nPlease Select The Tutorial Group:");
            System.out.println("1. Group 1");
            System.out.println("2. Group 2");
            System.out.println("3. Group 3");
            System.out.println("4. Group 4");
            System.out.println("5. Group 5");
            System.out.println("99. Return to Main Menu");
            System.out.println("0. Quit");
            System.out.print("Please Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            MessageUI.displayInvalidChoiceMessage();
            return -1; // Return a sentinel value or handle the error accordingly
        }
    }

    public String againChoice() {
        String choice;
        while (true) {
            System.out.print("\nWant to search again? (y/n): ");
            choice = scanner.nextLine().toLowerCase(); // Convert input to lowercase for case-insensitive comparison

            if (choice.equals("y") || choice.equals("n")) {
                break; // Valid input, exit the loop
            } else {
                MessageUI.askAgainMessage();
            }
        }

        return choice;
    }

    public int returnChoice() {
        try {
            System.out.println("\n");
            System.out.println("99. Return to Main Menu");
            System.out.println("0. Quit");
            System.out.print("Please Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            MessageUI.displayInvalidChoiceMessage();
            return -1; // Return a sentinel value or handle the error accordingly
        }
    }

    public int getFindChoice() {
        try {
            System.out.println("\nPlease Select The Type You Want to Find:");
            System.out.println("1. Student ID");
            System.out.println("2. Student Name");
            System.out.println("99. Return to Main Menu");
            System.out.print("Please Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            MessageUI.displayInvalidChoiceMessage();
            return -1; // Return a sentinel value or handle the error accordingly
        }
    }

    public void listAllStudent(String outputStr) {
        System.out.println("""
                           =================
                           List of Students:
                           =================
                           """ + outputStr);
    }

    //change group choice
    public int chgGroup1Choice() {
        try {
            System.out.println("\nPlease Select The Tutorial Group that You want to Move:");
            System.out.println("1. Group 2");
            System.out.println("2. Group 3");
            System.out.println("3. Group 4");
            System.out.println("4. Group 5");
            System.out.println("0. Return Back");
            System.out.print("Please Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            MessageUI.displayInvalidChoiceMessage();
            return -1; // Return a sentinel value or handle the error accordingly
        }
    }

    public int chgGroup2Choice() {
        try {
            System.out.println("\nPlease Select The Tutorial Group that You want to Move:");
            System.out.println("1. Group 1");
            System.out.println("2. Group 3");
            System.out.println("3. Group 4");
            System.out.println("4. Group 5");
            System.out.println("0. Return Back");
            System.out.print("Please Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            MessageUI.displayInvalidChoiceMessage();
            return -1; // Return a sentinel value or handle the error accordingly
        }
    }

    public int chgGroup3Choice() {
        try {
            System.out.println("\nPlease Select The Tutorial Group that You want to Move:");
            System.out.println("1. Group 1");
            System.out.println("2. Group 2");
            System.out.println("3. Group 4");
            System.out.println("4. Group 5");
            System.out.println("0. Return Back");
            System.out.print("Please Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            MessageUI.displayInvalidChoiceMessage();
            return -1; // Return a sentinel value or handle the error accordingly
        }
    }

    public int chgGroup4Choice() {
        try {
            System.out.println("\nPlease Select The Tutorial Group that You want to Move:");
            System.out.println("1. Group 1");
            System.out.println("2. Group 2");
            System.out.println("3. Group 3");
            System.out.println("4. Group 5");
            System.out.println("0. Return Back");
            System.out.print("Please Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            MessageUI.displayInvalidChoiceMessage();
            return -1; // Return a sentinel value or handle the error accordingly
        }
    }

    public int chgGroup5Choice() {
        try {
            System.out.println("\nPlease Select The Tutorial Group that You want to Move:");
            System.out.println("1. Group 1");
            System.out.println("2. Group 2");
            System.out.println("3. Group 3");
            System.out.println("4. Group 4");
            System.out.println("0. Return Back");
            System.out.print("Please Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            MessageUI.displayInvalidChoiceMessage();
            return -1; // Return a sentinel value or handle the error accordingly
        }
    }

    //validation for input
    private boolean isValidName(String name) {
        // You can define your validation rules here
        // For example, you can check if the name contains only letters and spaces
        // You can also set a minimum and maximum length for the name, etc.

        // Here's a simple example that checks if the name is not empty and contains only letters and spaces:
        return !name.isEmpty() && name.matches("^[a-zA-Z\\s]+$");
    }

    private boolean isValidStudentID(int studentID) {
        // Replace these values with your specific validation criteria
        int minID = 2300000;
        int maxID = 2399999;
        return studentID > minID && studentID <= maxID;
    }

    private boolean isValidEmail(String email) {
        // Define a regular expression pattern for a simple email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidGender(String gender) {
        // Define a list of valid gender options
        String[] validGenders = {"Male", "Female"};

        // Check if the entered gender matches one of the valid options (case-insensitive)
        for (String validGender : validGenders) {
            if (gender.equals(validGender)) {
                return true;
            }
        }
        return false;
    }

    //display title
    public void dispFindTitle() {
        System.out.println("============");
        System.out.println("Find Student");
        System.out.println("============");
    }

    public void changeStudTitle() {
        System.out.println("=============================");
        System.out.println("Change Student Tutorial Group");
        System.out.println("=============================");
    }

    public void addTitle() {
        System.out.println("===========");
        System.out.println("Add Student");
        System.out.println("===========");
    }

    public void removeTitle() {
        System.out.println("==============");
        System.out.println("Remove Student");
        System.out.println("==============");
    }

    public void dispTitle() {
        System.out.println("===============");
        System.out.println("Display Student");
        System.out.println("===============");
    }

    public void reportTitle() {
        System.out.println("======");
        System.out.println("Report");
        System.out.println("======");
    }
    
}
