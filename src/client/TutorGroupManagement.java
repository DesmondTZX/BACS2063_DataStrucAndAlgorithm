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
    private final StudentDAO studDAO = new StudentDAO("Student.dat");
    private SortedListInterface<Student> studentList = new SortedList<>();

    public TutorGroupManagement() {
        studentList = studDAO.retrieveFromFile();
    }
    
    public void mainMenu() {
        int choice = 0;
        do {
            choice = tutGroupUI.getMenuChoice();
            switch (choice) {
                case 0 -> {
                    MessageUI.displayExitMessage();
                    System.exit(0);
                }
                case 1 -> {
                    cls();
                    addNewStudent();
                }
                case 2 -> {
                    cls();
                    removeStudent();
                }
                case 3 -> {
                    cls();
                    changeStudentTutGroup();
                }
                case 4 -> {
                    cls();
                    findStudent();
                }
                case 5 -> {
                    cls();
                    dispStudent();
                }
                case 6 -> {
                    cls();
                    generateReport();
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }

            }
        } while (choice != 0);

    }

    public void addNewStudent() {
        Student newStud = tutGroupUI.inputStudentDetails();
        studentList.add(newStud);
        studDAO.saveToFile(studentList);
        int choice = 0;
        do {
            choice = tutGroupUI.getAddChoice();
            switch (choice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                }
                case 1 -> {
                    cls();
                    mainMenu();
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (choice != 0);
    }

    public void removeStudent() {
        int choice = 0;
        do {
            choice = tutGroupUI.getRemoveChoice();
            switch (choice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                }
                case 1 -> {
                    cls();
                    mainMenu();
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (choice != 0);
    }

    public void changeStudentTutGroup() {
        int choice = 0;
        do {
            choice = tutGroupUI.getChangeChoice();
            switch (choice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                }
                case 1 -> {
                    cls();
                    mainMenu();
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (choice != 0);
    }

    public void findStudent() {
        int choice = 0;
        do {
            choice = tutGroupUI.getFindChoice();
            switch (choice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                }
                case 1 -> {
                    cls();
                    mainMenu();
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (choice != 0);
    }

    public void dispStudent() {
        tutGroupUI.listAllStudent(getAllStudents());
        int choice = 0;
        do {
            choice = tutGroupUI.getListChoice();
            switch (choice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                }
                case 1 -> {
                    cls();
                    mainMenu();
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (choice != 0);
    }

    public void generateReport() {
        int choice = 0;
        do {
            choice = tutGroupUI.getReportChoice();
            switch (choice) {
                case 0 -> {
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                }
                case 1 -> {
                    cls();
                    mainMenu();
                }
                default -> {
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
                }
            }
        } while (choice != 0);

    }
    
    public String getAllStudents() {
        String outputStr = "";
        Iterator<Student> studIterator = studentList.getIterator();

        while (studIterator.hasNext()) {
            Student stud = studIterator.next();
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
