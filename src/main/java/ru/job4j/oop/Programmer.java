package ru.job4j.oop;

public class Programmer extends Engineer {
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void code(Project project) { }
}
