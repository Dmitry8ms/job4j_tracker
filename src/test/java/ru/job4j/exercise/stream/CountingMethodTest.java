package ru.job4j.exercise.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CountingMethodTest {

    @Test
    public void test() {
        CountingMethod.Company c1 = new CountingMethod.Company("Apple");
        CountingMethod.Company c2 = new CountingMethod.Company("Amazon");
        CountingMethod.Company c3 = new CountingMethod.Company("Microsoft");
        CountingMethod.Worker w1 = new CountingMethod.Worker(20, c1);
        CountingMethod.Worker w2 = new CountingMethod.Worker(25, c2);
        CountingMethod.Worker w3 = new CountingMethod.Worker(30, c2);
        CountingMethod.Worker w4 = new CountingMethod.Worker(35, c3);
        CountingMethod.Worker w5 = new CountingMethod.Worker(40, c3);
        CountingMethod.Worker w6 = new CountingMethod.Worker(45, c3);

        Map<String, Long> expect = Map.of(
                "Apple", 1L,
                "Amazon", 2L,
                "Microsoft", 3L
        );
        assertEquals(expect, CountingMethod.groupAndCount(List.of(w1, w2, w3, w4, w5, w6)));
    }
}