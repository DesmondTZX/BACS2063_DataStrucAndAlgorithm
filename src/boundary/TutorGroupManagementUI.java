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
        System.out.println("===========================");
        System.out.println("\nTutorial Group Management");
        System.out.println("===========================");
        System.out.println("1. Add new students to tutorial group");
        System.out.println("2. Remove student from tutorial group");
        System.out.println("3. Change tutorial group for student");
        System.out.println("4. Find student in tutorial group");
        System.out.println("5. Display student in tutorial group");
        System.out.println("6. Generate Relevent Reports");
        System.out.println("0. Quit");
        System.out.print("Please Enter Your Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    public int inputStudentID() {
        System.out.print("Enter Student ID:  ");
        int studentID = scanner.nextInt();
        scanner.nextLine();
        return studentID;
    }

    //input student detail
    public String inputStudentName() {

        System.out.print("Enter Student Name:  ");
        String studentName = scanner.nextLine();
        return studentName;
    }

    public String inputStudentEmail() {
        System.out.print("Enter Student Email:  ");
        String studentEmail = scanner.nextLine();
        return studentEmail;
    }

    public String inputGender() {
        System.out.print("Enter Student Gender:  ");
        String gender = scanner.nextLine();
        return gender;
    }

    public String inputMode() {
        System.out.print("Enter Mode:  "); //fulltime or parttime
        String mode = scanner.nextLine();
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

    public int getGroupChoice() {
        System.out.println("\nPlease Select The Tutorial Group:");
        System.out.println("1. Group 1");
        System.out.println("2. Group 2");
        System.out.println("99. Return to Main Menu");
        System.out.println("0. Quit");
        System.out.print("Please Enter Your Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    public String againChoice() {
        System.out.print("\nWant search again?:");
        String choice = scanner.nextLine();
        System.out.println();
        return choice;
    }

    public int returnChoice() {
        System.out.println("99. Return to Main Menu");
        System.out.println("0. Quit");
        System.out.print("Please Enter Your Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    public void listAllStudent(String outputStr) {
        System.out.println("\nList of Students:\n" +
                           "=================\n" + outputStr);
    }

    

}
