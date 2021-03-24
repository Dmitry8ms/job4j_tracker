package ru.job4j.poly;

public class Train implements Vehicle {
    private String destination;

    public Train(String destination) {
        this.destination = destination;
    }

    @Override
    public void move() {
        System.out.println("Ту - тууууу!");
    }

    @Override
    public String getInfo() {
        return "Я поезд " + destination;
    }
}
