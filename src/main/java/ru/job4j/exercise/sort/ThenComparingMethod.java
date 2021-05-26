package ru.job4j.exercise.sort;

import java.util.Comparator;
import java.util.Objects;

public class ThenComparingMethod {
    public static class User implements Comparable<User> {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public int compareTo(User u) {
            return this.getName().compareTo(u.getName());

        }
    }

        public static Comparator<User> thenComparing() {
            return ascByName().thenComparing(descByAge());
        }

        public static Comparator<User> ascByName() {
            return Comparator.naturalOrder();
        }

        public static Comparator<User> descByAge() {

            Comparator<User> descAge = new Comparator<User>() {

                @Override
                public int compare(User u1, User u2) {
                    return Integer.compare(u2.getAge(), u1.getAge());
                }
            };
            return descAge;
        }

}

