package ru.job4j.exercise.stream;

import java.util.List;
import java.util.Optional;

public class OptionalFlatMap {
    public static Optional<Integer> flatMap(List<String> strings) {
        return strings.stream()
                .filter(s -> s.endsWith(".java"))
                .findFirst()
                .flatMap(o -> Optional.of(o.length()));

    }
}
