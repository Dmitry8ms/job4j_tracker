package ru.job4j.oop;

public class Programmer extends Engineer {
    private String level;

    public Programmer(String company, String level) {
        super.setCompany(company);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void code(Project project) { }
}
