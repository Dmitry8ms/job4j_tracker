package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Please, enter id of item to find: ");
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            out.println("Found item with id " + id + ": " + foundItem);
        } else {
            out.println("Error - wrong id!");
        }
        return true;
    }
}
