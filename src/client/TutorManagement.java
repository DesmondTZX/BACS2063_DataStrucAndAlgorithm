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
                // generate dummy data, comment out later
                case 7:
                    generateDummyData();
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
    
    // Comment this out later, this is used to generate dummy data for testing purposes.
    public void generateDummyData() {
        /* tutorId, tutorName, tutorGender, tutorEmail, position, faculty, department, campus */
        tutorList.add(new Tutor("p0001", "David Hill", 'F', "plchow@tarc.edu.my", "Assistant Professor", "Faculty of Accountancy, Finance And Business", "", "Kuala Lumpur Branch"));
        tutorList.add(new Tutor("p0002", "Alice Smith", 'M', "asmith@tarc.edu.my", "Associate Professor", "Faculty of Computer Science", "", "Kuala Lumpur Branch"));
        tutorList.add(new Tutor("p0003", "John Doe", 'M', "jdoe@tarc.edu.my", "Professor", "Faculty of Engineering", "", "Penang Branch"));
        tutorList.add(new Tutor("p0004", "Mary Johnson", 'F', "mjohnson@tarc.edu.my", "Lecturer", "Faculty of Medicine", "", "Johor Branch"));
        tutorList.add(new Tutor("p0005", "Sarah Lee", 'F', "slee@tarc.edu.my", "Associate Professor", "Faculty of Arts and Humanities", "", "Kuala Lumpur Branch"));
        tutorList.add(new Tutor("p0006", "Michael Wang", 'M', "mwang@tarc.edu.my", "Assistant Professor", "Faculty of Science", "", "Penang Branch"));
        tutorList.add(new Tutor("p0007", "Lisa Chen", 'F', "lchen@tarc.edu.my", "Lecturer", "Faculty of Law", "", "Kuala Lumpur Branch"));
        tutorList.add(new Tutor("p0008", "Robert Tan", 'M', "rtan@tarc.edu.my", "Professor", "Faculty of Social Sciences", "", "Johor Branch"));
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
        
    }
  
    public static void main(String[] args) {
        TutorManagement tutorManagement = new TutorManagement();
        tutorManagement.runTutorManagement();
    }
    
}
