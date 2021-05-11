package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr2 {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> leftMap = new HashMap<Character, Integer>();
        for (char ch : left.toCharArray()) {
            leftMap.put(ch, countOccurrence(ch, left));
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

    private static Integer countOccurrence(char ch, String word) {
        return (word + "\0").split(String.valueOf(ch)).length - 1;
    }
}
