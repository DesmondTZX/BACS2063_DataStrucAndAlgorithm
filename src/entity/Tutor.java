package entity;

import java.io.Serializable;
import java.util.Objects;

public class Tutor implements Serializable, Comparable<Tutor> {
    
    private String tutorId;
    private String tutorName;
    private char tutorGender;
    private String tutorEmail;
    private String position;
    private String faculty;
    private String department;
    private String campus;

    public Tutor() {
        
    }

    public Tutor(String tutorId) {
        this.tutorId = tutorId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.tutorId);
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
        final Tutor other = (Tutor) obj;
        return Objects.equals(this.tutorId, other.tutorId);
    }

    public Tutor(String tutorId, String tutorName, char tutorGender, String tutorEmail, String position, String faculty, String department, String campus) {
        this.tutorId = tutorId;
        this.tutorName = tutorName;
        this.tutorGender = tutorGender;
        this.tutorEmail = tutorEmail;
        this.position = position;
        this.faculty = faculty;
        this.department = department;
        this.campus = campus;
    }
    
    @Override
    public int compareTo(Tutor o) {
        return this.tutorId.compareTo(o.tutorId);
    }
    
    public String getTutorId() {
        return tutorId;
    }
    
    public String getTutorName() {
        return tutorName;
    }
    
    public char getGender() {
        return tutorGender;
    }
    
    public String getEmail() {
        return tutorEmail;
    }
    
    public String getPosition() {
        return position;
    }
    
    public String getFaculty() {
        return faculty;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getCampus() {
        return campus;
    }
    
    public void setTutorId(String newTutorId) {
        this.tutorId = newTutorId;
    }
    
    public void setTutorName(String newTutorName) {
        this.tutorName = newTutorName;
    }
    
    public void setGender(char newGender) {
        this.tutorGender = newGender;
    }
    
    public void setEmail(String newEmail) {
        this.tutorEmail = newEmail;
    }
    
    public void setPosition(String newPosition) {
        this.position = newPosition;
    }
    
    public void setFaculty(String newFaculty) {
        this.faculty = newFaculty;
    }
    
    public void setDepartment(String newDepartment) {
        this.department = newDepartment;
    }
    
    public void setCampus(String newCampus) {
        this.campus = newCampus;
    }

    @Override
    public String toString() {
        /* return String.format("%6d %-8s %10.2f", id, name, basicSalary); */
        return String.format("%6s %6s %6c %6s %6s %6s %6s %6s", tutorId, tutorName, tutorGender, tutorEmail, position, faculty, department, campus);
    }
}
