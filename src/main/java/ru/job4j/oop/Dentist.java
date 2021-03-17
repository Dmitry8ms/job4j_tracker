package ru.job4j.oop;

public class Dentist extends Doctor {
    private String expertise;

    public Dentist(String degree, String expertise) {
        super.setDegree(degree);
        this.expertise = expertise;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public void attendTeeth(Pacient pacient) { }
}
