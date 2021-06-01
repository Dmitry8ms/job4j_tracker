package ru.job4j.exercise.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Вам дан список пользователей, у каждого пользователя есть счет. Ваша задача найти сумму баланса
 для каждого пользователя.
Подсказка: нужно использовать вспомогательный класс для группировки Pair */

public class SummingMethod {
    public static class User {

        private String name;

        private List<Bill> bills = new ArrayList<>();

        public User(String name, List<Bill> bills) {
            this.name = name;
            this.bills = bills;
        }

        public String getName() {
            return name;
        }

        public List<Bill> getBills() {
            return bills;
        }
    }

    public static class Bill {

        private int balance;

        public Bill(int balance) {
            this.balance = balance;
        }

        public int getBalance() {
            return balance;
        }
    }

    private static class Pair {
        private User user;
        private Bill bill;

        public Pair(User user, Bill bill) {
            this.user = user;
            this.bill = bill;
        }

        public User getUser() {
            return user;
        }

        public Bill getBill() {
            return bill;
        }
    }

    public static Map<String, Integer> summing(List<User> users) {

        return users.stream().flatMap(u -> {
            Stream.Builder<Pair> pairs = Stream.builder();
            for (Bill b : u.getBills()) {
                pairs.add(new Pair(u, b));
            }
            return pairs.build();
        }).collect(Collectors.groupingBy(p -> p.getUser().getName(),
                Collectors.summingInt(p -> p.getBill().getBalance())));
    }
}
