package ru.job4j.exercise.stream;

import java.util.List;

public class MinMethod {
    public static String min(List<String> list) {
        return list.stream()
                .min(String::compareTo).get();
    }
}
