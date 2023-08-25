package boundary;

import java.util.Scanner;
import entity.Tutor;

public class TutorManagementUI {
    
    Scanner scanner = new Scanner(System.in);
    
    public int getMenuChoice() {
    System.out.println("\nMAIN MENU");
    System.out.println("1. Add new product");
    System.out.println("2. List all products");
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
    throw new UnsupportedOperationException();
  } // TODO: just randomly generate the Id for this i think, may need to see how tutor id looks like

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
}
