package control;

/**
 *
 * @author Wong Fu Lim
 *
 */

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
        boolean isExit;
        do {
            isExit = false;
            choice = programmeManagementUI.getMenuChoice();
            switch (choice) {
                case 1 -> displayAllProgramme();
                case 2 -> addProgramme();
                case 3 -> {
                    displayAllProgramme();
                    removeProgramme();
                }
                case 4 -> {
                    displayAllProgramme();
                    updateProgramme();
                }
                case 5 -> {
                    int choice2 = 0;
                    do {
                        choice2 = programmeManagementUI.getSearchMenuChoice();
                        switch (choice2) {
                            case 1 -> searchProgrammeByCode();
                            case 2 -> searchProgrammeByName();
                            case 0 -> isExit = true;
                            default -> programmeManagementUI.displayInvalidChoice();
                        }
                        if (choice2 != 0)
                            programmeManagementUI.pressEnterToContinue();

                    } while (choice2 != 0);

                }
                case 6 -> listAllTutorialGroup();
                case 7 -> createTutorialGroup();
                case 8 -> {
                    displayAllProgramme();
                    addTutorialGroupToProgramme();
                }
                case 9 -> {
                    displayAllProgramme();
                    removeTutorialGroupFromProgramme();
                }
                case 10 -> {
                    displayAllProgramme();
                    listAllTutorialGroupInProgramme();
                }
                case 11 -> {
                    displayAllProgramme();
                    generateProgrammeReport();
                }
                case 0 -> {
                    programmeManagementUI.displayExitMessage();
                    isExit = true;
                }
                default -> programmeManagementUI.displayInvalidChoice();
            }
            if (!isExit)
                programmeManagementUI.pressEnterToContinue();
        } while (choice != 0);
    }

    public void displayAllProgramme() {
        StringBuilder sb = new StringBuilder();
        for (Programme programme : programmeMap.values()) {
            sb.append(programme.toString());
        }
        programmeManagementUI.listProgrammes(sb.toString());
    }

    public void addProgramme() {
        int code = validateInputProgrammeCode();

        while (programmeMap.containsKey(code)) {
            programmeManagementUI.displayProgrammeExists();
            code = validateInputProgrammeCode();
        }

        Programme programme = programmeManagementUI.inputProgrammeDetails(code);
        programmeMap.put(programme.getCode(), programme);
        programmeDAO.saveToFile(programmeMap);
        programmeManagementUI.displayProgrammeAddedMessage();
    }

    public void removeProgramme() {
        int code = validateInputProgrammeCode();
        Programme removedProgramme = programmeMap.remove(code);

        if (removedProgramme == null) {
            programmeManagementUI.displayProgrammeDoesNotExist();
        } else {
            programmeDAO.saveToFile(programmeMap);
            programmeManagementUI.displayProgrammeRemovedMessage();
        }
    }

    public void updateProgramme() {
        int programmeCode = validateProgrammeCodeExist();

        Programme programme = programmeMap.get(programmeCode);
        programme = programmeManagementUI.inputProgrammeDetailsToUpdate(programme);

        // if code is changed, remove the old code and add the new code
        if (programmeCode != programme.getCode()) {
            programmeMap.remove(programmeCode);
            programmeMap.put(programme.getCode(), programme);
        }

        programmeDAO.saveToFile(programmeMap);
        programmeManagementUI.displayProgrammeUpdatedMessage();
    }

    public void searchProgrammeByCode() {
        int code = validateInputProgrammeCode();

        if (programmeMap.containsKey(code)) {
            Programme programme = programmeMap.get(code);
            programmeManagementUI.listProgrammes(programme.toString());
        } else {
            programmeManagementUI.displayProgrammeDoesNotExist();
        }
    }

    public void searchProgrammeByName() {
        String name = programmeManagementUI.inputProgrammeNameToSearch();

        StringBuilder sb = new StringBuilder();

        for (Programme programme : programmeMap.values()) {
            if (programme.getName().toLowerCase().contains(name.toLowerCase())) {
                sb.append(programme + "\n");
            }
        }

        if (sb.toString().isEmpty()) {
            programmeManagementUI.displayProgrammeDoesNotExist();
        } else {
            programmeManagementUI.listProgrammes(sb.toString());
        }
    }

    public void createTutorialGroup() {
        TutorialGroup tutorialGroup = programmeManagementUI.inputTutorialGroupDetails(tutorialGroupMap.size());
        //No need to check if tutorial group exists as tutorial group id is auto generated
        tutorialGroupMap.put(tutorialGroup.getId(), tutorialGroup);
        tutorialGroupDAO.saveToFile(tutorialGroupMap);
        programmeManagementUI.displayTutorialGroupCreatedMessage();
    }

    public void listAllTutorialGroup() {
        StringBuilder sb = new StringBuilder();
        for (TutorialGroup tutorialGroup : tutorialGroupMap.values()) {
            sb.append(tutorialGroup.toString());
        }
        programmeManagementUI.listTutorialGroups(sb.toString());
    }

    public void listAllTutorialGroupInProgramme() {
        int programmeCode = validateProgrammeCodeExist();

        if (programmeMap.get(programmeCode).getTutorialGroup().isEmpty()) {
            programmeManagementUI.displayNoTutorialGroupAvailableMessage();
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (TutorialGroup tutorialGroup : programmeMap.get(programmeCode).getTutorialGroup().values()) {
            sb.append(tutorialGroup.toString());
        }
        programmeManagementUI.listTutorialGroups(sb.toString());
    }

    public void addTutorialGroupToProgramme() {

        if (tutorialGroupMap.isEmpty()) {
            programmeManagementUI.displayNoTutorialGroupAvailableMessage();
            return;
        }

        int programmeCode = validateProgrammeCodeExist();

        Programme programme = programmeMap.get(programmeCode);
        HashMapInterface<String, TutorialGroup> tGroupMapForProgramme = programme.getTutorialGroup();

        int i = 1;
        ArrayList<String> tutorialGroupIdList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (TutorialGroup tutorialGroup : tutorialGroupMap.values()) {
            if (!tGroupMapForProgramme.containsKey(tutorialGroup.getId())) {
                tutorialGroupIdList.add(tutorialGroup.getId());
                sb.append(i + ". ");
                sb.append(tutorialGroup.toString() + "\n");
                i++;
            }
        }

        if (tutorialGroupIdList.size() == 0) {
            programmeManagementUI.displayNoNewTutorialGroupAvailableToProgrammeMessage();
            return;
        }

        programmeManagementUI.listTutorialGroups(sb.toString());

        int choice = programmeManagementUI.getTutorialGroupChoice();
        while (choice < 1 || choice > tutorialGroupIdList.size()) {
            programmeManagementUI.displayInvalidChoice();
            choice = programmeManagementUI.getTutorialGroupChoice();
        }


        programme.addTutorialGroup(tutorialGroupMap.get(tutorialGroupIdList.get(choice - 1)));
        programmeDAO.saveToFile(programmeMap);
        programmeManagementUI.displayTutorialGroupAddedToProgrammeMessage();
    }

    public void removeTutorialGroupFromProgramme() {
        int programmeCode = validateProgrammeCodeExist();

        Programme programme = programmeMap.get(programmeCode);
        HashMapInterface<String, TutorialGroup> tutorialGroups = programme.getTutorialGroup();

        int i = 1;
        ArrayList<String> tutorialGroupListId = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (TutorialGroup tutorialGroup : tutorialGroups.values()) {
            tutorialGroupListId.add(tutorialGroup.getId());
            sb.append(i + ". ");
            sb.append(tutorialGroup.toString() + "\n");
            i++;
        }
        if (tutorialGroupListId.size() == 0) {
            programmeManagementUI.displayNoTutorialGroupAvailableToRemoveFromProgrammeMessage();
            return;
        }
        programmeManagementUI.listTutorialGroups(sb.toString());

        int choice = programmeManagementUI.getTutorialGroupChoice();
        while (choice < 1 || choice > tutorialGroupListId.size()) {
            programmeManagementUI.displayInvalidChoice();
            choice = programmeManagementUI.getTutorialGroupChoice();
        }
        programme.removeTutorialGroup(tutorialGroupMap.get(tutorialGroupListId.get(choice - 1)));
        programmeDAO.saveToFile(programmeMap);
        programmeManagementUI.displayTutorialGroupRemovedFromProgrammeMessage();
    }

    public void generateProgrammeReport() {
        int programmeCode = validateProgrammeCodeExist();
        Programme programme = programmeMap.get(programmeCode);
        programmeManagementUI.displayProgrammeReport(programme);
    }

    private int validateProgrammeCodeExist() {
        int programmeCode = validateInputProgrammeCode();

        while (!programmeMap.containsKey(programmeCode)) {
            programmeManagementUI.displayProgrammeDoesNotExist();
            programmeCode = validateInputProgrammeCode();
        }
        return programmeCode;
    }

    private int validateInputProgrammeCode() {
        int code = 0;
        boolean isValidInput = false;
        do {
            try {
                code = Integer.parseInt(programmeManagementUI.inputProgrammeCodeToAddUpdateRemoveSearch());
                isValidInput = true;
            } catch (NumberFormatException e) {
                isValidInput = false;
                programmeManagementUI.displayInvalidInput();
            }
        } while (!isValidInput);
        return code;
    }

    public static void main(String[] args) {
        ProgrammeManagement programmeManagement = new ProgrammeManagement();
        programmeManagement.start();
    }
}
