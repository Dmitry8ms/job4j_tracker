package ru.job4j.exercise.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalOfNullableTest {

    @Test
    public void whenNotNull() {
        assertEquals(
                Optional.of("c"),
                OptionalOfNullable.findValue(
                        Arrays.asList("a", "b", "c"),
                        "c"
                )
        );
    }

    @Test
    public void whenNull() {
        assertEquals(
                Optional.empty(),
                OptionalOfNullable.findValue(
                        Arrays.asList("a", "b", "c", null),
                        null
                )
        );
    }

    @Test
    public void whenNulls() {
        assertEquals(
                Optional.empty(),
                OptionalOfNullable.findValue(
                        Arrays.asList("a", null, "c", null),
                        null
                )
        );
    }

    @Test
    public void whenNotFound() {
        assertEquals(
                Optional.empty(),
                OptionalOfNullable.findValue(
                        Arrays.asList("a", "b", "c"),
                        "e"
                )
        );
    }
}