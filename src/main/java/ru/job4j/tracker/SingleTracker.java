package ru.job4j.tracker;

import java.util.ArrayList;

public final class SingleTracker {
    private static  SingleTracker singleTracker = null;
    private Tracker tracker = new Tracker();

    private SingleTracker() { }

    public SingleTracker getSTinstance() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public ArrayList<Item> findAll() {
        return tracker.findAll();
    }

    public ArrayList<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public boolean replace(int id, Item newItem) {
        return tracker.replace(id, newItem);
    }
}
