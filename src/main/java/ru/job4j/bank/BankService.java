package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User found = findByPassport(passport);
        if (found != null) {
            List<Account> accounts = users.get(found);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }

    }

    public User findByPassport(String passport) {
        for (User u : users.keySet()) {
            if (u.getPassport().equals(passport)) {
                return u;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User foundUser = this.findByPassport(passport);
        if (foundUser != null) {
            for (Account account : users.get(foundUser)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            double srcBalance = srcAccount.getBalance();
            if (srcBalance - amount >= 0) {
                double destBalance = destAccount.getBalance();
                srcAccount.setBalance(srcBalance - amount);
                destAccount.setBalance(destBalance + amount);
                rsl = true;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account(requisite, 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
        BankService bs = new BankService();
        bs.addUser(new User("7777 007007", "Petr Arsentev"));
        bs.addAccount("7777 007007", new Account("1234567890", 100000.00));
        bs.addUser(new User("1111 111111", "Stas Korobeynikov"));
        bs.addAccount("1111 111111", new Account("9087654321", 10000.00));
        bs.transferMoney("7777 007007", "1234567890", "1111 111111",
                    "9087654321", 50000.00);
        Account account = bs.findByRequisite("1111 111111", "9087654321");
        System.out.println(account.getBalance());
    }
}
