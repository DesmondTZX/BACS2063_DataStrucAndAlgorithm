/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import adt.*;
import boundary.*;
import dao.*;
import entity.Student;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Scanner;
import utility.*;

/**
 *
 * @author Jack
 */
public class TutorGroupManagement {

    private final TutorGroupManagementUI tutGroupUI = new TutorGroupManagementUI();
    private final StudentDAO g1DAO = new StudentDAO("Group1.dat");
    private final StudentDAO g2DAO = new StudentDAO("Group2.dat");
    private SortedListInterface<Student> g1List = new SortedLinkedList<>();
    private SortedListInterface<Student> g2List = new SortedLinkedList<>();

    public TutorGroupManagement() {
        g1List = g1DAO.retrieveFromFile();
        g2List = g2DAO.retrieveFromFile();
    }

    public void mainMenu() {
        int choice = 0;
        do {
            choice = tutGroupUI.getMenuChoice();
            switch (choice) {
                case 0 -> {
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                }
                case 1 -> {
                    cls();
                    addNewStudent();
                    break;
                }
                case 2 -> {
                    cls();
                    removeStudent();
                    break;
                }
                case 3 -> {
                    cls();
                    changeStudentTutGroup();
                    break;
                }
                case 4 -> {
                    cls();
                    findStudent();
                    break;
                }
                case 5 -> {
                    cls();
                    dispStudent();
                    break;
                }
                case 6 -> {
                    cls();
                    generateReport();
                    break;
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();

                }

            }
        } while (choice != 0);

    }

