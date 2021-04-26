package ru.job4j.tracker;

import java.util.Comparator;

public class ItemComparatorDown implements Comparator<Item> {

    @Override
    public int compare(Item itemOne, Item itemTwo) {
        return Integer.compare(itemTwo.getId(), itemOne.getId());
    }
}
