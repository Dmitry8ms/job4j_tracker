package ru.job4j.oop;

public class Engineer extends Profession {
    private String company;

    public String getProject() {
        return company;
    }

    public void setProject(String project) {
        this.company = company;
    }

    public Project developProject(Client client) {
        return new Project();
    }
}
