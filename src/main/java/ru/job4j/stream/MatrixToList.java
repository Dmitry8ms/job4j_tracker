package ru.job4j.stream;

/* Задание.
1. Создайте матрицу Integer[][].
2. Напишите преобразование этой матрицы в список чисел.
3. При решении этой задачи нужно использовать методы flatMap(), collect(), Stream.of().
4. Реализуйте описанную выше логику в методе, который на вход принимает двумерный массив
Integer[][]. На реализованный метод напишите тесты. */

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {

    public List<Integer> arrayToList(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new MatrixToList().arrayToList(matrix));
    }
}
