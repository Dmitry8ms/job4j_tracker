package ru.job4j.exercise.sort;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* Ваша задача получить отсортированную мапу из исходной. Сортировка должна быть
в обратном порядке */

public class SortMap {
    public static Map<Integer, String> sort(Map<Integer, String> map) {
        Map<Integer, String> reversedMap = new TreeMap<>(Comparator.reverseOrder());
        reversedMap.putAll(map);
        return reversedMap;
    }
}
