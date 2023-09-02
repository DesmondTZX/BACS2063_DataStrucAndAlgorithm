package boundary;

import java.util.Scanner;
import entity.Tutor;

public class TutorManagementUI {
    
    Scanner scanner = new Scanner(System.in);
    
   public int getMenuChoice() {
    System.out.println("\nMAIN MENU");
    System.out.println("1. Add new tutor");
    System.out.println("2. List all tutors");
    System.out.println("3. Remove a tutor");
    System.out.println("4. Modify a tutor");
    System.out.println("5. List all tutors based on fliter criteria");
    System.out.println("6. Generate Report");
    System.out.println("0. Quit");
    System.out.print("Enter choice: ");
    int choice = scanner.nextInt();
    scanner.nextLine();
    System.out.println();
    return choice;
  }

  public void listAllTutors(String outputStr) {
    System.out.println("\nList of Tutors:\n" + outputStr);
  }

  public void printTutorDetails(Tutor tutor) {
    System.out.println("Tutor Details");
    
    System.out.println("Tutor id:" + tutor.getTutorId());
    System.out.println("Tutor name: " + tutor.getTutorName());
    System.out.println("Tutor gender: " + tutor.getGender());
    System.out.println("Tutor email: " + tutor.getEmail());
    System.out.println("Tutor position: " + tutor.getPosition());
    System.out.println("Tutor faculty: " + tutor.getFaculty());
    System.out.println("Tutor department:" + tutor.getDepartment());
    System.out.println("Tutor campus: " + tutor.getCampus());
  }

  public String generateProductCode() {
    int idCounter = 1;
    System.out.print("Tutor ID generated.\n");
    return "p" + idCounter++;
  } // TODO: made this look better ig 
  
  public String inputTutorID() {
    System.out.print("Enter tutor ID for the Tutors you want to remove/modify: ");
    String id = scanner.nextLine();
    return id;
  }
  
  public String inputTutorName() {
    System.out.print("Enter tutor name: ");
    String name = scanner.nextLine();
    return name;
  }
  
  // TODO: gender and email will have to be input manually but will do some format checkings
  public char inputTutorGender() {
    System.out.print("Enter tutor gender: ");
    char gender = scanner.next().charAt(0);
    scanner.nextLine();
    return gender;
  }
  
  public String inputTutorEmail() {
    System.out.print("Enter tutor email: ");
    String email = scanner.nextLine();
    return email;
  }
  // TODO: gender and email will have to be input manually but will do some format checkings
  
  public String inputTutorPosition() {
    System.out.print("Enter tutor position: ");
    String position = scanner.nextLine();
    return position;
  }
  
  public String inputTutorFaculty() {
    System.out.print("Enter tutor faculty: ");
    String faculty = scanner.nextLine();
    return faculty;
  }
  
  public String inputTutorDepartment() {
    System.out.print("Enter tutor department: ");
    String department = scanner.nextLine();
    return department;
  }
  
  public String inputTutorCampus() {
    System.out.print("Enter tutor campus: ");
    String campus = scanner.nextLine();
    return campus;
  }

  public Tutor inputTutorDetails() {
    String tutorId = generateProductCode();
    String tutorName = inputTutorName();
    char tutorGender = inputTutorGender();
    String tutorEmail = inputTutorEmail();
    String tutorPosition = inputTutorPosition();
    String tutorFaculty = inputTutorFaculty();
    String tutorDepartment = inputTutorDepartment();
    String tutorCampus = inputTutorCampus();
    System.out.println();
    return new Tutor(tutorId, tutorName, tutorGender, tutorEmail, tutorPosition, tutorFaculty, tutorDepartment, tutorCampus);
  }
  
  public int selectCriteria() {
    System.out.println("\nSelect Criteria:");
    System.out.println("1. Tutor ID");
    System.out.println("2. Tutor Name");
    System.out.println("3. Tutor Gender");
    System.out.println("4. Tutor Email");
    System.out.println("5. Tutor Position");
    System.out.println("6. Tutor Faculty");
    System.out.println("7. Tutor Department");
    System.out.println("8. Tutor Campus");
    System.out.println("0. Back to Main Menu");
    System.out.print("Enter choice: ");
    int choice = scanner.nextInt();
    scanner.nextLine();
    System.out.println();
    return choice;
  }
}
