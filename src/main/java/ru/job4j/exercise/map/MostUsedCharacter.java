package ru.job4j.exercise.map;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* Метод принимает строку, которая может содержать несколько пробелов, однако в ней отсутствуют
знаки препинания.

Необходимо реализовать метод, который вернет символ в строке, который употребляется наибольшее
количество раз. Если окажется что таких символов несколько - необходимо вернуть первый из
символов. Чтобы обеспечить сортировку символов - собирайте исходную строку в TreeMap(), в которой
 ключ - это символ, значение - количество. Перед тем как собирать строку ее нужно привести к
 нижнему регистру, удалить пробелы.

Для того, чтобы собрать строку в отображение используйте методы computeIfPresent() и putIfAbsent()
 - первый обновит значение частотности употребления символа, второй - вставит пару ключ(символ)
 значение(1) - если такого символа в отображении еще нет. */

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        Map<Character, Integer> count = new TreeMap<>();
        str = str.replaceAll(" ", "");
        str = str.toLowerCase();
        for (char c : str.toCharArray()) {
            count.computeIfPresent(c, (k, v) -> v += 1);
            count.putIfAbsent(c, 1);
        }
        int max = 0;
        Map.Entry<Character, Integer> maxEntry = null;
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }
}
