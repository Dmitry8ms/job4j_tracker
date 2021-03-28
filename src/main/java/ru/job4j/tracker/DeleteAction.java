package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Please, enter id of item to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Item with id " + id + " is successfully deleted");
        } else {
            System.out.println("Error - wrong id!");
        }
        return true;
    }
}
