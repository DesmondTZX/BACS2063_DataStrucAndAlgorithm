/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import java.util.Scanner;
import entity.Student;

/**
 *
 * @author Jack
 */
public class TutorGroupManagementUI {

    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("\nTutorial Group Management");
        System.out.println("1. Add new students to tutorial group");
        System.out.println("2. Remove student to tutorial group");
        System.out.println("3. Change tutorial group for student");
        System.out.println("4. Find student in tutorial group");
        System.out.println("5. List all student in tutorial group");
        System.out.println("6. Generate Relevent Reports");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    //input student detail
    public String inputStudentName() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        return studentName;
    }

    public int inputStudentID() {
        System.out.print("Enter student id: ");
        int studentID = scanner.nextInt();
        return studentID;
    }

    public String inputStudentEmail() {
        System.out.print("Enter student email: ");
        String studentEmail = scanner.nextLine();
        return studentEmail;
    }

    public String inputGender() {
        System.out.print("Enter student gender: ");
        String gender = scanner.nextLine();
        return gender;
    }

    public String inputMode() {
        System.out.print("Enter Mode: "); //fulltime or parttime
        String mode = scanner.nextLine();
        return mode;
    }

    public Student inputStudentDetails() {
        System.out.println("\nPlease key in the student details:\n");
        String studentName = inputStudentName();
        int studentID = inputStudentID();
        String studentEmail = inputStudentEmail();
        String gender = inputGender();
        String mode = inputMode();

        System.out.println();
        System.out.println("Student Details");
        System.out.println("Student Name:" + studentName);
        System.out.println("Student ID:" + studentID);
        System.out.println("Student Email:" + studentEmail);
        System.out.println("Student Gender:" + gender);
        System.out.println("Mode:" + mode);
        return new Student(studentName, studentID, studentEmail, mode, gender);
    }

    public int getListChoice() {
        System.out.println("1. Return to main menu");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    public int getAddChoice() {
        System.out.println("1. Return to main menu");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    public int getRemoveChoice() {
        System.out.println("1. Return to main menu");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    public int getChangeChoice() {
        System.out.println("1. Return to main menu");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    public int getFindChoice() {
        System.out.println("1. Return to main menu");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    public int getReportChoice() {
        System.out.println("1. Return to main menu");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

   

}
