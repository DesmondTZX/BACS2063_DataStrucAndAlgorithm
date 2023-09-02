package control;

import adt.HashMap;
import boundary.ProgrammeManagementUI;

public class ProgrammeManagement {
    private HashMap<Integer, String> programmeMap = new HashMap<>();
    private ProgrammeManagementUI programmeManagementUI = new ProgrammeManagementUI();

    public void start(){
        int choice = -1;
        do{
            choice = programmeManagementUI.getMenuChoice();
            switch(choice){
                // Display All Programmes
                // Add Programme
                // Remove Programme
                // Update Programme
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
        }while(choice != -1);
    }

    public void displayAllProgrammes(){
        String outputStr = "";
        for(int i = 0; i < programmeMap.size(); i++){
            outputStr += programmeMap.get(i) + "\n";
        }
        programmeManagementUI.listAllProgrammes(outputStr);
    }
    public static void main(String[] args) {
        ProgrammeManagement programmeManagement = new ProgrammeManagement();
        programmeManagement.start();
    }
}
