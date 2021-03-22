package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + ", введите число от 1 до 3:");
            boolean incorrectTurn;
            do {
                int matches = Integer.parseInt(input.nextLine());
                if (matches >= 1 && matches <= 3 && matches <= count) {
                    incorrectTurn = false;
                    turn = !turn;
                    count -= matches;
                    System.out.println("осталось " + count + " спичек на столе");
                } else {
                    System.out.println("Неправильное количество спичек! " + System.lineSeparator()
                            + player + ", возьмите от 1 до 3, но не больше чем есть на столе");
                    incorrectTurn = true;
                }
            } while (incorrectTurn);
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
