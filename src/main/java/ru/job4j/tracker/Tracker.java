package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    //private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index == -1 ? null : items.get(index);
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        int nameIndex = 0;
        ArrayList<Item> arrayPick = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                arrayPick.add(item);
            }
        }
        return arrayPick;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean hasSuchId = index != -1;
        if (hasSuchId) {
            items.remove(index);
        }
        return hasSuchId;
    }

    private int indexOf(int id) {
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                return i;
            }
        }
        return index;
    }

    public boolean replace(int id, Item newItem) {
        int index = indexOf(id);
        boolean hasSuchId = index != -1;
        if (hasSuchId) {
            items.set(index, newItem);
            items.get(index).setId(id);
        }
        return hasSuchId;
    }
}