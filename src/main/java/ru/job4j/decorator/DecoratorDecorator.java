package ru.job4j.decorator;

public class DecoratorDecorator implements Decor {
    private Decor decor;

    public DecoratorDecorator(Decor decor) {
        this.decor = decor;
    }

    @Override
    public void decorate() {
        decor.decorate();
    }
}
