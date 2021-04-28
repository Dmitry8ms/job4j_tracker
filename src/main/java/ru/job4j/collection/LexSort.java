package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int rsl = 0;
        String number1 = s1.substring(0, s1.indexOf(" "));
        String number2 = s2.substring(0, s2.indexOf(" "));
        String[] numbers1 = number1.split("\\.");
        String[] numbers2 = number2.split("\\.");
        for (int i = 0; i < Math.min(numbers1.length, numbers2.length); i++) {
            rsl = Integer.compare(Integer.parseInt(numbers1[i])
                                , Integer.parseInt(numbers2[i]));
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(numbers1.length, numbers2.length);
        }
        return rsl;
    }
}
