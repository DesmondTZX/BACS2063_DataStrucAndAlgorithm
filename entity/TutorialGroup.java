package entity;

import java.io.Serializable;
import java.util.Objects;

public class TutorialGroup implements Serializable {
    private String id;
    private String name;
    private int groupNumber;

    public TutorialGroup(String name, int groupNumber,int nextId) {
        this.id = String.format("TG%04d", ++nextId);
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
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-12s %-6s\n", id, name, groupNumber));
        return sb.toString();
    }
}
