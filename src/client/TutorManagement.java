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
                    displayTutors();
                }
                case 2 -> displayTutors();
                case 3 -> {
                    deleteTutor();
                    displayTutors();
                }
                case 4 -> {
                    editTutor();
                    displayTutors();
                }
                case 5 -> searchSpecificTutors();
                case 6 -> generateReport();
                case 7 -> generateDummyData();
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
    
    // this is used to generate dummy data for testing purposes and to save time.
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
        if (!tutorList.isEmpty()) {
            tutorUI.listAllTutors(getAllTutors());
        } else {
            System.out.println("Tutor list is empty, please add new tutor to view.");
        }
    }
    
    public void deleteTutor() {
        Tutor delTutor = new Tutor(tutorUI.inputTutorID());
        tutorList.remove(delTutor);
        tutorDAO.saveToFile(tutorList);
    }
    
    public boolean editTutor() {
        String tutorIDToEdit = tutorUI.inputTutorID();
        
        // Get an iterator for your tutorList
        Iterator<Tutor> iterator = tutorList.getIterator();

        // Initialize tutorToEdit to null
        Tutor tutorToEdit = null;

        // Iterate through the list using the iterator
        while (iterator.hasNext()) {
            Tutor tutor = iterator.next();
            if (tutor.getTutorId().equals(tutorIDToEdit)) {
                tutorToEdit = tutor;
                break; // Found the tutor to edit, exit the loop
            }
        }
        
        if (tutorToEdit == null) {
            // Tutor with the entered ID not found in the list
            System.out.println("Tutor not found with the entered ID.");
            return false;
        }
        
        int choice = tutorUI.selectEdit();
        
        while (choice != 0) {
            switch (choice) {
                case 1 -> tutorToEdit.setTutorName(tutorUI.inputTutorName());
                case 2 -> tutorToEdit.setGender(tutorUI.inputTutorGender());
                case 3 -> tutorToEdit.setEmail(tutorUI.inputTutorEmail());
                case 4 -> tutorToEdit.setPosition(tutorUI.inputTutorPosition());
                case 5 -> tutorToEdit.setFaculty(tutorUI.inputTutorFaculty());
                case 6 -> tutorToEdit.setDepartment(tutorUI.inputTutorDepartment());
                case 7 -> tutorToEdit.setCampus(tutorUI.inputTutorCampus());
                default -> System.out.println("\nInvalid choice");
            }
            
            System.out.println("Tutor information updated.");
            tutorDAO.saveToFile(tutorList);
            choice = tutorUI.selectEdit(); // Update the choice for the next iteration
        }
        return true;
    }
    
    public void searchSpecificTutors() {
        int choice = tutorUI.selectCriteria();
        
        while (choice != 0) {
            switch (choice) {
                case 1 -> displaySpecificTutors(tutorUI.inputTutorID(), null, '\0', null, null, null, null, null);
                case 2 -> displaySpecificTutors(null, tutorUI.inputTutorName(), '\0', null, null, null, null, null);
                case 3 -> displaySpecificTutors(null, null, tutorUI.inputTutorGender(), null, null, null, null, null);
                case 4 -> displaySpecificTutors(null, null, '\0', tutorUI.inputTutorEmail(), null, null, null, null);
                case 5 -> displaySpecificTutors(null, null, '\0', null, tutorUI.inputTutorPosition(), null, null, null);
                case 6 -> displaySpecificTutors(null, null, '\0', null, null, tutorUI.inputTutorFaculty(), null, null);
                case 7 -> displaySpecificTutors(null, null, '\0', null, null, null, tutorUI.inputTutorDepartment(), null);
                case 8 -> displaySpecificTutors(null, null, '\0', null, null, null, null, tutorUI.inputTutorCampus());
                default -> System.out.println("\nInvalid choice");
            }
            
            //System.out.println("Tutor information updated.");
            //tutorDAO.saveToFile(tutorList);
            choice = tutorUI.selectCriteria(); // Update the choice for the next iteration
        }
    }
    

    public void displaySpecificTutors(String searchId, String searchName, char searchGender, String searchEmail, String searchPosition, String searchFaculty, String searchDepartment, String searchCampus) {
        boolean found = false;

        //System.out.println("Search Results for Tutors:");

        Iterator<Tutor> iterator = tutorList.getIterator();

        while (iterator.hasNext()) {
            Tutor tutor = iterator.next();
            if ((searchId == null || tutor.getTutorId().equalsIgnoreCase(searchId)) &&
                (searchName == null || tutor.getTutorName().equalsIgnoreCase(searchName)) &&
                (searchGender == '\0' || tutor.getGender() == searchGender) &&
                (searchEmail == null || tutor.getEmail().equalsIgnoreCase(searchEmail)) &&
                (searchPosition == null || tutor.getPosition().equalsIgnoreCase(searchPosition)) &&
                (searchFaculty == null || tutor.getFaculty().equalsIgnoreCase(searchFaculty)) &&
                (searchDepartment == null || tutor.getDepartment().equalsIgnoreCase(searchDepartment)) &&
                (searchCampus == null || tutor.getCampus().equalsIgnoreCase(searchCampus)) &&
                tutorList.contains(tutor)) {
                found = true;
                tutorUI.listAllTutors(tutor.toString());
            }
        }

        if (!found) {
            System.out.println("No tutors found with the entered criteria.");
        }
    }

    public void generateReport() {
        System.out.printf("%s %s %s %s %s %s %s %s\n", "ID", "Name", "Gender", "Email", "Position", "Faculty", "Department", "Campus");
        displayTutors();
        System.out.println("Total number of tutors: " + tutorList.getNumberOfEntries());
    }
  
    public static void main(String[] args) {
        TutorManagement tutorManagement = new TutorManagement();
        tutorManagement.runTutorManagement();
    }
    
}
