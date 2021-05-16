package ru.job4j.exercise.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Alphabet {
    public static String reformat(String s) {
        List<Character> listOfChars = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            listOfChars.add(ch);
        }
        listOfChars.sort(Comparator.naturalOrder());
        StringBuilder string = new StringBuilder();
        for (char ch : listOfChars) {
            string.append(ch);
        }
        return string.toString();
    }
}
