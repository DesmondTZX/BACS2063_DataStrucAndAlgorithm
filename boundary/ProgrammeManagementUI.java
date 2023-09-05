package boundary;

/**
 *
 * @author Wong Fu Lim
 *
 */

import entity.*;
import java.util.Scanner;

public class ProgrammeManagementUI {
    Scanner sc = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    // Menu
    public int getMenuChoice() {
        System.out.println(ANSI_GREEN + "╔═════════════════════════════════════════════╗");
        System.out.println("║              " + ANSI_PURPLE + "Programme Menu" + ANSI_GREEN + "                 ║");
        System.out.println("╠═════════════════════════════════════════════╣");
        System.out.println("║ " + ANSI_BLUE + "1. Display All Programmes" + ANSI_GREEN + "                   ║");
        System.out.println("║ " + ANSI_BLUE + "2. Add Programme" + ANSI_GREEN + "                            ║");
        System.out.println("║ " + ANSI_BLUE + "3. Remove Programme" + ANSI_GREEN + "                         ║");
        System.out.println("║ " + ANSI_BLUE + "4. Update Programme" + ANSI_GREEN + "                         ║");
        System.out.println("║ " + ANSI_BLUE + "5. Search Programme" + ANSI_GREEN + "                         ║");
        System.out.println("║ " + ANSI_BLUE + "6. Display ALl Tutorial Groups" + ANSI_GREEN + "              ║");
        System.out.println("║ " + ANSI_BLUE + "7. Create New Tutorial Group" + ANSI_GREEN + "                ║");
        System.out.println("║ " + ANSI_BLUE + "8. Add Tutorial Group to a Programme" + ANSI_GREEN + "        ║");
        System.out.println("║ " + ANSI_BLUE + "9. Remove Tutorial Group from a Programme" + ANSI_GREEN + "   ║");
        System.out.println("║ " + ANSI_BLUE + "10. List All Tutorial Groups in a Programme" + ANSI_GREEN + " ║");
        System.out.println("║ " + ANSI_BLUE + "11. Generate Programme Report" + ANSI_GREEN + "               ║");
        System.out.println("║ " + ANSI_RED + "0. Exit" + ANSI_GREEN + "                                     ║");
        System.out.println("╚═════════════════════════════════════════════╝" + ANSI_RESET);
        int choice = getEnterChoice();
        sc.nextLine(); // Consume the newline character
        System.out.println();
        return choice;
    }

    public int getSearchMenuChoice() {
        System.out.println(ANSI_GREEN + "╔═════════════════════════════════════════════╗");
        System.out.println("║              " + ANSI_PURPLE + "Search Programme" + ANSI_GREEN + "               ║");
        System.out.println("╠═════════════════════════════════════════════╣");
        System.out.println("║ " + ANSI_BLUE + "1. Search by Programme Code" + ANSI_GREEN + "                 ║");
        System.out.println("║ " + ANSI_BLUE + "2. Search by Programme Name" + ANSI_GREEN + "                 ║");
        System.out.println("║ " + ANSI_RED + "0. Exit" + ANSI_GREEN + "                                     ║");
        System.out.println("╚═════════════════════════════════════════════╝" + ANSI_RESET);
        int choice = getEnterChoice();
        sc.nextLine(); // Consume the newline character
        System.out.println();
        return choice;
    }

    //Output
    public void listProgrammes(String outputStr) {
        System.out.printf("%-8s%-30s%-15s%-10s%-10s%-10s", "Code", "Name", "Type", "Duration", "Faculty", "Tutorial Group" + "\n");
        System.out.println(outputStr);
    }

    public void listTutorialGroups(String outputStr) {
        System.out.printf("%-10s %-12s %-6s", "Group ID", "Group Name", "Group Number" + "\n");
        System.out.println(outputStr);
    }

    public void displayProgrammeReport(Programme programme) {
        String straightLine = "---------------------------------------------";

        System.out.println();
        System.out.println(straightLine);
        System.out.println(ANSI_PURPLE + "Programme Report");
        System.out.print(ANSI_RESET);
        System.out.println(straightLine);
        System.out.println("Programme Code: " + ANSI_GREEN + programme.getCode());
        System.out.print(ANSI_RESET);
        System.out.println("Programme Name: " + ANSI_GREEN + programme.getName());
        System.out.print(ANSI_RESET);
        System.out.println("Programme Type: " + ANSI_GREEN + programme.getType());
        System.out.print(ANSI_RESET);
        System.out.println("Programme Duration: " + ANSI_GREEN + programme.getDuration());
        System.out.print(ANSI_RESET);
        System.out.println("Programme Faculty: " + ANSI_GREEN + programme.getFaculty());
        System.out.print(ANSI_RESET);
        System.out.println(straightLine);
        System.out.println();

        System.out.printf("%-10s %-12s %-6s", "Group ID", "Group Name", "Group Number" + "\n");
        for (TutorialGroup tutorialGroup : programme.getTutorialGroup().values()) {
            System.out.print(ANSI_GREEN);
            System.out.printf("%-10s %-12s %-2s", tutorialGroup.getId(), tutorialGroup.getName(), tutorialGroup.getGroupNumber() + "\n");
        }
        System.out.print(ANSI_RESET);
        System.out.println(straightLine);
        System.out.println("Total number of tutorial groups: " + ANSI_GREEN + programme.getTutorialGroup().size());
        System.out.print(ANSI_RESET);
        System.out.println(straightLine);
    }

    //Input
    public int getEnterChoice() {
        System.out.print("Enter choice: ");
        return sc.nextInt();
    }

