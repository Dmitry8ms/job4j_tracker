package ru.job4j.exercise.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CollectorClass {
    public static List<Integer> collect(List<Integer> list) {
        Supplier<List<Integer>> supplier = ArrayList::new;
        BiConsumer<List<Integer>, Integer> biConsumer = (l, n) -> l.add(n);
        BinaryOperator<List<Integer>> operator = (left, right) -> {
            left.addAll(right);
            return left;
        };
        return list.stream().collect(Collector.of(supplier, biConsumer, operator));
    }
}
