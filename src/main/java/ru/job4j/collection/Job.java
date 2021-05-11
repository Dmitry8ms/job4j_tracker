package ru.job4j.collection;

import java.util.*;

public class Job implements Comparable<Job> {
    private String name;

    private int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Job{" + name + ", " + priority + '}';
    }

    @Override
    public int compareTo(Job another) {
        return Integer.compare(priority, another.priority);
    }

    public static void main(String[] args) {
        Set<Job> jobSet = new HashSet<>();
        jobSet.add(new Job("Java developer", 1));
        jobSet.add(new Job("C# developer", 3));
        jobSet.add(new Job("Kotlin developer", 2));
        int size = jobSet.size();
        for (Job j : jobSet) {
            System.out.println(j);
        }

    }
}
