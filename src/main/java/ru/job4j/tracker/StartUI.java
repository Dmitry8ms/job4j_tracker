package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Item with name " + name + " is created");
            } else if (select == 1) {
                System.out.println("Printing out all items...");
                for (Item it : tracker.findAll()) {
                    System.out.println(it);
                }
            } else if (select == 2) {
                int id = input.askInt("Please, enter id of item to edit: ");
                String name = input.askStr("Please, enter new name of item to edit: ");
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Item with id " + id + " is replaced with item: " + newItem);
                } else {
                    System.out.println("Error - wrong id!");
                }
            } else if (select == 3) {
                int id = input.askInt("Please, enter id of item to delete: ");
                if (tracker.delete(id)) {
                    System.out.println("Item with id " + id + " is successfully deleted");
                } else {
                    System.out.println("Error - wrong id!");
                }
            } else if (select == 4) {
                int id = input.askInt("Please, enter id of item to find: ");
                Item foundItem = tracker.findById(id);
                if (foundItem != null) {
                    System.out.println("Found item with id " + id + ": " + foundItem);
                } else {
                    System.out.println("Error - wrong id!");
                }
            } else if (select == 5) {
                String name = input.askStr("Please, enter name of items to find: ");
                Item[] items = tracker.findByName(name);
                if (items.length == 0) {
                    System.out.println("Found nothing");
                } else {
                    for (Item it : items) {
                        System.out.println(it);
                    }
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
