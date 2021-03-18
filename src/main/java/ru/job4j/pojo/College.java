package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.Month;

public class College {
    public static void main(String[] args) {
        Student ivan = new Student();
        ivan.setFio("Иван Иванович Иванов");
        ivan.setGroup("1001k");
        LocalDate enterDate = LocalDate.of(2000, Month.AUGUST, 21);
        ivan.setEnterDate(enterDate);
        ivan.printStudentData();
    }
}
