package ru.job4j.exercise.lambda;

import java.util.Optional;

public class OptionalOrlElse {
    public static Integer orElse(Optional<Integer> optional) {
        // do refactor
        return optional.orElse(-1);
    }
}
