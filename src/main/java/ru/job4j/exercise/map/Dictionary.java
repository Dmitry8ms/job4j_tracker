package ru.job4j.exercise.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* В данном задании необходимо реализовать словарь. Метод принимает массив строк. Необходимо
 перебрать массив и добавить строки в карту таким образом, чтобы ключом был первый символ строки,
 а значением - список строк, которые начинаются на первый символ строки.  */

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
