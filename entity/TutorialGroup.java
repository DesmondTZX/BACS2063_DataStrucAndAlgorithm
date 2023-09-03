package entity;

import java.io.Serializable;
import java.util.Objects;

public class TutorialGroup implements Serializable {
    private String id;
    private String name;
    private int groupNumber;
    private static int nextId = 1;

    public TutorialGroup(String name, int groupNumber) {
        this.id = String.format("TG%04d", nextId++);
        this.name = name;
        this.groupNumber = groupNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        TutorialGroup.nextId = nextId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TutorialGroup that = (TutorialGroup) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TutorialGroup{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", groupNumber=" + groupNumber +
                '}';
    }
}
