package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        item2.setName("Item #2");
        item3.setName("Item #3");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String dateTime = item1.getTime().format(formatter);
        //System.out.println(dateTime);
        item1.setName("Item #1");
        Tracker database = new Tracker();
        database.add(item1);
        database.add(item2);
        database.add(item3);
        Item[] items = database.findAll();
        for (Item it : items) {
            System.out.println(it);
        }
        for (Item it : database.findByName("Item #3")) {
            System.out.println("found by name: " + it);
        }
        System.out.println("found by Id: " + database.findById(1).toString());
        System.out.println("record deleted - " + database.delete(2));
        for (Item it : database.findAll()) {
            System.out.println(it);
        }
    }
}
