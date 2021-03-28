package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Please, enter name of items to find: ");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("Found nothing");
        } else {
            for (Item it : items) {
                System.out.println(it);
            }
        }
        return true;
    }
}
