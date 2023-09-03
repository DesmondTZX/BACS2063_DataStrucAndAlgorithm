package entity;

import adt.HashMap;
import adt.HashMapInterface;

import java.io.Serializable;
import java.util.ArrayList;

public class Programme implements Serializable {
    private int code;
    private String name;
    private String type;
    private int duration;
    private String faculty;

    private HashMapInterface<String,TutorialGroup> tutorialGroup;

    public Programme(int code) {
        this.code = code;
    }

    public Programme(int code, String name, String type, int duration, String faculty) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.duration = duration;
        this.faculty = faculty;
        tutorialGroup = new HashMap<>();
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

    public HashMapInterface<String, TutorialGroup> getTutorialGroup() {
        return tutorialGroup;
    }

    public void setTutorialGroup(HashMapInterface<String, TutorialGroup> tutorialGroup) {
        this.tutorialGroup = tutorialGroup;
    }
    public void addTutorialGroup(TutorialGroup tutorialGroup) {
        this.tutorialGroup.put(tutorialGroup.getId(), tutorialGroup);
    }

    public void removeTutorialGroup(TutorialGroup tutorialGroup) {
        this.tutorialGroup.remove(tutorialGroup.getId());
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

}
