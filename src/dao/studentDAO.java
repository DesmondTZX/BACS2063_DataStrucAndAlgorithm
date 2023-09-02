/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import adt.*;
import entity.Student;
import java.io.*;
import java.util.Iterator;

/**
 *
 * @author Jack
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
        SortedListInterface<Student> studentList = new SortedList<>();

        try ( ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj;
            while ((obj = oiStream.readObject()) != null) {
                if (obj instanceof Student) {
                    studentList.add((Student) obj);
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
