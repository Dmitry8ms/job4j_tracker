package ru.job4j.exercise.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        List<Integer> list = new ArrayList<>();

        return Stream.of(it).flatMap(el -> {
            while (el.hasNext()) {
                Iterator<Integer> iter = el.next();
                while (iter.hasNext()) {
                    list.add(iter.next());
                }
            }
            return list.stream();
        }).collect(Collectors.toList());
    }
}
