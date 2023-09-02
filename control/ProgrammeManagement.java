package control;

import adt.HashMap;
import boundary.ProgrammeManagementUI;
import entity.Programme;


public class ProgrammeManagement {
    private HashMap<Integer, Programme> programmeMap = new HashMap<>();
    private ProgrammeManagementUI programmeManagementUI = new ProgrammeManagementUI();

    public void start() {
        int choice = -1;
        do {
            choice = programmeManagementUI.getMenuChoice();
            switch (choice) {
                // Display All Programmes
                case 1:
                    displayAllProgrammes();
                    break;
                // Add Programme
                case 2:
                    addProgramme();
                    break;
                // Remove Programme
                case 3:
                    removeProgramme();
                    break;
                // Update Programme
                case 4:
                    updateProgramme();
                    break;
                // Search Programme
                // Sort Programme
                // Add a Tutorial Group to a Programme
                // Remove a Tutorial Group from a Programme
                // List All Tutorial Group in a Programme
                // Generate Programme Report
                case -1:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != -1);
    }

    public void addProgramme() {
        int code = programmeManagementUI.inputProgrammeCode();

        //Avoid duplication
        while (programmeMap.containsKey(code)) {
            System.out.println("Programme code already exists");
            code = programmeManagementUI.inputProgrammeCode();

        }

        String name = programmeManagementUI.inputProgrammeName();
        String type = programmeManagementUI.inputProgrammeType();
        int duration = programmeManagementUI.inputProgrammeDuration();
        String faculty = programmeManagementUI.inputProgrammeFaculty();
        Programme programme = new Programme(code, name, type, duration, faculty);
        programmeMap.put(programme.hashCode(), programme);
    }

    public void displayAllProgrammes() {
        String outputStr = "";
        for (Programme programme : programmeMap.values()) {
            outputStr += programme.toString() + "\n";
        }
        programmeManagementUI.listAllProgrammes(outputStr);
    }

    public void removeProgramme() {
        int code = programmeManagementUI.inputProgrammeCodeToUpdateRemove();
        Programme programme = new Programme(code);
        Programme removedProgramme = programmeMap.remove(programme.hashCode());
        if(removedProgramme == null){
            System.out.println("Programme code does not exist");
        }
        else{
            System.out.println("Programme removed");
        }
    }

    public void updateProgramme() {
        int choice = -1;
        do {
            choice = programmeManagementUI.getUpdateMenuChoice();
            switch (choice) {
                case 1:
                    int code = programmeManagementUI.inputProgrammeCodeToUpdateRemove();
                    int newCode = programmeManagementUI.inputProgrammeCode();
                    // move to exiting programme properties except old code to the new programme with new code
                    Programme programme = programmeMap.get(code);
                    programmeMap.remove(code);
                    programmeMap.put(newCode, new Programme(newCode, programme.getName(), programme.getType(), programme.getDuration(), programme.getFaculty()));
                    break;
                case 2:
                    code = programmeManagementUI.inputProgrammeCodeToUpdateRemove();
                    break;

            }
        } while (choice != -1);
        //Update Programme code
        // Update Programme name
        // Update Programme type
        // Update Programme duration
        // Update Programme faculty
    }


    public static void main(String[] args) {
        ProgrammeManagement programmeManagement = new ProgrammeManagement();
        programmeManagement.start();
    }
}
