package ru.job4j.exercise.set;

import java.util.*;

/* Панграмма - короткий текст, который использует все буквы алфавита, по возможности не повторяя
их.
Метод принимает строку(на английском языке). Необходимо реализовать его так, чтобы метод определил
является ли входящая строка панграммой. Строчные и прописные буквы являются одинаковыми символами,
пробелы необходимо игнорировать.

Напомню, что в английском алфавите 26 букв. */

public class Pangram {
    public static boolean checkString(String s) {
        s = s.replaceAll(" ", "").toLowerCase(Locale.ROOT);
        char[] letters = s.toCharArray();
        Set<Character> setLet = new HashSet<>();
        for (char c : letters) {
            setLet.add(c);
        }
        return setLet.size() == 26;
    }
}
