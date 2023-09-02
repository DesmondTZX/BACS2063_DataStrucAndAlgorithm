package entity;

import java.util.ArrayList;

public class Programme implements Comparable<Programme> {
    private int code;
    private String name;
    private String type;
    private int duration;
    private String faculty;

    private ArrayList<TutorialGroup> tutorialGroup;

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
