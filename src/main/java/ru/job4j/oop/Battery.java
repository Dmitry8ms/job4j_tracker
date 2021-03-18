package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery anotherBattery) {
        anotherBattery.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery bat1 = new Battery(100);
        Battery bat2 = new Battery(150);
        bat2.exchange(bat1);
        System.out.println("Battery 1 charge: " + bat1.load + " battery 2 charge: " + bat2.load);
    }
}