    public void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        sc.nextLine();
    }

    public String inputProgrammeCodeToAddUpdateRemoveSearch() {
        System.out.print("Enter Programme Code to add/update/remove/search: ");
        return sc.nextLine();
    }

    public String inputProgrammeNameToSearch() {
        System.out.print("Enter Programme Name to search: ");
        return sc.nextLine();
    }

    public String inputProgrammeCode(String additionalMessage) {
        System.out.print("Enter new Programme Code (Number)" + additionalMessage + ": ");
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
        System.out.print("Enter new Programme Duration (Year) " + additionalMessage + ": ");
        return sc.nextLine();
    }

    public String inputProgrammeFaculty(String additionalMessage) {
        System.out.print("Enter new Programme Faculty " + additionalMessage + ": ");
        return sc.nextLine();
    }

    public int getTutorialGroupChoice() {
        System.out.println("Choose Tutorial Group");
        return sc.nextInt();
    }

    public Programme inputProgrammeDetails(int code) {
        String name = inputProgrammeName("");
        String type = inputProgrammeType("");

        boolean isDurationValid = false;
        int duration = 0;

        do {
            try {
                isDurationValid = true;
                duration = Integer.parseInt(inputProgrammeDuration(""));
            } catch (NumberFormatException e) {
                isDurationValid = false;
                displayInvalidInput();
            }
        } while (!isDurationValid);

        String faculty = inputProgrammeFaculty("");

        return new Programme(code, name, type, duration, faculty);
    }

    public Programme inputProgrammeDetailsToUpdate(Programme programme) {
        listProgrammes(programme.toString());

        String code = inputProgrammeCode(" (Press enter to skip)");
        if (!code.trim().isEmpty())
            programme.setCode(Integer.parseInt(code));

        String name = inputProgrammeName(" (Press enter to skip)");
        if (!name.trim().isEmpty())
            programme.setName(name);

        String type = inputProgrammeType(" (Press enter to skip)");
        if (!type.trim().isEmpty())
            programme.setType(type);

        String durationStr;
        int duration = 0;
        boolean isDurationValid = false;

        do {
            durationStr = inputProgrammeDuration(" (Press enter to skip)");
            if (!durationStr.trim().isEmpty()) {
                try {
                    isDurationValid = true;
                    duration = Integer.parseInt(durationStr);
                    programme.setDuration(duration);
                } catch (NumberFormatException e) {
                    isDurationValid = false;
                    displayInvalidInput();
                }
            }
        } while (!isDurationValid);

        String faculty = inputProgrammeFaculty(" (Press enter to skip)");
        if (!faculty.trim().isEmpty())
            programme.setFaculty(faculty);

        return programme;
    }

    public TutorialGroup inputTutorialGroupDetails(int size) {
        System.out.print("Enter new Tutorial Group Name :");
        String tutorialGroupName = sc.nextLine();
        boolean isGroupNumberValid = false;
        String tutorialGroupNumber = "";
        int groupNumber = 0;
        do {
            System.out.print("Enter new Tutorial Group Number :");
            tutorialGroupNumber = sc.nextLine();
            try {
                isGroupNumberValid = true;
                groupNumber = Integer.parseInt(tutorialGroupNumber);
            } catch (NumberFormatException e) {
                isGroupNumberValid = false;
                displayInvalidInput();
            }

        } while (!isGroupNumberValid);
        return new TutorialGroup(tutorialGroupName, groupNumber, size);
    }

    //Messages
    public void displayProgrammeExists() {
        System.out.println(ANSI_RED + "Programme already exists");
        System.out.println(ANSI_RESET);
    }

    public void displayProgrammeDoesNotExist() {
        System.out.println(ANSI_RED + "Programme does not exist");
        System.out.println(ANSI_RESET);

    }

    public void displayProgrammeAddedMessage() {
        System.out.println(ANSI_GREEN + "Programme added");
        System.out.println(ANSI_RESET);
    }

    public void displayProgrammeUpdatedMessage() {
        System.out.println(ANSI_GREEN + "Programme updated");
        System.out.println(ANSI_RESET);
    }

    public void displayProgrammeRemovedMessage() {
        System.out.println(ANSI_GREEN + "Programme removed");
        System.out.println(ANSI_RESET);
    }

    public void displayTutorialGroupCreatedMessage() {
        System.out.println(ANSI_GREEN + "Tutorial group created");
        System.out.println(ANSI_RESET);
    }

    public void displayTutorialGroupAddedToProgrammeMessage() {
        System.out.println(ANSI_GREEN + "Tutorial group added to programme");
        System.out.println(ANSI_RESET);
    }

    public void displayTutorialGroupRemovedFromProgrammeMessage() {
        System.out.println(ANSI_GREEN + "Tutorial group removed from programme");
        System.out.println(ANSI_RESET);
    }

    public void displayNoTutorialGroupAvailableMessage() {
        System.out.println(ANSI_RED + "No tutorial group available, Please create a new tutorial group first.");
        System.out.println(ANSI_RESET);
    }

    public void displayNoNewTutorialGroupAvailableToProgrammeMessage() {
        System.out.println(ANSI_RED + "No new tutorial groups available for this program. All existing tutorial groups have already been added, Please create a new tutorial group first.");
        System.out.println(ANSI_RESET);
    }

    public void displayNoTutorialGroupAvailableToRemoveFromProgrammeMessage() {
        System.out.println(ANSI_RED + "No tutorial group available to remove from this programme. Please add a tutorial group to this programmefirst.");
        System.out.println(ANSI_RESET);
    }

    public void displayInvalidChoice() {
        System.out.println(ANSI_RED + "Invalid choice");
        System.out.println(ANSI_RESET);
    }

    public void displayInvalidInput() {
        System.out.println(ANSI_RED + "Invalid input. Please enter a number");
        System.out.println(ANSI_RESET);
    }

    public void displayExitMessage() {
        System.out.println(ANSI_YELLOW + "Exiting...");
    }

}
