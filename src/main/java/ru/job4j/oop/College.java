package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Student university = new Student();
        Freshman dima = new Freshman();
        Object bigObject = university;
        Student firstGrade = dima;
        Object abstractDima = dima;
    }
}
