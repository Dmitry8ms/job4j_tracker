package ru.job4j.exercise.stream;

/* Для того, чтобы получить стрим из уникальных элементов мы можем использовать метод distinct().
Если мы используем стрим примитивов, то сравнение элементов идет через ==, если стрим объектов,
то через метод equals.
Например,
Arrays.stream(new int[] {1, 2, 1}).distinct() // в стриме останутся только 1, 2
Ваша задача собрать уникальные числа массива в список */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctForPrimitive {
    public static List<Integer> collect(int[] data) {
        return Arrays.stream(data)
                .distinct()
                .mapToObj(i -> (Integer) i)
                .collect(Collectors.toList());
    }
}
