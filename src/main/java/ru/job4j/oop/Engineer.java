package ru.job4j.oop;

public class Engineer extends Profession {
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String project) {
        this.company = company;
    }

    public Project developProject(Client client) {
        return new Project();
    }
}
