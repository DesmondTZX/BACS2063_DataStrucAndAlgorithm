package entity;

public class Tutor {
    
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
}
