package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner input = new Scanner(System.in);
        String question = input.nextLine();
        System.out.println("Ты спросил \"" + question + "\" мой ответ ...");
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0:
                System.out.println("Да!");
                break;
            case 1:
                System.out.println("Может быть...");
                break;
            default:
                System.out.println("Нет!");
        }
    }
}
