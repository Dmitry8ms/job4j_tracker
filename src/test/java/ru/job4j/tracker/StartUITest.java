package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Output out = new StubOutput();
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction create = new CreateAction(out);
        create.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void replaceItem() {
        Output out = new StubOutput();
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction create = new CreateAction(out);
        create.execute(input, tracker);
        answers = new String[]{"1", "Fix notebook"};
        input = new StubInput(answers);
        UserAction replace = new ReplaceAction(out);
        replace.execute(input, tracker);
        Item replaced = tracker.findById(1);
        Item expected = new Item("Fix notebook");
        assertThat(replaced.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
                "replaced item"
        };
        UserAction replace = new ReplaceAction(out);
        replace.execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        int id = item.getId();
        String[] answers = {String.valueOf(id)};
        UserAction delete = new DeleteAction(out);
        delete.execute(new StubInput(answers), tracker);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenInitCreateReplaceDeteleItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "3"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ReplaceAction(out),
                new DeleteAction(out),
                new ExitAction()
        };
        StartUI start = new StartUI(out);
        start.init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
        in = new StubInput(
                new String[] {"1", "1", "Fix PC", "3"}
        );
        start.init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Fix PC"));
        in = new StubInput(
                new String[] {"2", "1", "3"}
        );
        start.init(in, tracker, actions);
        assertThat(tracker.findById(1), is(nullValue()));
    }

    @Test
    public void whenInitAndReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "1", replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenInitAndDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenInitAndShowAllItems() {
        Output stubout = new StubOutput();
        Output console = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Show item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(stubout),
                new ExitAction()
        };
        new StartUI(console).init(in, tracker, actions);
        String expected = stubout.toString().replace("Printing out all items...", "");
        assertThat(expected.trim(), is(tracker.findAll()[0].toString()));
    }

    @Test
    public void whenFindByName() {
        Output stubout = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find item"));
        Input in = new StubInput(
                new String[] {"0", "Find item", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(stubout),
                new ExitAction()
        };
        new StartUI(stubout).init(in, tracker, actions);
        String expected = "Menu.\r\n"
                + "0. Find items by name\r\n"
                + "1. Exit\r\n"
                + tracker.findByName("Find item")[0].toString() + "\r\n"
                + "Menu.\r\n"
                + "0. Find items by name\r\n"
                + "1. Exit\r\n";
        assertThat(stubout.toString(), is(expected));
    }

    @Test
    public void whenFindById() {
        Output stubout = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(stubout),
                new ExitAction()
        };
        new StartUI(stubout).init(in, tracker, actions);
        String expected = "Menu.\r\n"
                + "0. Find item by Id\r\n"
                + "1. Exit\r\n"
                + "Found item with id 1: " + tracker.findById(1).toString() + "\r\n"
                + "Menu.\r\n"
                + "0. Find item by Id\r\n"
                + "1. Exit\r\n";
        assertThat(stubout.toString(), is(expected));
    }

}