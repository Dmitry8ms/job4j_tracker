package ru.job4j.oop;

public class Doctor extends Profession {
    private String degree;

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    public Recipe giveRecipe(Pacient pacient) {
        return new Recipe();
    }
}
