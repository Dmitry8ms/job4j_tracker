package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Please, enter id of item to delete: ");
        if (tracker.delete(id)) {
            out.println("Item with id " + id + " is successfully deleted");
        } else {
            out.println("Error - wrong id!");
        }
        return true;
    }
}
