package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private static  SingleTracker singleTracker = null;
    private Store tracker = new MemTracker();

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

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public boolean replace(int id, Item newItem) {
        return tracker.replace(id, newItem);
    }
}
