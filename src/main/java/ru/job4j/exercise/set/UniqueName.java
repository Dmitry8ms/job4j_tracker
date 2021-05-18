package ru.job4j.exercise.set;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* Задание: метод принимает список пользователей, при этом много
 пользователей могут иметь одинаковое имя. Метод должен определить
 количество уникальных имен, которые имеют пользователи. */

public class UniqueName {
    public static int collectUniqueName(List<User> users) {
        Set<String> names = new HashSet<>();
        for (User u : users) {
            names.add(u.getName());
        }
        return names.size();
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
