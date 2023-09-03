package dao;

import adt.*;
import entity.Programme;
import java.io.*;
public class ProgrammeDAO {
    private String fileName = "programmes.dat"; // For security and maintainability, should not have filename hardcoded here.

    public void saveToFile(HashMapInterface<Integer, Programme> programmes) {
        File file = new File(fileName);
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(programmes);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nFile not found");
        } catch (IOException ex) {
            System.out.println("\nCannot save to file");
        }
    }

    public HashMapInterface<Integer, Programme> retrieveFromFile() {
        File file = new File(fileName);
        HashMapInterface<Integer, Programme> programmes = new HashMap<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file));
            programmes = (HashMap<Integer, Programme>)(oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nNo such file.");
        } catch (IOException ex) {
            System.out.println("\nCannot read from file.");
        } catch (ClassNotFoundException ex) {
            System.out.println("\nClass not found.");
        } finally {
            return programmes;
        }
    }
}