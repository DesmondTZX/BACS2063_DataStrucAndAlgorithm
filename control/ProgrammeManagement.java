package control;

import adt.HashMap;
import adt.HashMapInterface;
import boundary.ProgrammeManagementUI;
import dao.ProgrammeDAO;
import dao.TutorialGroupDAO;
import entity.Programme;
import entity.TutorialGroup;

import java.util.ArrayList;


public class ProgrammeManagement {
    private HashMapInterface<Integer, Programme> programmeMap = new HashMap<>();
    private HashMapInterface<String, TutorialGroup> tutorialGroupMap = new HashMap<>();
    private final ProgrammeDAO programmeDAO = new ProgrammeDAO();
    private final TutorialGroupDAO tutorialGroupDAO = new TutorialGroupDAO();
    private final ProgrammeManagementUI programmeManagementUI = new ProgrammeManagementUI();

    public ProgrammeManagement() {
        programmeMap = programmeDAO.retrieveFromFile();
        tutorialGroupMap = tutorialGroupDAO.retrieveFromFile();
    }

    public void start() {
        int choice = 0;
        do {
            choice = programmeManagementUI.getMenuChoice();
            switch (choice) {
                case 1 -> addProgramme();
                case 2 -> removeProgramme();
                case 3 -> updateProgramme();
                case 4 -> {
                    int choice2 = 0;
                    do{
                        choice2 = programmeManagementUI.getSearchMenuChoice();
                        switch (choice2) {
                            case 1 -> searchProgrammeByCode();
                            case 2 -> searchProgrammeByName();
                            default -> programmeManagementUI.displayInvalidChoice();
                        }
                    }while(choice2!=0);

                }
                case 5 -> {
                    int choice3 = 0;
                    do {
                        choice3 = programmeManagementUI.getTutorialMenuChoice();
                        switch (choice3) {
                            case 1 -> createTutorialGroup();
                            case 2 -> addTutorialGroupToProgramme();
                            default -> programmeManagementUI.displayInvalidChoice();
                        }
                    } while (choice3 != 0);
                }
                case 6 -> removeTutorialGroupFromProgramme();
                case 7 -> listAllTutorialGroupInProgramme();
                case 8 -> generateProgrammeReport();
                case 0 -> System.out.println("Exiting...");
                default -> programmeManagementUI.displayInvalidChoice();
            }
        } while (choice != 0);
    }

    public void addProgramme() {
        int code = Integer.parseInt(programmeManagementUI.inputProgrammeCode(""));

        //Avoid duplication
        while (programmeMap.containsKey(code)) {
            programmeManagementUI.displayProgrammeExists();
            code = Integer.parseInt(programmeManagementUI.inputProgrammeCode(""));
        }

        Programme programme = programmeManagementUI.inputProgrammeDetails(code);
        programmeMap.put(programme.hashCode(), programme);
        programmeDAO.saveToFile(programmeMap);
        programmeManagementUI.displayProgrammeAddedMessage();
    }

    public void removeProgramme() {
        int code = Integer.parseInt(programmeManagementUI.inputProgrammeCodeToSearchUpdateRemove());
        Programme removedProgramme = programmeMap.remove(code);
        programmeDAO.saveToFile(programmeMap);
        if (removedProgramme == null) {
            programmeManagementUI.displayProgrammeDoesNotExist();
        } else {
            programmeManagementUI.displayProgrammeRemovedMessage();
        }
    }

    public void updateProgramme() {
        int code = Integer.parseInt(programmeManagementUI.inputProgrammeCodeToSearchUpdateRemove());
        while (!programmeMap.containsKey(code)) {
            programmeManagementUI.displayProgrammeDoesNotExist();
            code = Integer.parseInt(programmeManagementUI.inputProgrammeCodeToSearchUpdateRemove());
        }
        Programme programme = programmeMap.get(code);
        programme = programmeManagementUI.inputProgrammeDetailsToUpdate(programme);

        if (code != programme.getCode()) {
            programmeMap.remove(code);
            programmeMap.put(programme.getCode(), new Programme(programme.getCode(), programme.getName(), programme.getType(), programme.getDuration(), programme.getFaculty()));
        }

        programmeDAO.saveToFile(programmeMap);
        programmeManagementUI.displayProgrammeUpdatedMessage();
    }

    public void searchProgrammeByCode() {
        int code = Integer.parseInt(programmeManagementUI.inputProgrammeCodeToSearchUpdateRemove());
        if (programmeMap.containsKey(code)) {
            Programme programme = programmeMap.get(code);
            programmeManagementUI.listProgramme(programme.toString());
        } else {
            programmeManagementUI.displayProgrammeDoesNotExist();
        }
    }

