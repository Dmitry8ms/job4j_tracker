package ru.job4j.tracker;

import java.util.Scanner;

public class ValidateInput extends ConsoleInput {
    //private Output out = getOut();

    public ValidateInput(Output out) {
        super(out);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid data.");
            }
        } while (invalid);
        return value;
    }

}
