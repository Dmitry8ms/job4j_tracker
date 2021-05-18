package ru.job4j.lambda;

import java.util.Comparator;

public class LengthCmpClass implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        System.out.println("execute comparator");
        return left.length() - right.length();
    }
}
