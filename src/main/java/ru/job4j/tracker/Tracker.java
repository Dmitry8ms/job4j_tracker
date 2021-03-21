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
        int index = indexOf(id);
        return index == -1 ? null : items[index];
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int nameIndex = 0;
        Item[] arrayPick = new Item[items.length];
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                arrayPick[nameIndex++] = items[i];
            }
        }
        arrayPick = Arrays.copyOf(arrayPick, nameIndex);
        return arrayPick;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;
        }
        return index != 0 ? true : false;
    }

    private int indexOf(int id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                return i;
            }
        }
        return index;
    }

    public boolean replace(int id, Item newItem) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = newItem;
            items[index].setId(id);
        }
        return index != -1;
    }
}