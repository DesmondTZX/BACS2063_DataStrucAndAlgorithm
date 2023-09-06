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
    private final StudentDAO g3DAO = new StudentDAO("Group3.dat");
    private final StudentDAO g4DAO = new StudentDAO("Group4.dat");
    private final StudentDAO g5DAO = new StudentDAO("Group5.dat");

    private SortedListInterface<Student> g1List = new SortedLinkedList<>();
    private SortedListInterface<Student> g2List = new SortedLinkedList<>();
    private SortedListInterface<Student> g3List = new SortedLinkedList<>();
    private SortedListInterface<Student> g4List = new SortedLinkedList<>();
    private SortedListInterface<Student> g5List = new SortedLinkedList<>();

    public TutorGroupManagement() {
        g1List = g1DAO.retrieveFromFile();
        g2List = g2DAO.retrieveFromFile();
        g3List = g3DAO.retrieveFromFile();
        g4List = g4DAO.retrieveFromFile();
        g5List = g5DAO.retrieveFromFile();
    }

    //main menu
    public void mainMenu() {

        int choice = 0;
        do {
            choice = tutGroupUI.getMenuChoice();
            switch (choice) {
                case 0 -> {
                    clearData();
                    cls();
                    MessageUI.displayExitMessage();
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

    //function
    public void addNewStudent() {
        int gpChoice = 0;
        do {
            tutGroupUI.addTitle();
            gpChoice = tutGroupUI.getGroupChoice();
            switch (gpChoice) {
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
                case 3 -> {
                    cls();
                    tutGroupUI.addTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG3()); //display all the studentList IN G3
                    Student newStud = tutGroupUI.inputStudentDetails();
                    g3List.add(newStud);
                    g3DAO.saveToFile(g3List);
                    break;
                }
                case 4 -> {
                    cls();
                    tutGroupUI.addTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG4()); //display all the studentList IN G4
                    Student newStud = tutGroupUI.inputStudentDetails();
                    g4List.add(newStud);
                    g4DAO.saveToFile(g4List);
                    break;
                }
                case 5 -> {
                    cls();
                    tutGroupUI.addTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG5()); //display all the studentList IN G5
                    Student newStud = tutGroupUI.inputStudentDetails();
                    g5List.add(newStud);
                    g5DAO.saveToFile(g5List);
                    break;
                }
                case 0 -> {
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
    }

    public void removeStudent() {
        int gpChoice = 0;
        do {
            tutGroupUI.removeTitle();
            gpChoice = tutGroupUI.getGroupChoice();
            switch (gpChoice) {
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
                case 3 -> {
                    cls();
                    tutGroupUI.listAllStudent(getAllStudentsG3()); //display all the studentList IN G3
                    tutGroupUI.removeTitle();
                    Student delStud = new Student(tutGroupUI.inputStudentID());
                    g3List.remove(delStud);
                    g3DAO.saveToFile(g3List);
                    break;
                }
                case 4 -> {
                    cls();
                    tutGroupUI.listAllStudent(getAllStudentsG4()); //display all the studentList IN G4
                    tutGroupUI.removeTitle();
                    Student delStud = new Student(tutGroupUI.inputStudentID());
                    g4List.remove(delStud);
                    g4DAO.saveToFile(g4List);
                    break;
                }
                case 5 -> {
                    cls();
                    tutGroupUI.listAllStudent(getAllStudentsG5()); //display all the studentList IN G5
                    tutGroupUI.removeTitle();
                    Student delStud = new Student(tutGroupUI.inputStudentID());
                    g5List.remove(delStud);
                    g5DAO.saveToFile(g5List);
                    break;
                }
                case 0 -> {
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
    }

    public void changeStudentTutGroup() {
        int gpChoice = 0;
        do {
            tutGroupUI.changeStudTitle();
            gpChoice = tutGroupUI.getGroupChoice();
            switch (gpChoice) {
                case 1 -> {
                    cls();
                    tutGroupUI.changeStudTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG1()); //display all the studentList IN G1
                    int studentIDToChange = tutGroupUI.inputStudentID();
                    Student foundStudent = null;
                    // Convert g1List to a List
                    Iterator<Student> g1ListAsIterator = g1List.getIterator();
                    changeG1toOther(g1ListAsIterator, studentIDToChange, foundStudent);
                    break;
                }
                case 2 -> {
                    cls();
                    tutGroupUI.changeStudTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG2()); //display all the studentList IN G2
                    int studentIDToChange = tutGroupUI.inputStudentID();
                    Student foundStudent = null;
                    // Convert g2List to a List
                    Iterator<Student> g2ListAsIterator = g2List.getIterator();
                    changeG2toOther(g2ListAsIterator, studentIDToChange, foundStudent);
                    break;
                }
                case 3 -> {
                    cls();
                    tutGroupUI.changeStudTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG3()); //display all the studentList IN G3
                    int studentIDToChange = tutGroupUI.inputStudentID();
                    Student foundStudent = null;
                    // Convert g3List to a List
                    Iterator<Student> g3ListAsIterator = g3List.getIterator();
                    changeG3toOther(g3ListAsIterator, studentIDToChange, foundStudent);
                    break;
                }

                case 4 -> {
                    cls();
                    tutGroupUI.changeStudTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG4()); //display all the studentList IN G4
                    int studentIDToChange = tutGroupUI.inputStudentID();
                    Student foundStudent = null;
                    // Convert g4List to a List
                    Iterator<Student> g4ListAsIterator = g4List.getIterator();
                    changeG4toOther(g4ListAsIterator, studentIDToChange, foundStudent);
                    break;
                }
                case 5 -> {
                    cls();
                    tutGroupUI.changeStudTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG5()); //display all the studentList IN G5
                    int studentIDToChange = tutGroupUI.inputStudentID();
                    Student foundStudent = null;
                    // Convert g5List to a List
                    Iterator<Student> g5ListAsIterator = g5List.getIterator();
                    changeG5toOther(g5ListAsIterator, studentIDToChange, foundStudent);
                    break;
                }
                case 0 -> {
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
                    // Convert g1-g5List to a iterator
                    Iterator<Student> g1ListAsIterator = g1List.getIterator();
                    Iterator<Student> g2ListAsIterator = g2List.getIterator();
                    Iterator<Student> g3ListAsIterator = g3List.getIterator();
                    Iterator<Student> g4ListAsIterator = g4List.getIterator();
                    Iterator<Student> g5ListAsIterator = g5List.getIterator();
                    dispFoundStud(g1ListAsIterator, g2ListAsIterator, g3ListAsIterator, g4ListAsIterator, g5ListAsIterator, studentIDToFind, foundStudent);
                    break;
                }
                case 2 -> {
                    cls();
                    String studentNameToFind = tutGroupUI.inputStudentName();
                    Student foundStudent = null;
                    // Convert g1-g5List to a iterator
                    Iterator<Student> g1ListAsIterator = g1List.getIterator();
                    Iterator<Student> g2ListAsIterator = g2List.getIterator();
                    Iterator<Student> g3ListAsIterator = g3List.getIterator();
                    Iterator<Student> g4ListAsIterator = g4List.getIterator();
                    Iterator<Student> g5ListAsIterator = g5List.getIterator();
                    dispFoundStud(g1ListAsIterator, g2ListAsIterator, g3ListAsIterator, g4ListAsIterator, g5ListAsIterator, studentNameToFind, foundStudent);
                    break;
                }
                case 0 -> {
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
    }

    public void dispStudent() {
        int gpChoice = 0;
        do {
            tutGroupUI.dispTitle();
            gpChoice = tutGroupUI.getGroupChoice();
            switch (gpChoice) {
                case 1 -> {
                    cls();
                    tutGroupUI.dispTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG1()); //display all the studentList IN G1
                    break;
                }
                case 2 -> {
                    cls();
                    tutGroupUI.dispTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG2()); //display all the studentList IN G2 
                    break;
                }
                case 3 -> {
                    cls();
                    tutGroupUI.dispTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG3()); //display all the studentList IN G3
                    break;
                }
                case 4 -> {
                    cls();
                    tutGroupUI.dispTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG4()); //display all the studentList IN G4 
                    break;
                }
                case 5 -> {
                    cls();
                    tutGroupUI.dispTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG5()); //display all the studentList IN G5 
                    break;
                }
                case 0 -> {
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
    }

    public void generateReport() {
        int gpChoice = 0;
        do {
            tutGroupUI.reportTitle();
            gpChoice = tutGroupUI.getGroupChoice();
            switch (gpChoice) {
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
                case 3 -> {
                    cls();
                    tutGroupUI.reportTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG3()); //display all the studentList IN G3
                    System.out.println("\nTotal Students: " + g3List.getNumberOfEntries() + " students ");
                    break;
                }
                case 4 -> {
                    cls();
                    tutGroupUI.reportTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG4()); //display all the studentList IN G4
                    System.out.println("\nTotal Students: " + g4List.getNumberOfEntries() + " students ");
                    break;
                }
                case 5 -> {
                    cls();
                    tutGroupUI.reportTitle();
                    tutGroupUI.listAllStudent(getAllStudentsG5()); //display all the studentList IN G5
                    System.out.println("\nTotal Students: " + g5List.getNumberOfEntries() + " students ");
                    break;
                }
                case 0 -> {
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
    }

    //display group 1-5
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

    public String getAllStudentsG3() {
        String outputStr = "";
        Iterator<Student> g3StudIterator = g3List.getIterator();
        while (g3StudIterator.hasNext()) {
            Student stud = g3StudIterator.next();
            outputStr += stud + "\n";
        }

        return outputStr;
    }

    public String getAllStudentsG4() {
        String outputStr = "";
        Iterator<Student> g4StudIterator = g4List.getIterator();
        while (g4StudIterator.hasNext()) {
            Student stud = g4StudIterator.next();
            outputStr += stud + "\n";
        }

        return outputStr;
    }

    public String getAllStudentsG5() {
        String outputStr = "";
        Iterator<Student> g5StudIterator = g5List.getIterator();
        while (g5StudIterator.hasNext()) {
            Student stud = g5StudIterator.next();
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
    public void dispFoundStud(Iterator<Student> g1ListAsIterator, Iterator<Student> g2ListAsIterator, Iterator<Student> g3ListAsIterator, Iterator<Student> g4ListAsIterator, Iterator<Student> g5ListAsIterator, int studentIDToFind, Student foundStudent) {
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
        if (foundStudent == null) {
            // Convert g3List to a List

            while (g3ListAsIterator.hasNext()) {
                Student student = g3ListAsIterator.next();
                if (student.getStudentID() == studentIDToFind) {
                    foundStudent = student;
                    break;
                }
            }
        }

        if (foundStudent == null) {
            // Convert g4List to a List

            while (g4ListAsIterator.hasNext()) {
                Student student = g4ListAsIterator.next();
                if (student.getStudentID() == studentIDToFind) {
                    foundStudent = student;
                    break;
                }
            }
        }

        if (foundStudent == null) {
            // Convert g5List to a List

            while (g5ListAsIterator.hasNext()) {
                Student student = g5ListAsIterator.next();
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
    public void dispFoundStud(Iterator<Student> g1ListAsIterator, Iterator<Student> g2ListAsIterator, Iterator<Student> g3ListAsIterator, Iterator<Student> g4ListAsIterator, Iterator<Student> g5ListAsIterator, String studentNameToFind, Student foundStudent) {
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

        if (foundStudent == null) {
            // Convert g3List to a List

            while (g3ListAsIterator.hasNext()) {
                Student student = g3ListAsIterator.next();
                if (student.getStudentName().equals(studentNameToFind)) {
                    foundStudent = student;
                    break;
                }
            }
        }

        if (foundStudent == null) {
            // Convert g4List to a List

            while (g4ListAsIterator.hasNext()) {
                Student student = g4ListAsIterator.next();
                if (student.getStudentName().equals(studentNameToFind)) {
                    foundStudent = student;
                    break;
                }
            }
        }

        if (foundStudent == null) {
            // Convert g5List to a List

            while (g5ListAsIterator.hasNext()) {
                Student student = g5ListAsIterator.next();
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

    //change g1 to other
    public void changeG1toOther(Iterator<Student> g1ListAsIterator, int studentIDToChange, Student foundStudent) {
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
                        int chgChoice = 0;
                        chgChoice = tutGroupUI.chgGroup1Choice();
                        do {
                            switch (chgChoice) {
                                case 1 -> {
                                    g1List.remove(foundStudent);
                                    g1DAO.saveToFile(g1List);
                                    g2List.add(foundStudent);
                                    g2DAO.saveToFile(g2List);
                                    break;
                                }
                                case 2 -> {
                                    g1List.remove(foundStudent);
                                    g1DAO.saveToFile(g1List);
                                    g3List.add(foundStudent);
                                    g3DAO.saveToFile(g3List);
                                    break;
                                }
                                case 3 -> {
                                    g1List.remove(foundStudent);
                                    g1DAO.saveToFile(g4List);
                                    g4List.add(foundStudent);
                                    g4DAO.saveToFile(g4List);
                                    break;
                                }
                                case 4 -> {
                                    g1List.remove(foundStudent);
                                    g1DAO.saveToFile(g1List);
                                    g5List.add(foundStudent);
                                    g5DAO.saveToFile(g5List);
                                    break;
                                }
                                case 0 -> {
                                    cls();
                                    break;
                                }
                                default ->
                                    MessageUI.askAgainMessage();
                            }

                            break;
                        } while (chgChoice != 0);
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

    public void changeG2toOther(Iterator<Student> g2ListAsIterator, int studentIDToChange, Student foundStudent) {
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
                        int chgChoice = 0;
                        chgChoice = tutGroupUI.chgGroup2Choice();
                        do {
                            switch (chgChoice) {
                                case 1 -> {
                                    g2List.remove(foundStudent);
                                    g2DAO.saveToFile(g2List);
                                    g1List.add(foundStudent);
                                    g1DAO.saveToFile(g1List);
                                    break;
                                }
                                case 2 -> {
                                    g2List.remove(foundStudent);
                                    g2DAO.saveToFile(g2List);
                                    g3List.add(foundStudent);
                                    g3DAO.saveToFile(g3List);
                                    break;
                                }
                                case 3 -> {
                                    g2List.remove(foundStudent);
                                    g2DAO.saveToFile(g2List);
                                    g4List.add(foundStudent);
                                    g4DAO.saveToFile(g4List);
                                    break;
                                }
                                case 4 -> {
                                    g2List.remove(foundStudent);
                                    g2DAO.saveToFile(g2List);
                                    g5List.add(foundStudent);
                                    g5DAO.saveToFile(g5List);
                                    break;
                                }
                                case 0 -> {
                                    cls();
                                    break;
                                }
                                default ->
                                    MessageUI.askAgainMessage();
                            }

                            break;
                        } while (chgChoice != 0);
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

    public void changeG3toOther(Iterator<Student> g3ListAsIterator, int studentIDToChange, Student foundStudent) {
        while (g3ListAsIterator.hasNext()) {
            Student student = g3ListAsIterator.next();
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
                        int chgChoice = 0;
                        chgChoice = tutGroupUI.chgGroup3Choice();
                        do {
                            switch (chgChoice) {
                                case 1 -> {
                                    g3List.remove(foundStudent);
                                    g3DAO.saveToFile(g3List);
                                    g1List.add(foundStudent);
                                    g1DAO.saveToFile(g1List);
                                    break;
                                }
                                case 2 -> {
                                    g3List.remove(foundStudent);
                                    g3DAO.saveToFile(g3List);
                                    g2List.add(foundStudent);
                                    g2DAO.saveToFile(g2List);
                                    break;
                                }
                                case 3 -> {
                                    g3List.remove(foundStudent);
                                    g3DAO.saveToFile(g3List);
                                    g4List.add(foundStudent);
                                    g4DAO.saveToFile(g4List);
                                    break;
                                }
                                case 4 -> {
                                    g3List.remove(foundStudent);
                                    g3DAO.saveToFile(g3List);
                                    g5List.add(foundStudent);
                                    g5DAO.saveToFile(g5List);
                                    break;
                                }
                                case 0 -> {
                                    cls();
                                    break;
                                }
                                default ->
                                    MessageUI.askAgainMessage();
                            }

                            break;
                        } while (chgChoice != 0);
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

    public void changeG4toOther(Iterator<Student> g4ListAsIterator, int studentIDToChange, Student foundStudent) {
        while (g4ListAsIterator.hasNext()) {
            Student student = g4ListAsIterator.next();
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
                        int chgChoice = 0;
                        chgChoice = tutGroupUI.chgGroup4Choice();
                        do {
                            switch (chgChoice) {
                                case 1 -> {
                                    g4List.remove(foundStudent);
                                    g4DAO.saveToFile(g4List);
                                    g1List.add(foundStudent);
                                    g1DAO.saveToFile(g1List);
                                    break;
                                }
                                case 2 -> {
                                    g4List.remove(foundStudent);
                                    g4DAO.saveToFile(g4List);
                                    g2List.add(foundStudent);
                                    g2DAO.saveToFile(g2List);
                                    break;
                                }
                                case 3 -> {
                                    g4List.remove(foundStudent);
                                    g4DAO.saveToFile(g4List);
                                    g3List.add(foundStudent);
                                    g3DAO.saveToFile(g3List);
                                    break;
                                }
                                case 4 -> {
                                    g4List.remove(foundStudent);
                                    g4DAO.saveToFile(g4List);
                                    g5List.add(foundStudent);
                                    g5DAO.saveToFile(g5List);
                                    break;
                                }
                                case 0 -> {
                                    cls();
                                    break;
                                }
                                default ->
                                    MessageUI.askAgainMessage();
                            }

                            break;
                        } while (chgChoice != 0);
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

    public void changeG5toOther(Iterator<Student> g5ListAsIterator, int studentIDToChange, Student foundStudent) {
        while (g5ListAsIterator.hasNext()) {
            Student student = g5ListAsIterator.next();
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
                        int chgChoice = 0;
                        chgChoice = tutGroupUI.chgGroup5Choice();
                        do {
                            switch (chgChoice) {
                                case 1 -> {
                                    g5List.remove(foundStudent);
                                    g5DAO.saveToFile(g5List);
                                    g1List.add(foundStudent);
                                    g1DAO.saveToFile(g1List);
                                    break;
                                }
                                case 2 -> {
                                    g5List.remove(foundStudent);
                                    g5DAO.saveToFile(g5List);
                                    g2List.add(foundStudent);
                                    g2DAO.saveToFile(g2List);
                                    break;
                                }
                                case 3 -> {
                                    g5List.remove(foundStudent);
                                    g5DAO.saveToFile(g5List);
                                    g3List.add(foundStudent);
                                    g3DAO.saveToFile(g3List);
                                    break;
                                }
                                case 4 -> {
                                    g5List.remove(foundStudent);
                                    g5DAO.saveToFile(g5List);
                                    g4List.add(foundStudent);
                                    g4DAO.saveToFile(g4List);
                                    break;
                                }
                                case 0 -> {
                                    cls();
                                    break;
                                }
                                default ->
                                    MessageUI.askAgainMessage();
                            }

                            break;
                        } while (chgChoice != 0);
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

    //autogenerated namelist
    public void generateGroup1() {
        g1List.add(new Student("Dong Wei Jie", 2309419, "dongwj-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g1List.add(new Student("Linda Lee", 2309420, "lindalee-wm21@student.tarc.edu.my", "FullTime", "Female"));
        g1List.add(new Student("Kevin Tan", 2309421, "kevintan-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g1List.add(new Student("Sara Lim", 2309422, "saralim-wm21@student.tarc.edu.my", "PartTime", "Female"));
        g1List.add(new Student("Alex Wong", 2309423, "alexwong-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g1List.add(new Student("Sophia Ng", 2309424, "sophiang-wm21@student.tarc.edu.my", "PartTime", "Female"));
        g1List.add(new Student("Ryan Chen", 2309425, "ryanchen-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g1List.add(new Student("Grace Yap", 2309426, "graceyap-wm21@student.tarc.edu.my", "FullTime", "Female"));
        g1List.add(new Student("Ethan Ng", 2309427, "ethanng-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g1List.add(new Student("Olivia Tan", 2309428, "oliviatan-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g1DAO.saveToFile(g1List);
    }

    public void generateGroup2() {
        g2List.add(new Student("Jackie Cheong", 2309429, "jackiecheong-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g2List.add(new Student("Mandy Lee", 2309430, "mandylee-wm21@student.tarc.edu.my", "FullTime", "Female"));
        g2List.add(new Student("Darwin Tan", 2309431, "darwintan-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g2List.add(new Student("Casey Lim", 2309432, "Caseylim-wm21@student.tarc.edu.my", "PartTime", "Female"));
        g2List.add(new Student("John Wong", 2309433, "johnwong-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g2List.add(new Student("Kelly Ng", 2309434, "kellyng-wm21@student.tarc.edu.my", "PartTime", "Female"));
        g2List.add(new Student("Ryan Lee", 2309435, "ryanlee-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g2List.add(new Student("Grace Wong", 2309436, "gracewong-wm21@student.tarc.edu.my", "FullTime", "Female"));
        g2List.add(new Student("Ethan Lim", 23094237, "ethanlim-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g2List.add(new Student("Vanessa Tan", 2309438, "vanessatan-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g2DAO.saveToFile(g2List);
    }

    public void generateGroup3() {
        g3List.add(new Student("Jonathan Ma", 2309439, "jonathanma-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g3DAO.saveToFile(g3List);
    }

    public void generateGroup4() {
        g4List.add(new Student("Alexander Tan", 2309449, "alexandertan-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g4DAO.saveToFile(g4List);
    }

    public void generateGroup5() {
        g5List.add(new Student("Daniel Lee", 2309459, "daniellee-wm21@student.tarc.edu.my", "FullTime", "Male"));
        g5DAO.saveToFile(g5List);
    }

    //clear data before exit program
    public void clearData() {
        g1List.clear();
        g1DAO.saveToFile(g1List);
        g2List.clear();
        g2DAO.saveToFile(g2List);
        g3List.clear();
        g3DAO.saveToFile(g3List);
        g4List.clear();
        g4DAO.saveToFile(g4List);
        g5List.clear();
        g5DAO.saveToFile(g5List);
    }

    //main autoGenerate
    public static void autoGenerate(TutorGroupManagement tutGroupManagement) {
        tutGroupManagement.generateGroup1();
        tutGroupManagement.generateGroup2();
        tutGroupManagement.generateGroup3();
        tutGroupManagement.generateGroup4();
        tutGroupManagement.generateGroup5();
    }

}
