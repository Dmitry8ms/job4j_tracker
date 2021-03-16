package ru.job4j.oop;

public class Profession {
    private String name;
    private String surname;
    private String birthday;
    private String education;

    public String getName() {
        return name + " " + surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEducation() {
        return education;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
