package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Please, enter name of items to find: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() == 0) {
            out.println("Found nothing");
        } else {
            for (Item it : items) {
                out.println(it);
            }
        }
        return true;
    }
}
