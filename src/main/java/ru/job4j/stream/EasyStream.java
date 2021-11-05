package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EasyStream {
    private List<Integer> sourceList;

    private EasyStream(List sourceList) {
        this.sourceList = sourceList;
    }

    public static EasyStream of(List<Integer> source) {
        if (source == null) {
            return new EasyStream(List.of());
        }
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> mappedList = new ArrayList<>();
        for (Integer i : sourceList) {
            mappedList.add(fun.apply(i));
        }
        return new EasyStream(mappedList);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> filteredList = new ArrayList<>();
        for (Integer i : sourceList) {
            if (fun.test(i)) {
                filteredList.add(i);
            }
        }
        return new EasyStream(filteredList);
    }

    public List<Integer> collect() {
        return List.copyOf(sourceList);
    }
}