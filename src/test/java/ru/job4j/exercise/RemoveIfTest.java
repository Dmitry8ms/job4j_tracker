package ru.job4j.exercise;

import org.junit.Test;
import ru.job4j.exercise.list.RemoveIf;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RemoveIfTest {

    @Test
    public void when() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");
        List<String> expected = List.of("three", "seven", "eight");
        List<String> result = RemoveIf.sortList(list);
        assertThat(result, is(expected));
    }
}