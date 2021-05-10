package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FreezeStr2Test {

    @Test
    public void whenEq() {
        assertThat(FreezeStr2.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr2.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr2.eq("heloo", "hello"), is(false));
    }
}
