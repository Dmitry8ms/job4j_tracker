package ru.job4j.tracker;

import java.util.Comparator;

public class ItemComparatorDown implements Comparator<Item> {

    @Override
    public int compare(Item itemOne, Item itemTwo) {
        return itemTwo.getId() - itemOne.getId();
    }
}
