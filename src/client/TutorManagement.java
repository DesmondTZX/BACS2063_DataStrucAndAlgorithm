package client;

import adt.*;
import boundary.TutorManagementUI;
import dao.TutorDAO;
import entity.*;
import java.util.Iterator;

public class TutorManagement {
    
    private SortedListInterface<Tutor> tutorList = new SortedLinkedList<>();
    private final TutorDAO tutorDAO = new TutorDAO("Tutors.dat");
    private final TutorManagementUI tutorUI = new TutorManagementUI();
    
    public TutorManagement() {
        tutorList = tutorDAO.retrieveFromFile();
    }
    
    public void runTutorManagement() {
        int choice = tutorUI.getMenuChoice();

        while (choice != 0) {
            switch (choice) {
                case 1 -> {
                    addNewTutor();
                    tutorUI.listAllTutors(getAllTutors());
                }
                case 2 -> tutorUI.listAllTutors(getAllTutors());
                case 3 -> {
                    deleteTutor();
                    tutorUI.listAllTutors(getAllTutors());
                }
                case 4 -> {
                    editTutor();
                    tutorUI.listAllTutors(getAllTutors());
                }
                case 5 -> displaySpecificTutors();
                case 6 -> generateReport();
                default -> System.out.println("\nInvalid choice");
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
        Tutor editTutor = new Tutor(tutorUI.inputTutorID());
    }
    
    public void displaySpecificTutors() {
        tutorUI.selectCriteria();
    }
    
    public void generateReport() {
        System.out.printf("%s %s %s %s %s %s %s %s %s\n", "No.", "ID", "Name", "Gender", "Email", "Position", "Faculty", "Department", "Campus");
    }
  
    public static void main(String[] args) {
        TutorManagement tutorManagement = new TutorManagement();
        tutorManagement.runTutorManagement();
    }
    
}
