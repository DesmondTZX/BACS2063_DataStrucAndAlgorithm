package client;

import adt.*;
import boundary.TutorManagementUI;
import dao.TutorDAO;
import entity.*;

public class TutorManagement {
    
    private SortedListInterface<Tutor> tutorList = new SortedLinkedList<>();
    private TutorDAO tutorDAO = new TutorDAO("Tutors.dat");
    private TutorManagementUI tutorUI = new TutorManagementUI();
    
    public TutorManagement() {
        tutorList = tutorDAO.retrieveFromFile();
    }
    
    public void runProductMaintenance() {
        int choice = tutorUI.getMenuChoice();

        while (choice != 0) {
            switch (choice) {
                case 1:
                    //addNewTutor();
                    //tutorUI.listAllTutors(getAllTutors());
                    break;
                case 2:
                    //tutorUI.listAllTutors(getAllTutors());
                    break;
                default:
                    System.out.println("\nInvalid choice");
                    break;
            }

            choice = tutorUI.getMenuChoice(); // Update the choice for the next iteration
        }

        System.out.println("\nExiting system");
    }


    public static void main(String[] args) {
        // TODO code application logic here
        // based on what i see in ECBDemo, i think i will probably do it via that method as well, will put code here latr
    }
    
}
