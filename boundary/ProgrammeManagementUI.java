package boundary;

import adt.HashMapInterface;
import entity.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ProgrammeManagementUI {
    Scanner sc = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("Programme Menu");
        System.out.println("1. Add Programme");
        System.out.println("2. Remove Programme");
        System.out.println("3. Update Programme");
        System.out.println("4. Search Programme");
        System.out.println("5. Add a Tutorial Group to a Programme");
        System.out.println("6. Remove a Tutorial Group from a Programme");
        System.out.println("7. List All Tutorial Group in a Programme");
        System.out.println("8. Generate Programme Report");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        return choice;
    }

    public int getSearchMenuChoice() {
        System.out.println("1. Search by Programme Code");
        System.out.println("2. Search by Programme Name");
        System.out.println("0. Exit");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        return choice;
    }

    public int getTutorialMenuChoice(){
        System.out.println("1. Create Tutorial Group");
        System.out.println("2. Add Tutorial Group to Programme");
        System.out.println("0. Exit");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        return choice;
    }


    public void listProgramme(String outputStr) {
        System.out.println(outputStr);
    }

    public void listTutorialGroup(String outputStr) {
        System.out.println(outputStr);
    }

    public int getTutorialGroupChoice() {
        System.out.println("Choose Tutorial Group");
        return sc.nextInt();
    }

    public String inputProgrammeCodeToSearchUpdateRemove() {
        System.out.print("Enter Programme Code to search/update/remove: ");
        return sc.nextLine();


    }

    public String inputProgrammeNameToSearch(){
        System.out.print("Enter Programme Name to search: ");
        return sc.nextLine();
    }

    public String inputProgrammeCode(String additionalMessage) {
        System.out.print("Enter new Programme Code " + additionalMessage + ": ");
        return sc.nextLine();
    }

    public String inputProgrammeName(String additionalMessage) {
        System.out.print("Enter new Programme Name " + additionalMessage + ": ");
        return sc.nextLine();
    }

    public String inputProgrammeType(String additionalMessage) {
        System.out.print("Enter new Programme Type " + additionalMessage + ": ");
        return sc.nextLine();
    }

    public String inputProgrammeDuration(String additionalMessage) {
        System.out.print("Enter new Programme Duration " + additionalMessage + ": ");
        return sc.nextLine();
    }

    public String inputProgrammeFaculty(String additionalMessage) {
        System.out.print("Enter new Programme Faculty " + additionalMessage + ": ");
        return sc.nextLine();
    }

    public TutorialGroup inputTutorialGroupDetails(int size) {
        System.out.print("Enter new Tutorial Group Name :");
        String tutorialGroupName = sc.nextLine();
        System.out.print("Enter new Tutorial Group Number :");
        String tutorialGroupNumber = sc.nextLine();
        int groupNumber = Integer.parseInt(tutorialGroupNumber);
        return new TutorialGroup(tutorialGroupName, groupNumber,size);
    }


    public Programme inputProgrammeDetails(int code) {
        String name = inputProgrammeName("");
        String type = inputProgrammeType("");
        int duration = Integer.parseInt(inputProgrammeDuration(""));
        String faculty = inputProgrammeFaculty("");
        return new Programme(code, name, type, duration, faculty);
    }

    public void displayProgrammeDoesNotExist() {
        System.out.println("Programme does not exist");
    }

    public void displayProgrammeExists() {
        System.out.println("Programme already exists");
    }

    public void displayProgrammeAddedMessage() {
        System.out.println("Programme added");
    }

    public void displayProgrammeRemovedMessage() {
        System.out.println("Programme removed");
    }

    public void displayProgrammeUpdatedMessage() {
        System.out.println("Programme updated");
    }

    public void displayTutorialGroupCreatedMessage() {
        System.out.println("Tutorial group created");
    }

    public void displayTutorialGroupAlreadyAdded(){
        System.out.println("Tutorial group already added to this programme");
    }

    public void displayInvalidChoice() {
        System.out.println("Invalid choice");
    }

    public void displayNoTutorialGroup(){
        System.out.println("No tutorial group in this programme");
    }

    public Programme inputProgrammeDetailsToUpdate(Programme programme) {
        System.out.println("Programme Code   Programme Name   Programme Type   Programme Duration   Programme Faculty");
        System.out.printf("%10d %10s %10s %10d %10s", programme.getCode(), programme.getName(), programme.getType(), programme.getDuration(), programme.getFaculty());
        System.out.println();

        String code = inputProgrammeCode(" (Press enter to skip)");
        if(!code.trim().isEmpty())
            programme.setCode(Integer.parseInt(code));

        String name = inputProgrammeName(" (Press enter to skip)");
        if(!name.trim().isEmpty())
            programme.setName(name);

        String type = inputProgrammeType(" (Press enter to skip)");
        if(!type.trim().isEmpty())
            programme.setType(type);

        String duration = inputProgrammeDuration(" (Press enter to skip)");
        if(!duration.trim().isEmpty())
            programme.setDuration(Integer.parseInt(duration));

        String faculty = inputProgrammeFaculty(" (Press enter to skip)");
        if(!faculty.trim().isEmpty())
            programme.setFaculty(faculty);

        return programme;






    }
}
