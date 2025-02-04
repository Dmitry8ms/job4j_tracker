package ru.job4j.exercise.stream;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class FlatItTest {

    @Test
    public void whenIt() {
        Iterator<Iterator<Integer>> it = List.of(
                List.of(1).iterator(),
                List.of(2, 3).iterator()
        ).iterator();
        assertThat(
                FlatIt.flatten(it),
                is(List.of(1, 2, 3))
        );
    }
}