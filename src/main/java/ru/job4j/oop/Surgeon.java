package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String expertise;

    public Surgeon(String degree, String expertise) {
        super.setDegree(degree);
        this.expertise = expertise;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public void makeOperation(Pacient pacient) {    }
}
