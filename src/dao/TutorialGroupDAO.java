package dao;

import adt.*;
import entity.TutorialGroup;

import java.io.*;

/**
 * @author Wong Fu Lim
 */

public class TutorialGroupDAO {
    private String fileName;

    public TutorialGroupDAO(String fileName) {
        this.fileName = fileName;
    }

    public void saveToFile(HashMapInterface<String, TutorialGroup> tutorialGroup) {
        File file = new File(fileName);
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(tutorialGroup);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nFile not found");
        } catch (IOException ex) {
            System.out.println("\nCannot save to file");
        }
    }

    public HashMapInterface<String, TutorialGroup> retrieveFromFile() {
        File file = new File(fileName);
        HashMapInterface<String, TutorialGroup> tutorialGroup = new HashMap<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file));
            tutorialGroup = (HashMap<String, TutorialGroup>) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nNo such file.");
        } catch (IOException ex) {
            System.out.println("\nCannot read from file.");
        } catch (ClassNotFoundException ex) {
            System.out.println("\nClass not found.");
        } finally {
            return tutorialGroup;
        }
    }
}
