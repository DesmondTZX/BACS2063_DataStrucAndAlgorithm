package dao;

import adt.*;
import entity.Tutor;
import java.io.*;
import java.util.Iterator;

public class TutorDAO {
    private final String fileName;
    
    public TutorDAO(String fileName) {
        this.fileName = fileName;
    }
    
    public void saveToFile(SortedListInterface<Tutor> tutorList) {
        try (ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            Iterator<Tutor> tutorIterator = tutorList.getIterator();
            while (tutorIterator.hasNext()) {
                ooStream.writeObject(tutorIterator.next());
            }
        } catch (IOException ex) {
            System.err.println("Cannot save to file: " + ex.getMessage());
        }
    }

    
    public SortedListInterface<Tutor> retrieveFromFile() {
        SortedListInterface<Tutor> tutorList = new SortedLinkedList<>();

        try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj;
            while ((obj = oiStream.readObject()) != null) {
                if (obj instanceof Tutor) {
                    tutorList.add((Tutor) obj);
                } else {
                    System.err.println("Invalid object type found in the file.");
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + ex.getMessage());
        } catch (EOFException ex) {
            // Expected exception when the end of the file is reached
        } catch (IOException ex) {
            System.err.println("Cannot read from file: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found: " + ex.getMessage());
        }

        return tutorList;
    }



}
