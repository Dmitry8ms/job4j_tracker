package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article3 {
    public static boolean generateBy(String origin, String line) {
        Set<String> originSet = new HashSet<>(Arrays.asList(
                origin.split("\\s*(\\s|,|!|\\.|\\?)\\s*")));
        Set<String> lineSet = new HashSet<>(Arrays.asList(
                line.split("\\s*(\\s|,|!|\\.|\\?)\\s*")));
        return originSet.containsAll(lineSet);
    }
}
