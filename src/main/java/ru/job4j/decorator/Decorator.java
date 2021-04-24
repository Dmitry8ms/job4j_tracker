package ru.job4j.decorator;

public class Decorator implements Decor {
    @Override
    public void decorate() {
        System.out.println("simply decorate");
    }
}
