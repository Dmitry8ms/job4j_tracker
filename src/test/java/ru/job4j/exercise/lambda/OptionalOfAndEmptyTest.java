package ru.job4j.exercise.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalOfAndEmptyTest {

    @Test
    public void whenExists() {
        Assert.assertEquals(
                Optional.of("c"),
                OptionalOfAndEmpty.findValue(
                        List.of("a", "b", "c"),
                        "c"
                )
        );
    }

    @Test
    public void whenNotExists() {
        Assert.assertEquals(
                Optional.empty(),
                OptionalOfAndEmpty.findValue(
                        List.of("a", "b", "c"),
                        "d"
                )
        );
    }
}