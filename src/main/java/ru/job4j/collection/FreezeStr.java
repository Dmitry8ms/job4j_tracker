package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        List<Character> leftChars = new ArrayList<>();
        for (char c : left.toCharArray()) {
            leftChars.add(c);
        }
        for (char ch : right.toCharArray()) {
            if (!leftChars.remove((Character) ch)) {
                return false;
            }
        }
        return true;
    }
}
