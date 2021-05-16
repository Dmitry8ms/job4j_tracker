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
        List<Job> jobSet = new ArrayList<>();
        jobSet.add(new Job("Java developer", 1));
        jobSet.add(new Job("C# developer", 3));
        jobSet.add(new Job("Kotlin developer", 2));
        Comparator<Job> nameDesc = (n1, n2) -> n2.getName().compareTo(n1.getName());
        Comparator<Job> nameLenDesc = (n1, n2) -> Integer.compare(n2.getName().length(),
                                                n1.getName().length());
        for (Job j : jobSet) {
            System.out.println(j);
        }
        System.out.println();
        jobSet.sort(nameDesc);
        for (Job j : jobSet) {
            System.out.println(j);
        }
        System.out.println();
        jobSet.sort(nameLenDesc);
        for (Job j : jobSet) {
            System.out.println(j);
        }
    }
}
