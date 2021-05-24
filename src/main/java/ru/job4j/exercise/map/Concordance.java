package ru.job4j.exercise.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concordance {
    public static Map<Character, List<Integer>> collectCharacters(String s) {
        Map<Character, List<Integer>> concMap = new HashMap<>();
        s = s.replaceAll(" ", "");
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            List<Integer> values = new ArrayList<>();
            concMap.putIfAbsent(chars[i], values);
            List<Integer> newValues = concMap.get(chars[i]);
            newValues.add(i);
            concMap.computeIfPresent(chars[i], (k, v) -> newValues);
        }
        return concMap;
    }

    public static void main(String[] args) {
        String str = "Hello World hello world";
        Map<Character, List<Integer>> rsl = Concordance.collectCharacters(str);
        for (Map.Entry<Character, List<Integer>> entry : rsl.entrySet()) {
            System.out.println(entry);
        }
    }
}
