package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    private Output out;

    public ConsoleInput(Output out) {
        this.out = out;
    }

    @Override
    public String askStr(String question) {
        out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }
}
