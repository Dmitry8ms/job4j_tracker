package ru.job4j.decorator;

public class RoomDecor extends DecoratorDecorator {

    public RoomDecor(Decor decor) {
        super(decor);
    }

    public void roomDecor() {
        System.out.println(" Room decor");
    }

    @Override
    public void decorate() {
        super.decorate();
        roomDecor();
    }
}