    public void addNewStudent() {
        int gpChoice = 0;
        do {
            tutGroupUI.addTitle();
            gpChoice = tutGroupUI.getGroupChoice();
            switch (gpChoice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                }
                case 1 -> {
                    cls();
                    tutGroupUI.addTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG1()); //display all the studentList IN G1
                    Student newStud = tutGroupUI.inputStudentDetails();
                    g1List.add(newStud);
                    g1DAO.saveToFile(g1List);
                    break;
                }
                case 2 -> {
                    cls();
                    tutGroupUI.addTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG2()); //display all the studentList IN G1
                    Student newStud = tutGroupUI.inputStudentDetails();
                    g2List.add(newStud);
                    g2DAO.saveToFile(g2List);
                    break;
                }
                case 99 -> {
                    cls();
                    mainMenu();
                    break;
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (gpChoice != 0);

        int choice = 0;
        do {
            choice = tutGroupUI.returnChoice();
            switch (choice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                }
                case 99 -> {
                    cls();
                    mainMenu();
                    break;
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (choice != 0);
    }

    public void removeStudent() {
        int gpChoice = 0;
        do {
            tutGroupUI.removeTitle();
            gpChoice = tutGroupUI.getGroupChoice();
            switch (gpChoice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                }
                case 1 -> {
                    cls();
                    tutGroupUI.listAllStudent(getAllStudentsG1()); //display all the studentList IN G1
                    tutGroupUI.removeTitle();
                    Student delStud = new Student(tutGroupUI.inputStudentID());
                    g1List.remove(delStud);
                    g1DAO.saveToFile(g1List);
                    break;
                }
                case 2 -> {
                    cls();
                    tutGroupUI.listAllStudent(getAllStudentsG2()); //display all the studentList IN G2
                    tutGroupUI.removeTitle();
                    Student delStud = new Student(tutGroupUI.inputStudentID());
                    g2List.remove(delStud);
                    g2DAO.saveToFile(g2List);
                    break;
                }
                case 99 -> {
                    cls();
                    mainMenu();
                    break;
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (gpChoice != 0);

        int choice = 0;
        do {
            choice = tutGroupUI.returnChoice();
            switch (choice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                }
                case 99 -> {
                    cls();
                    mainMenu();
                    break;
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (choice != 0);
    }

    public void changeStudentTutGroup() {
        int gpChoice = 0;
        do {
            tutGroupUI.changeStudTitle();
            gpChoice = tutGroupUI.getGroupChoice();
            switch (gpChoice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                }
                case 1 -> {
                    cls();
                    tutGroupUI.changeStudTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG1()); //display all the studentList IN G1
                    int studentIDToChange = tutGroupUI.inputStudentID();
                    Student foundStudent = null;

                    // Convert g1List to a List
                    Iterator<Student> g1ListAsIterator = g1List.getIterator();

                    changeG1toG2(g1ListAsIterator, studentIDToChange, foundStudent);
                    break;
                }
                case 2 -> {
                    cls();
                    tutGroupUI.changeStudTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG2()); //display all the studentList IN G1
                    int studentIDToChange = tutGroupUI.inputStudentID();
                    Student foundStudent = null;

                    // Convert g1List to a List
                    Iterator<Student> g2ListAsIterator = g2List.getIterator();

                    changeG2toG1(g2ListAsIterator, studentIDToChange, foundStudent);
                    break;
                }
                case 99 -> {
                    cls();
                    mainMenu();
                    break;
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (gpChoice != 0);
        int choice = 0;
        do {
            choice = tutGroupUI.returnChoice();
            switch (choice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                }
                case 99 -> {
                    cls();
                    mainMenu();
                    break;
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (choice != 0);
    }

    public void findStudent() {
        do {
            tutGroupUI.dispFindTitle();

            int choice = 0;
            choice = tutGroupUI.getFindChoice();
            switch (choice) {
                case 1 -> {
                    cls();
                    int studentIDToFind = tutGroupUI.inputStudentID();
                    Student foundStudent = null;
                    // Convert g1&g2List to a iterator
                    Iterator<Student> g1ListAsIterator = g1List.getIterator();
                    Iterator<Student> g2ListAsIterator = g2List.getIterator();
                    dispFoundStud(g1ListAsIterator, g2ListAsIterator, studentIDToFind, foundStudent);
                    break;
                }
                case 2 -> {
                    cls();
                    String studentNameToFind = tutGroupUI.inputStudentName();
                    Student foundStudent = null;
                    // Convert g1&g2List to a iterator
                    Iterator<Student> g1ListAsIterator = g1List.getIterator();
                    Iterator<Student> g2ListAsIterator = g2List.getIterator();
                    dispFoundStud(g1ListAsIterator, g2ListAsIterator, studentNameToFind, foundStudent);
                    break;
                }
                case 99 -> {
                    cls();
                    mainMenu();
                    break;
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }

        } while ("y".equals(tutGroupUI.againChoice()));

        int choice = 0;
        do {
            choice = tutGroupUI.returnChoice();
            switch (choice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                }
                case 99 -> {
                    cls();
                    mainMenu();
                    break;
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (choice != 0);
    }

    public void dispStudent() {
        int gpChoice = 0;
        do {
            tutGroupUI.dispTitle();
            gpChoice = tutGroupUI.getGroupChoice();
            switch (gpChoice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                }
                case 1 -> {
                    cls();
                    tutGroupUI.dispTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG1()); //display all the studentList IN G1
                    break;
                }
                case 2 -> {
                    cls();
                    tutGroupUI.dispTitle();

                    tutGroupUI.listAllStudent(getAllStudentsG2()); //display all the studentList IN G1 
                    break;
                }
                case 99 -> {
                    cls();
                    mainMenu();
                    break;
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (gpChoice != 0);

        int choice = 0;
        do {
            choice = tutGroupUI.returnChoice();
            switch (choice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                }
                case 1 -> {
                    cls();
                    mainMenu();
                    break;
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (choice != 0);
    }

    public void generateReport() {
        int gpChoice = 0;
        do {
            tutGroupUI.reportTitle();
            gpChoice = tutGroupUI.getGroupChoice();
            switch (gpChoice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                }
                case 1 -> {
                    cls();
                    tutGroupUI.reportTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG1()); //display all the studentList IN G1 
                    System.out.println("\nTotal Students: " + g1List.getNumberOfEntries() + " students ");

                    break;
                }
                case 2 -> {
                    cls();
                    tutGroupUI.reportTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG2()); //display all the studentList IN G2
                    System.out.println("\nTotal Students: " + g2List.getNumberOfEntries() + " students ");
                    break;
                }
                case 99 -> {
                    cls();
                    mainMenu();
                    break;
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (gpChoice != 0);

        int choice = 0;
        do {
            choice = tutGroupUI.returnChoice();
            switch (choice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                }
                case 99 -> {
                    cls();
                    mainMenu();
                    break;
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (choice != 0);

    }

    public String getAllStudentsG1() {
        String outputStr = "";
        Iterator<Student> g1StudIterator = g1List.getIterator();
        while (g1StudIterator.hasNext()) {
            Student stud = g1StudIterator.next();
            outputStr += stud + "\n";
        }

        return outputStr;
    }

    public String getAllStudentsG2() {
        String outputStr = "";
        Iterator<Student> g2StudIterator = g2List.getIterator();
        while (g2StudIterator.hasNext()) {
            Student stud = g2StudIterator.next();
            outputStr += stud + "\n";
        }

        return outputStr;
    }

    //clear screen
    public final static void cls() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
        }
    }

    //display founded student via id
    public void dispFoundStud(Iterator<Student> g1ListAsIterator, Iterator<Student> g2ListAsIterator, int studentIDToFind, Student foundStudent) {
        while (g1ListAsIterator.hasNext()) {
            Student student = g1ListAsIterator.next();
            if (student.getStudentID() == studentIDToFind) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent == null) {
            // Convert g2List to a List

            while (g2ListAsIterator.hasNext()) {
                Student student = g2ListAsIterator.next();
                if (student.getStudentID() == studentIDToFind) {
                    foundStudent = student;
                    break;
                }
            }
        }

        if (foundStudent != null) {
            System.out.println("Student Details");
            System.out.println("Student Name: " + foundStudent.getStudentName());
            System.out.println("Student ID: " + foundStudent.getStudentID());
            System.out.println("Student Email: " + foundStudent.getStudentEmail());
            System.out.println("Mode: " + foundStudent.getMode());
            System.out.println("Student Gender: " + foundStudent.getGender());
        } else {
            MessageUI.displayNotFound();
        }
    }

    //display founded student via name
    public void dispFoundStud(Iterator<Student> g1ListAsIterator, Iterator<Student> g2ListAsIterator, String studentNameToFind, Student foundStudent) {
        while (g1ListAsIterator.hasNext()) {
            Student student = g1ListAsIterator.next();
            if (student.getStudentName().equals(studentNameToFind)) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent == null) {
            // Convert g2List to a List

            while (g2ListAsIterator.hasNext()) {
                Student student = g2ListAsIterator.next();
                if (student.getStudentName().equals(studentNameToFind)) {
                    foundStudent = student;
                    break;
                }
            }
        }

        if (foundStudent != null) {
            System.out.println("Student Details");
            System.out.println("Student Name: " + foundStudent.getStudentName());
            System.out.println("Student ID: " + foundStudent.getStudentID());
            System.out.println("Student Email: " + foundStudent.getStudentEmail());
            System.out.println("Mode: " + foundStudent.getMode());
            System.out.println("Student Gender: " + foundStudent.getGender());
        } else {
            MessageUI.displayNotFound();
        }
    }

    //change g1 to g2
    public void changeG1toG2(Iterator<Student> g1ListAsIterator, int studentIDToChange, Student foundStudent) {
        while (g1ListAsIterator.hasNext()) {
            Student student = g1ListAsIterator.next();
            if (student.getStudentID() == studentIDToChange) {
                foundStudent = student;
                break;
            }

            if (foundStudent == null) {
                MessageUI.displayNotFound();
                break;
            }
        }
        if (foundStudent != null) {
            System.out.println("Student Details");
            System.out.println("Student Name: " + foundStudent.getStudentName());
            System.out.println("Student ID: " + foundStudent.getStudentID());
            System.out.println("Student Email: " + foundStudent.getStudentEmail());
            System.out.println("Mode: " + foundStudent.getMode());
            System.out.println("Student Gender: " + foundStudent.getGender());
            String choice;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("\nAre you sure want to change group for this student? (y/n): ");
                choice = scanner.nextLine().toLowerCase(); // Convert input to lowercase for case-insensitive comparison
                switch (choice) {
                    case "y" -> {
                        g1List.remove(foundStudent);
                        g1DAO.saveToFile(g1List);
                        g2List.add(foundStudent);
                        g2DAO.saveToFile(g2List);
                        break;
                    }
                    case "n" -> {
                        cls();
                        mainMenu();
                        break;
                    }
                    default ->
                        MessageUI.askAgainMessage();
                }
            }
        } else {
            MessageUI.displayNotFound();
        }
    }

    //change g2 to g1
    public void changeG2toG1(Iterator<Student> g2ListAsIterator, int studentIDToChange, Student foundStudent) {
        while (g2ListAsIterator.hasNext()) {
            Student student = g2ListAsIterator.next();
            if (student.getStudentID() == studentIDToChange) {
                foundStudent = student;
                break;
            }

            if (foundStudent == null) {
                MessageUI.displayNotFound();
                break;
            }
        }
        if (foundStudent != null) {
            System.out.println("Student Details");
            System.out.println("Student Name: " + foundStudent.getStudentName());
            System.out.println("Student ID: " + foundStudent.getStudentID());
            System.out.println("Student Email: " + foundStudent.getStudentEmail());
            System.out.println("Mode: " + foundStudent.getMode());
            System.out.println("Student Gender: " + foundStudent.getGender());
            String choice;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("\nAre you sure want to change group for this student? (y/n): ");
                choice = scanner.nextLine().toLowerCase(); // Convert input to lowercase for case-insensitive comparison
                switch (choice) {
                    case "y" -> {
                        g2List.remove(foundStudent);
                        g2DAO.saveToFile(g2List);
                        g1List.add(foundStudent);
                        g1DAO.saveToFile(g1List);
                        break;
                    }
                    case "n" -> {
                        cls();
                        mainMenu();
                        break;
                    }
                    default ->
                        MessageUI.askAgainMessage();
                }
            }
        } else {
            MessageUI.displayNotFound();
        }
    }

    public static void main(String[] args) {
        TutorGroupManagement tutGroupManagement = new TutorGroupManagement();
        tutGroupManagement.mainMenu();

    }
}
