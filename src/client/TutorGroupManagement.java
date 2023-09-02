/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import boundary.*;
import dao.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import utility.*;

/**
 *
 * @author Jack
 */
public class TutorGroupManagement {

    private TutorGroupManagementUI tutGroupUI = new TutorGroupManagementUI();
    private DisplayStudentList disStudList = new DisplayStudentList();

    public void mainMenu() {
        int choice = 0;
        do {
            choice = tutGroupUI.getMenuChoice();
            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                case 1:
                    cls();
                    addNewStudent();
                    break;
                case 2:
                    cls();
                    removeStudent();
                    break;
                case 3:
                    cls();
                    changeStudentTutGroup();
                    break;
                case 4:
                    cls();
                    findStudent();
                    break;
                case 5:
                    cls();
                    listAllStudent();
                    break;
                case 6:
                    cls();
                    generateReport();
                    break;
                default:
                    cls();
                    MessageUI.displayInvalidChoiceMessage();

            }
        } while (choice != 0);

    }

    public void addNewStudent() {
        tutGroupUI.inputStudentDetails();
        int choice = 0;
        do {
            choice = tutGroupUI.getAddChoice();
            switch (choice) {
                case 0:
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                case 1:
                    cls();
                    mainMenu();
                    break;
                default:
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public void removeStudent() {
        int choice = 0;
        do {
            choice = tutGroupUI.getRemoveChoice();
            switch (choice) {
                case 0:
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                case 1:
                    cls();
                    mainMenu();
                    break;
                default:
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public void changeStudentTutGroup() {
        int choice = 0;
        do {
            choice = tutGroupUI.getChangeChoice();
            switch (choice) {
                case 0:
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                case 1:
                    cls();
                    mainMenu();
                    break;
                default:
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public void findStudent() {
        int choice = 0;
        do {
            choice = tutGroupUI.getFindChoice();
            switch (choice) {
                case 0:
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                case 1:
                    cls();
                    mainMenu();
                    break;
                default:
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public void listAllStudent() {
        
        int choice = 0;
        do {
            choice = tutGroupUI.getListChoice();
            switch (choice) {
                case 0:
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                case 1:
                    cls();
                    mainMenu();
                    break;
                default:
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public void generateReport() {
        int choice = 0;
        do {
            choice = tutGroupUI.getReportChoice();
            switch (choice) {
                case 0:
                    cls();
                    MessageUI.displayExitMessage();
                    System.exit(0);
                    break;
                case 1:
                    cls();
                    mainMenu();
                    break;
                default:
                    cls();
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);

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
