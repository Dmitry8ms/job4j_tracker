package ru.job4j.exercise.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOfAndEmpty {
    public static Optional<String> findValue(List<String> strings, String value) {
        for (String s : strings) {
            if (s.equals(value)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }
}
