package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private String fio;
    private String group;
    private LocalDate enterDate;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(LocalDate enterDate) {
        this.enterDate = enterDate;
    }

    public void printStudentData() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("ФИО: " + this.getFio() + System.lineSeparator()
            + "Группа: " + this.getGroup() + System.lineSeparator()
            + "Дата поступления: " + this.getEnterDate().format(format));
    }
}
