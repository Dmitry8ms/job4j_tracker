package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article3 {
    public static boolean generateBy(String origin, String line) {
        origin = origin.replaceAll("\\p{P}", "");
        line = line.replaceAll("\\p{P}", "");
        Set<String> originSet = new HashSet<>(Arrays.asList(
                origin.split(" ")));
        return originSet.containsAll(Arrays.asList(line.split(" ")));
    }
}
