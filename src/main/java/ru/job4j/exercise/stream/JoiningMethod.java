package ru.job4j.exercise.stream;

/* Ваша задача собрать строки списка в текст и добавить префикс "Prefix", и суффикc "Suffix"
(т.е. нужно использовать перегруженный вариант joining()). Разделителем должен быть
System.lineSeparator() */

import java.util.List;
import static java.util.stream.Collectors.*;

public class JoiningMethod {
    public static String join(List<String> strings) {
        return strings.stream().collect(joining(
                System.lineSeparator(), "Prefix", "Suffix"));
    }

    public static void main(String[] args) {
        System.out.println(join(List.of("1", "2", "3")));
    }
}
