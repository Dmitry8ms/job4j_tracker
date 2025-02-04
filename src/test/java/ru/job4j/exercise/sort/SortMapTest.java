package ru.job4j.exercise.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortMapTest {

    @Test
    public void test() {
        Map<Integer, String> input = Map.of(
                1, "1",
                2, "2",
                3, "3"
        );
        Map<Integer, String> expect = new TreeMap<>(input);
        Map<Integer, String> result = SortMap.sort(input);
        assertThat(expect, is(result));
    }
}