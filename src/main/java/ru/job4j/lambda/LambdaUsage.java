package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s1 = "best Java course";
        String s2 = "is Job4J";
        list.add(s1);
        list.add(s2);
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("This is Comparator for descending order of strings");
            return right.compareTo(left);
        };
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("This is Comparator for descending order of string sizes");
            return Integer.compare(right.length(), left.length());
        };
        list.sort(cmpText);
        for (String s : list) {
            System.out.println(s);
        }
        list.sort(cmpDescSize);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
