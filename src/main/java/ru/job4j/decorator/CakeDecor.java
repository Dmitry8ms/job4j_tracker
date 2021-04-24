package ru.job4j.decorator;

public class CakeDecor extends DecoratorDecorator {
    public CakeDecor(Decor decor) {
        super(decor);
    }

    public void cakeDecor() {
        System.out.println("Decorate cakes");
    }

    @Override
    public void decorate() {
        super.decorate();
        cakeDecor();
    }
}
