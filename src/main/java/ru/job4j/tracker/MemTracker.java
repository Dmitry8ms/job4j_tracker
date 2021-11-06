package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    @Override
    public void init() {

    }

    @Override
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    @Override
    public Item findById(int id) {
        int index = indexOf(id);
        return index == -1 ? null : items.get(index);
    }

    @Override
    public List<Item> findAll() {
        return List.copyOf(items);
    }

    @Override
    public List<Item> findByName(String key) {
        ArrayList<Item> arrayPick = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                arrayPick.add(item);
            }
        }
        return arrayPick;
    }

    @Override
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

    @Override
    public boolean replace(int id, Item newItem) {
        int index = indexOf(id);
        boolean hasSuchId = index != -1;
        if (hasSuchId) {
            newItem.setId(id);
            items.set(index, newItem);
        }
        return hasSuchId;
    }

    @Override
    public void close() throws Exception {

    }
}