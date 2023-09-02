package client;

import adt.*;
import boundary.TutorManagementUI;
import dao.TutorDAO;
import entity.*;
import java.util.Iterator;

public class TutorManagement {
    
    private SortedListInterface<Tutor> tutorList = new SortedLinkedList<>();
    private TutorDAO tutorDAO = new TutorDAO("Tutors.dat");
    private TutorManagementUI tutorUI = new TutorManagementUI();
    
    public TutorManagement() {
        tutorList = tutorDAO.retrieveFromFile();
        // this is currently broken and im still finding out why, dealing with this later
    }
    
    public void runTutorManagement() {
        int choice = tutorUI.getMenuChoice();

        while (choice != 0) {
            switch (choice) {
                case 1:
                    addNewTutor();
                    tutorUI.listAllTutors(getAllTutors());
                    break;
                case 2:
                    tutorUI.listAllTutors(getAllTutors());
                    break;
                case 3:
                    deleteTutor();
                    tutorUI.listAllTutors(getAllTutors());
                    break;
                case 4:
                    // modify entry
                    tutorUI.listAllTutors(getAllTutors());
                    break;
                case 5:
                    // list entry based on criteria
                    displaySpecificTutors();
                    break;
                case 6:
                    // generate report
                    break;
                default:
                    System.out.println("\nInvalid choice");
                    break;
            }

            choice = tutorUI.getMenuChoice(); // Update the choice for the next iteration
        }

        System.out.println("\nExiting system");
    }
    
    public void addNewTutor() {
        Tutor newTutor = tutorUI.inputTutorDetails();
        tutorList.add(newTutor);
        tutorDAO.saveToFile(tutorList);
    }

    public String getAllTutors() {
        String outputStr = "";
        Iterator<Tutor> tutorIterator = tutorList.getIterator();

        while (tutorIterator.hasNext()) {
            Tutor tutor = tutorIterator.next();
            outputStr += tutor + "\n";
        }

        return outputStr;
    }

    public void displayTutors() {
        tutorUI.listAllTutors(getAllTutors());
    }
    
    public void deleteTutor() {
        Tutor delTutor = new Tutor(tutorUI.inputTutorID());
        tutorList.remove(delTutor);
        tutorDAO.saveToFile(tutorList);
    }
    
    public void editTutor() {
        
    }
    
    public void displaySpecificTutors() {
        tutorUI.selectCriteria();
    }
    
    public void generateReport() {
        
    }
  
    public static void main(String[] args) {
        TutorManagement tutorManagement = new TutorManagement();
        tutorManagement.runTutorManagement();
    }
    
}
