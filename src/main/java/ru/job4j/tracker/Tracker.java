package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        int realIndex = 0;
        Item[] arrayCut = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                arrayCut[realIndex++] = items[i];
            }
        }
        arrayCut = Arrays.copyOf(arrayCut, realIndex);
        return arrayCut;
    }

    public Item[] findByName(String key) {
        int realIndex = 0;
        Item[] arrayCut = findAll();
        for (int i = 0; i < arrayCut.length; i++) {
            if (arrayCut[i].getName() == key) {
                arrayCut[realIndex++] = arrayCut[i];
            }
        }
        arrayCut = Arrays.copyOf(arrayCut, realIndex);
        return arrayCut;
    }

    public void removeById(int id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId() == id) {
                System.out.println("found and removed Id: " + items[i].getId() + " for product "
                                    + items[i].getName());
                items[i] = null;
                break;
            }
        }
    }
}