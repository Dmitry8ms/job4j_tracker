package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenMax1To2Then2() {
        int left = 1;
        int right = 2;
        int result = Max.max(left, right);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax1To2To3Then3() {
        assertThat(Max.max(1, 2, 3), is(3));
    }

    @Test
    public void whenMax5To0To2To1Then5() {
        assertThat(Max.max(5, 0, 2, 1), is(5));
    }
}