/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.*;
import boundary.*;
import dao.*;
import entity.Student;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import utility.*;

/**
 *
 * @author Jack
 */
public class TutorGroupManagement {

    private final TutorGroupManagementUI tutGroupUI = new TutorGroupManagementUI();
    private final StudentDAO g1DAO = new StudentDAO("Group1.dat");
    private final StudentDAO g2DAO = new StudentDAO("Group2.dat");
    private SortedListInterface<Student> g1List = new SortedList<>();
    private SortedListInterface<Student> g2List = new SortedList<>();

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
            System.out.println("===========");
            System.out.println("Add Student");
            System.out.println("===========");
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
                    System.out.println("===========");
                    System.out.println("Add Student");
                    System.out.println("===========");
                    tutGroupUI.listAllStudent(getAllStudentsG1()); //display all the studentList IN G1
                    Student newStud = tutGroupUI.inputStudentDetails();
                    g1List.add(newStud);
                    g1DAO.saveToFile(g1List);
                    break;
                }
                case 2 -> {
                    cls();
                    System.out.println("===========");
                    System.out.println("Add Student");
                    System.out.println("===========");
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
            System.out.println("==============");
            System.out.println("Remove Student");
            System.out.println("==============");
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
                    System.out.println("==============");
                    System.out.println("Remove Student");
                    System.out.println("==============");
                    Student delStud = new Student(tutGroupUI.inputStudentID());
                    g1List.remove(delStud);
                    g1DAO.saveToFile(g1List);
                    break;
                }
                case 2 -> {
                    cls();
                    tutGroupUI.listAllStudent(getAllStudentsG2()); //display all the studentList IN G2
                    System.out.println("==============");
                    System.out.println("Remove Student");
                    System.out.println("==============");
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
            System.out.println("=============================");
            System.out.println("Change Student Tutorial Group");
            System.out.println("=============================");
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
                    System.out.println("=============================");
                    System.out.println("Change Student Tutorial Group");
                    System.out.println("=============================");
                    tutGroupUI.listAllStudent(getAllStudentsG1()); //display all the studentList IN G1
                    Student chgStud = tutGroupUI.inputStudentDetails();
                    g1List.remove(chgStud);
                    g1DAO.saveToFile(g1List);
                    g2List.add(chgStud);
                    g2DAO.saveToFile(g2List);
                    break;
                }
                case 2 -> {
                    cls();
                    System.out.println("=============================");
                    System.out.println("Change Student Tutorial Group");
                    System.out.println("=============================");
                    tutGroupUI.listAllStudent(getAllStudentsG2()); //display all the studentList IN G1
                    Student chgStud = tutGroupUI.inputStudentDetails();
                    g2List.remove(chgStud);
                    g2DAO.saveToFile(g2List);
                    g1List.add(chgStud);
                    g1DAO.saveToFile(g1List);
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
            System.out.println("============");
            System.out.println("Find Student");
            System.out.println("============");
            Student findStud = new Student(tutGroupUI.inputStudentID());
            if (g1List.contains(findStud) || g2List.contains(findStud)) {
                System.out.println("Student Details");
                System.out.println("Student Name: " + findStud.getStudentName());
                System.out.println("Student ID: " + findStud.getStudentID());
                System.out.println("Student Email: " + findStud.getStudentEmail());
                System.out.println("Mode: " + findStud.getMode());
                System.out.println("Student Gender: " + findStud.getGender());
            } else {
                MessageUI.displayNotFound();
                tutGroupUI.againChoice();
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

    // got filter one based on criteria
    public void dispStudent() {
        int gpChoice = 0;
        do {
            System.out.println("===============");
            System.out.println("Display Student");
            System.out.println("===============");
            gpChoice = tutGroupUI.getGroupChoice();
            switch (gpChoice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                }
                case 1 -> {
                    cls();
                    System.out.println("===============");
                    System.out.println("Display Student");
                    System.out.println("===============");
                    tutGroupUI.listAllStudent(getAllStudentsG1()); //display all the studentList IN G1
                    break;
                }
                case 2 -> {
                    cls();
                    System.out.println("===============");
                    System.out.println("Display Student");
                    System.out.println("===============");
                    
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
            System.out.println("======");
            System.out.println("Report");
            System.out.println("======");
            gpChoice = tutGroupUI.getGroupChoice();
            switch (gpChoice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                }
                case 1 -> {
                    cls();
                    System.out.println("======");
                    System.out.println("Report");
                    System.out.println("======");
                    tutGroupUI.listAllStudent(getAllStudentsG1()); //display all the studentList IN G1
                    System.out.println("\nTotal Students: " + g1List.getNumberOfEntries() + " students ");
                    break;
                }
                case 2 -> {
                    cls();
                    System.out.println("========");
                    System.out.println("\nReport");
                    System.out.println("========");
                    tutGroupUI.listAllStudent(getAllStudentsG2()); //display all the studentList IN G1 
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

    public static void main(String[] args) {
        TutorGroupManagement tutGroupManagement = new TutorGroupManagement();
        tutGroupManagement.mainMenu();

    }

}
