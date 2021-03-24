package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    private String number;
    private int capacity;
    private  double fuelPrice;

    public Bus(String number) {
        this.number = number;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(double fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    @Override
    public void run() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(int number) {
        this.capacity = number;
    }

    @Override
    public double fill(int liters) {
        return getFuelPrice() * liters;
    }

    @Override
    public void move() {
        System.out.println("Передайте деньги за проезд");
    }

    @Override
    public String getInfo() {
        return "Я автобус №" + number;
    }
}
