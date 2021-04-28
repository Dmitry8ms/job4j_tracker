package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(
                new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAsc() {
        int rsl = new JobAscByName().compare(new Job("Impl task", 0),
                new Job("Fix bug", 1));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByPriorityAsc() {
        int rsl = new JobAscByPriority().compare(new Job("Impl task", 0),
                new Job("Fix bug", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPriorityAsc() {
        Comparator<Job> ascnamepriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = ascnamepriority.compare(new Job("Fix Bug", 0),
                new Job("Fix bug", 1));
        assertThat(rsl, lessThan(0));
    }

}