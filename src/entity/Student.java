/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Dong Wei Jie
 */
public class Student implements Serializable, Comparable<Student> {

    private String studentName;
    private int studentID;
    private String studentEmail;
    private String mode; //full time or parttime
    private String gender;

    public Student() {

    }

    public Student(int studentID) {
        this.studentID = studentID;
    }

    public Student(String studentName, int studentID, String studentEmail, String mode, String gender) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentEmail = studentEmail;
        this.mode = mode;
        this.gender = gender;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.studentID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return Objects.equals(this.studentID, other.studentID);
    }

    @Override
    public String toString() {
        return String.format("|%10s| |%10s| |%20s| |%10s| |%10s|", studentName, studentID, studentEmail, mode, gender);
    }

    @Override
    public int compareTo(Student o) {
        if (this.studentID > o.studentID) {
            return 1;
        } else if (this.studentID == o.studentID) {
            return 0;
        } else {
            return -1;
        }
    }
}
