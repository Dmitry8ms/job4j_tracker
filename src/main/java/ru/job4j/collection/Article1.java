package ru.job4j.collection;

import java.util.Arrays;
import java.util.List;

public class Article1 {
    public static boolean generateBy(String origin, String line) {
        List<String> originWords = Arrays.asList(
                origin.split("\\s*(\\s|,|!|\\.|\\?)\\s*"));
        String[] lineWords = line.split("\\s*(\\s|,|!|\\.|\\?)\\s*");
        for (String word : lineWords) {
           if (!originWords.contains(word)) {
               return false;
           }
        }
        return true;
    }
}
