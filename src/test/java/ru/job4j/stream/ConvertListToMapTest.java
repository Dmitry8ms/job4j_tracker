package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConvertListToMapTest {

    @Test
    public void listToMap() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(10, "Ivanov"));
        studentList.add(new Student(20, "Petrov"));
        studentList.add(new Student(30, "Bashiroff"));
        studentList.add(new Student(10, "Ivanov"));
        Map<String, Student> expected =
                Map.of("Ivanov", new Student(10, "Ivanov"),
                        "Petrov", new Student(20, "Petrov"),
                       "Bashiroff", new Student(30, "Bashiroff"));
        assertThat(new ConvertListToMap().listToMap(studentList), is(expected));
    }
}