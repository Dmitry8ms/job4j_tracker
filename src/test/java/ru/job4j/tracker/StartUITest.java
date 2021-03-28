package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction create = new CreateAction();
        create.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void replaceItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction create = new CreateAction();
        create.execute(input, tracker);
        answers = new String[]{"1", "Fix notebook"};
        input = new StubInput(answers);
        UserAction replace = new ReplaceAction();
        replace.execute(input, tracker);
        Item replaced = tracker.findById(1);
        Item expected = new Item("Fix notebook");
        assertThat(replaced.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
                "replaced item"
        };
        UserAction replace = new ReplaceAction();
        replace.execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        int id = item.getId();
        String[] answers = {String.valueOf(id)};
        UserAction delete = new DeleteAction();
        delete.execute(new StubInput(answers), tracker);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenInitCreateReplaceDeteleItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "3"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new ExitAction()
        };
        StartUI start = new StartUI();
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

}