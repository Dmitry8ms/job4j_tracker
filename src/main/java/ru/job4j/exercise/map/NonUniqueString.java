package ru.job4j.exercise.map;

import java.util.HashMap;
import java.util.Map;

public class NonUniqueString {
    public static Map<String, Boolean> checkData(String[] strings) {
        Map<String, Boolean> trueStrings = new HashMap<>();
        for (String s : strings) {
            trueStrings.computeIfPresent(s, (k, v) -> v = true);
            trueStrings.putIfAbsent(s, false);
        }
        return trueStrings;
    }
}
