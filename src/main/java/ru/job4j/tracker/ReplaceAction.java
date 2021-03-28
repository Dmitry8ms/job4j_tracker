package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Please, enter id of item to edit: ");
        String name = input.askStr("Please, enter new name of item to edit: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Item with id " + id + " is replaced with item: " + newItem);
        } else {
            System.out.println("Error - wrong id!");
        }
        return true;
    }
}
