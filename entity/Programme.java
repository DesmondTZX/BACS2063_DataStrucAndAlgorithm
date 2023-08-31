package entity;

public class Programme {
    private int code;
    private String name;
    private int duration;
    private String faculty;

    private TutorialGroup[] tutorialGroup;

    public Programme(int code, String name, int duration, String faculty) {
        this.code = code;
        this.name = name;
        this.duration = duration;
        this.faculty = faculty;
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

    //@Override
    //public int hashCode() {
    //    return code;
    //}

    @Override
    public String toString() {
        return "Programme{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
