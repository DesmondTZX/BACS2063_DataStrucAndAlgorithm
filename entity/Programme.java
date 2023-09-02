package entity;

import java.util.ArrayList;

public class Programme implements Comparable<Programme> {
    private int code;
    private String name;
    private String type;
    private int duration;
    private String faculty;

    private ArrayList<TutorialGroup> tutorialGroup;

    public Programme(int code) {
        this.code = code;
    }

    public Programme(int code, String name, String type, int duration, String faculty) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.duration = duration;
        this.faculty = faculty;
    }

    public Programme(int code, String name, String type, int duration, String faculty, ArrayList<TutorialGroup> tutorialGroup) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.duration = duration;
        this.faculty = faculty;
        this.tutorialGroup = tutorialGroup;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public ArrayList<TutorialGroup> getTutorialGroup() {
        return tutorialGroup;
    }

    public void setTutorialGroup(ArrayList<TutorialGroup> tutorialGroup) {
        this.tutorialGroup = tutorialGroup;
    }

    @Override
    public int hashCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programme programme = (Programme) o;
        return code == programme.code;
    }

    @Override
    public String toString() {
        return "Programme{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", duration=" + duration +
                ", faculty='" + faculty + '\'' +
                ", tutorialGroup=" + tutorialGroup +
                '}';
    }

    @Override
    public int compareTo(Programme o) {
        if (this.code > o.code) {
            return 1;
        } else if (this.code < o.code) {
            return -1;
        } else {
            return 0;
        }
    }
}
