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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int nameIndex = 0;
        Item[] arrayPick = findAll();
        for (int i = 0; i < arrayPick.length; i++) {
            if (arrayPick[i].getName() == key) {
                arrayPick[nameIndex++] = arrayPick[i];
            }
        }
        arrayPick = Arrays.copyOf(arrayPick, nameIndex);
        return arrayPick;
    }

    public void removeById(int id) {
        for (int i = 0; i < size; i++) {
            if (items[i] != null && items[i].getId() == id) {
                System.out.println("found and removed Id: " + items[i].getId() + " for product "
                                    + items[i].getName());
                items[i] = null;
                break;
            }
        }
    }
}