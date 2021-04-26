package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void sortUp() {
        Item item1 = new Item("Fix PC");
        item1.setId(1);
        Item item2 = new Item("Fix notebook");
        item2.setId(2);
        Item item3 = new Item("Fix motherboard");
        item3.setId(3);
        List<Item> items = Arrays.asList(item2, item1, item3);
        Collections.sort(items, new ItemComparatorUp());
        List<Item> expected = Arrays.asList(item1, item2, item3);
        assertThat(items, is(expected));
    }

    @Test
    public void sortDown() {
        Item item1 = new Item("Fix PC");
        item1.setId(1);
        Item item2 = new Item("Fix notebook");
        item2.setId(2);
        Item item3 = new Item("Fix motherboard");
        item3.setId(3);
        List<Item> items = Arrays.asList(item2, item1, item3);
        Collections.sort(items, new ItemComparatorDown());
        List<Item> expected = Arrays.asList(item3, item2, item1);
        assertThat(items, is(expected));
    }

}