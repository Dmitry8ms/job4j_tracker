package ru.job4j.poly;

public class Dispatcher {
    public static void main(String[] args) {
        Vehicle a380 = new Jet("a2121");
        Vehicle trans = new Train("Томск - Москва");
        Vehicle cityBus = new Bus("11a");
        Vehicle[] transport = new Vehicle[]{a380, trans, cityBus};
        for (Vehicle v : transport) {
            System.out.println(v.getInfo());
            v.move();
        }
    }
}
