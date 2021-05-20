package ru.job4j.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, -1, -2, -3, -4, -5, 0));
        System.out.println(intList);
        List<Integer> positiveList = intList.stream()
                                            .filter(number -> number >= 0)
                                            .collect(Collectors.toList());
        System.out.println(positiveList);
    }
}
