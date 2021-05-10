package ru.job4j.collection;

import java.util.Arrays;
import java.util.List;

public class Article2 {
    public static boolean generateBy(String origin, String line) {
        String[] lineWords = line.split("\\s*(\\s|,|!|\\.|\\?)\\s*");
        for (String word : lineWords) {
            if (!origin.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
