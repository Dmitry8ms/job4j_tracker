package ru.job4j.poly;

public class Jet implements Vehicle {
    private String flight;

    public Jet(String flight) {
        this.flight = flight;
    }

    @Override
    public void move() {
        System.out.println("Всем пассажира приятного полета");
    }

    @Override
    public String getInfo() {
        return "Я самолет, рейс №" + flight;
    }
}
