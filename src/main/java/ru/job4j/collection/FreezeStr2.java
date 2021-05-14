package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

//Даны две строки. Нужно проверить, что вторая строка получилась методом
// перестановок символов в первой строке.

public class FreezeStr2 {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> leftMap = new HashMap<Character, Integer>();
        for (char ch : left.toCharArray()) {
            leftMap.putIfAbsent(ch, 0);
            leftMap.computeIfPresent(ch, (key, val) -> val + 1);
        }
        for (char ch : right.toCharArray()) {
            if (!leftMap.keySet().contains(ch)) {
                return false;
            } else {
                if (leftMap.get(ch).equals(1)) {
                    leftMap.remove(ch);
                } else {
                    leftMap.put(ch, leftMap.get(ch) - 1);
                }
            }
        }
        return leftMap.isEmpty();
    }
}
