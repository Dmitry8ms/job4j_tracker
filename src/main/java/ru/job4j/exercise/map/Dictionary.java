package ru.job4j.exercise.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String string : strings) {
            String s = String.valueOf(string.charAt(0));
            List<String> values = new ArrayList<>();
            rsl.putIfAbsent(s, values);
            List<String> newList = rsl.get(s);
            newList.add(string);
            rsl.computeIfPresent(s, (k, v) -> newList);
        }
        return rsl;
    }
}
