package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/* Необходимо реализовать метод List<Student> levelOf(List<Student> students, int bound);
Метод должен вернуть список студентов, у которых балл аттестата больше bound.
Во входящем списке могут быть null элементы. */

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> input = new ArrayList<>();
        input.add(new Student("Masha", 28));
        input.add(new Student("Pety", 128));
        input.add((new Student("Ivan", 100)));
        System.out.println(levelOf(input, 50));
    }
}
