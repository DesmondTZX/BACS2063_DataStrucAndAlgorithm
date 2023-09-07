package dao;

import adt.*;
import entity.Student;
import java.io.*;
import java.util.Iterator;
import utility.*;

/**
 *
 * @author Dong Wei Jie
 */
public class StudentDAO {

    private final String fileName;

    public StudentDAO(String fileName) {
        this.fileName = fileName;
    }

    public void saveToFile(SortedListInterface<Student> studentList) {
        try ( ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            Iterator<Student> studentIterator = studentList.getIterator();
            while (studentIterator.hasNext()) {
                ooStream.writeObject(studentIterator.next());
            }
        } catch (IOException ex) {
            System.err.println("Cannot save to file: " + ex.getMessage());
        }
    }
    
    public SortedListInterface<Student> retrieveFromFile() {
        SortedListInterface<Student> studentList = new SortedLinkedList<>();

        try ( ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj;
            while ((obj = oiStream.readObject()) != null) {
                if (obj instanceof Student student) {
                    studentList.add(student);
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
        return studentList;
    }
}
