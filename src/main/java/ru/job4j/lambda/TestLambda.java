package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class TestLambda {

    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(func.apply((double) i));
        }
        return list;
    }

    public static void main(String[] args) {

        String[] names = {"Ivan", "Petr"};
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };

        Comparator<String> lengthCmpClass = new LengthCmpClass();
        Arrays.sort(names, lengthCmp);
        Arrays.sort(names, lengthCmpClass);
        System.out.println(diapason(5, 8, x -> x * x + 1));
        System.out.println(diapason(5, 8, x -> Math.pow(2, x) + 1));
    }
}
