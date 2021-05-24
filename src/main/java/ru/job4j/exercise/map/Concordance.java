package ru.job4j.exercise.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Метод принимает строку, при этом слова могут содержать как строчные символы, так и прописные.
 При реализации необходимо игнорировать пробелы во входной строке.

Необходимо реализовать метод, который вернет отображение, в котором ключом будет символ из строки,
 а значением - список индексов, под которыми этот символ (если таких символов несколько) входит в
  исходную строку. Важно: строчные и прописные символы считаются разными символами. */

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
