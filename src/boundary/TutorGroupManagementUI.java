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
        System.out.println("\nPlease key in the student details:");
        String studentName = inputStudentName();
        int studentID = inputStudentID();
        String studentEmail = inputStudentEmail();
        String mode = inputMode();
        String gender = inputGender();

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

    
    public void listAllStudent(String outputStr){
        System.out.println("\nList of Students:\n" + outputStr);
    }
    
    
    public void printStudentDetails(Student student){
      System.out.println("Student Details");
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Student ID: " + student.getStudentID());
        System.out.println("Student Email: " + student.getStudentEmail());
        System.out.println("Mode: " + student.getMode());
        System.out.println("Student Gender: " + student.getGender());
    }


}
