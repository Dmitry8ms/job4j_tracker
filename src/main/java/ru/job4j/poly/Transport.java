package ru.job4j.poly;

public interface Transport {
    public void run();

    public void passengers(int number);

    public double fill(int liters);
}
