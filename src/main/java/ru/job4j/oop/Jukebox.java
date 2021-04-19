package ru.job4j.oop;

public class Jukebox {

    public void song(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public String song(int position, String line) {
        return line + " " + position;
    }

    public static void main(String[] args) {
        Jukebox juke1 = new Jukebox();
        juke1.song(1);
        int lullaby = 2;
        juke1.song(lullaby);
        int million = 1000000;
        juke1.song(million);
        System.out.println(juke1.song(1, "Hello!"));
    }
}
