package ru.job4j.decorator;

public class Test {
    public static void main(String[] args) {
        //Decor decor = new Decorator();
        //Decor roomDec = new RoomDecor(decor);
        Decor superDec = new CakeDecor(new RoomDecor(new Decorator()));
        superDec.decorate();
    }
}
