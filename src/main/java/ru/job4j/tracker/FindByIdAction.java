package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Please, enter id of item to find: ");
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            System.out.println("Found item with id " + id + ": " + foundItem);
        } else {
            System.out.println("Error - wrong id!");
        }
        return true;
    }
}
