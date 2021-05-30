package ru.job4j.exercise.stream;

import java.util.List;

public class ReductionWithTwoArguments {
    public static Integer collect(List<Integer> list) {
        return list.stream()
                .reduce(5, (n1, n2) -> n1 *= n2);
    }
}
