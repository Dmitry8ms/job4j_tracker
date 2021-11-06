package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Please, enter id of item to edit: ");
        String name = input.askStr("Please, enter new name of item to edit: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            out.println("Item with id " + id + " is replaced with item: " + newItem);
        } else {
            out.println("Error - wrong id!");
        }
        return true;
    }
}
