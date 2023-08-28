package dao;

import adt.*;
import entity.Tutor;
import java.io.*;

public class TutorDAO {
    private String fileName;
    
    public TutorDAO(String fileName) {
        this.fileName = fileName;
    }
    
    public void saveToFile(SortedListInterface<Tutor> tutorList) {
        try (ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            ooStream.writeObject(tutorList);
        } catch (IOException ex) {
            System.err.println("Cannot save to file: " + ex.getMessage());
        }
    }
    
    public SortedListInterface<Tutor> retrieveFromFile() {
        SortedListInterface<Tutor> tutorList = new SortedArrayList<>();
        try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName))) {
            tutorList = (SortedArrayList<Tutor>) oiStream.readObject();
        } catch (IOException ex) {
            System.err.println("Cannot read from file: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found: " + ex.getMessage());
        }
        return tutorList;
    }
}
