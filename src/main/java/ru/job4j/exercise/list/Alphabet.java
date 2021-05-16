package ru.job4j.exercise.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Вам необходимо реализовать метод, который принимает строку, которое является одним словом,
 без знаков препинания цифр и пробелов. Метод должен вернуть новую строку, в которой все символы
  исходной строки будут расставлены в алфавитном порядке.

Для разделения строки на подстроки используйте метод toCharArray(), добавьте все элементы в
 коллекцию List<String>, отсортируйте в порядке возрастания - используйте метод sort, в
 который передадите  компаратор. Новую строку сформируйте с помощью StringBuilder.*/

public class Alphabet {
    public static String reformat(String s) {
        List<Character> listOfChars = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            listOfChars.add(ch);
        }
        listOfChars.sort(Comparator.naturalOrder());
        StringBuilder string = new StringBuilder();
        for (char ch : listOfChars) {
            string.append(ch);
        }
        return string.toString();
    }
}
