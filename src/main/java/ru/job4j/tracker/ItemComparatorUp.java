package ru.job4j.tracker;

import java.util.Comparator;

public class ItemComparatorUp implements Comparator<Item> {

    @Override
    public int compare(Item itemOne, Item itemTwo) {
        return Integer.compare(itemOne.getId(), itemTwo.getId());
    }
}