    public void searchProgrammeByName() {
        String name = programmeManagementUI.inputProgrammeNameToSearch();
        String outputStr = "";
        for (Programme programme : programmeMap.values()) {
            if (programme.getName().toLowerCase().contains(name.toLowerCase())) {
                outputStr += programme + "\n";
            }
        }
        if (outputStr.equals("")) {
            programmeManagementUI.displayProgrammeDoesNotExist();
        } else {
            programmeManagementUI.listProgramme(outputStr);
        }
    }

    public void createTutorialGroup() {
        TutorialGroup tutorialGroup = programmeManagementUI.inputTutorialGroupDetails(tutorialGroupMap.size());
        tutorialGroupMap.put(tutorialGroup.getId(), tutorialGroup);
        programmeManagementUI.displayTutorialGroupCreatedMessage();
        tutorialGroupDAO.saveToFile(tutorialGroupMap);
    }

    public void listAllTutorialGroupInProgramme() {
        for (TutorialGroup tutorialGroup : tutorialGroupMap.values()) {
            programmeManagementUI.listTutorialGroup(tutorialGroup.toString() + "\n");
        }
    }

    public void addTutorialGroupToProgramme() {
        // input programmeCode
        int programmeCode = Integer.parseInt(programmeManagementUI.inputProgrammeCodeToSearchUpdateRemove());
        while (!programmeMap.containsKey(programmeCode)) {
            programmeManagementUI.displayProgrammeDoesNotExist();
            programmeCode = Integer.parseInt(programmeManagementUI.inputProgrammeCodeToSearchUpdateRemove());
        }

        //list all tutorial group
        int i = 1;
        ArrayList<String> tutorialGroupListId = new ArrayList<>();
        for (TutorialGroup tutorialGroup : tutorialGroupMap.values()) {
            programmeManagementUI.listTutorialGroup(i + " ." + tutorialGroup.toString() + "\n");
            tutorialGroupListId.add(tutorialGroup.getId());
            i++;
        }
        if(tutorialGroupListId.size() == 0){
            programmeManagementUI.displayNoTutorialGroup();
            return;
        }
        int choice = programmeManagementUI.getTutorialGroupChoice();
        while(choice < 1 || choice > tutorialGroupListId.size()){
            programmeManagementUI.displayInvalidChoice();
            choice = programmeManagementUI.getTutorialGroupChoice();
        }
        //add tutorial group to programme
        Programme programme = programmeMap.get(programmeCode);
        if (programme.getTutorialGroup().containsKey(tutorialGroupListId.get(choice - 1)))
            programmeManagementUI.displayTutorialGroupAlreadyAdded();
        else
            programme.addTutorialGroup(tutorialGroupMap.get(tutorialGroupListId.get(choice - 1)));
        programmeDAO.saveToFile(programmeMap);

    }

    public void removeTutorialGroupFromProgramme() {
        // input programmeCode
        int programmeCode = Integer.parseInt(programmeManagementUI.inputProgrammeCodeToSearchUpdateRemove());

        while (!programmeMap.containsKey(programmeCode)) {
            programmeManagementUI.displayProgrammeDoesNotExist();
            programmeCode = Integer.parseInt(programmeManagementUI.inputProgrammeCodeToSearchUpdateRemove());
        }

        Programme programme = programmeMap.get(programmeCode);
        //list all tutorial group belong to programme
        HashMapInterface<String, TutorialGroup> tutorialGroups = programme.getTutorialGroup();
        int i = 1;
        ArrayList<String> tutorialGroupListId = new ArrayList<>();
        for (TutorialGroup tutorialGroup : tutorialGroups.values()) {
            programmeManagementUI.listTutorialGroup(i + " ." + tutorialGroup.toString() + "\n");
            tutorialGroupListId.add(tutorialGroup.getId());
            i++;
        }
        if(tutorialGroupListId.size() == 0){
            programmeManagementUI.displayNoTutorialGroup();
            return;
        }
        int choice = programmeManagementUI.getTutorialGroupChoice();
        while(choice < 1 || choice > tutorialGroupListId.size()){
            programmeManagementUI.displayInvalidChoice();
            choice = programmeManagementUI.getTutorialGroupChoice();
        }
        //remove tutorial group from programme
        programme.removeTutorialGroup(tutorialGroupMap.get(tutorialGroupListId.get(choice - 1)));
        programmeDAO.saveToFile(programmeMap);
    }


    public void generateProgrammeReport() {
        String outputStr = "";
        System.out.printf("%-8s%-40s%-15s%-10s%-10s%-80s", "Code", "Name", "Type", "Duration", "Faculty", "Tutorial Group");
        for (Programme programme : programmeMap.values()) {
            outputStr += programme.toString();
        }
        programmeManagementUI.listProgramme(outputStr);
    }

    public static void main(String[] args) {
        ProgrammeManagement programmeManagement = new ProgrammeManagement();
        programmeManagement.start();
    }
}
