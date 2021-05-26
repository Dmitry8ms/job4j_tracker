package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс содержит основные методы работы с моделями данных Account и User
 * @author DMITRY SHATOKHIN
 * @version 1.0
 */
public class BankService {
    /**
     * Поле users типа HashMap используется для хранения элементов класса
     * User - ключ, и List<Account> - значение. Значения представляют собой
     * списки элементов класса Account, т.е. каждому пользователь (User)
     * соответствует несколько счетов в банке (Account).
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя класса User
     * в коллекцию users (Map).
     * @param user - параметр принимает объект пользователя User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет банковский счет (Account) к списку банковских счетов
     * пользователя (User) по номеру паспорта пользователя.
     * @param passport - поле класса User, содержит номер паспорта клиента
     * @param account - объект класса Account, который надо добавить к списку
     */
    public void addAccount(String passport, Account account) {
        User found = findByPassport(passport);
        if (found != null) {
            List<Account> accounts = users.get(found);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }

    }

    /**
     * Метод находит пользователя (User) в коллекции users (Map)
     * по номеру паспорта.
     * @param passport - поле класса User, содержащее номер паспорта
     * @return - метод возвращает найденный экземпляр User
     */
    public User findByPassport(String passport) {
       /* for (User u : users.keySet()) {
            if (u.getPassport().equals(passport)) {
                return u;
            }
        }*/
        return users.keySet().stream()
                    .filter(e -> e.getPassport().equals(passport))
                    .findFirst()
                    .orElse(null);
    }

    /**
     * Метод возвращает объект Account по номеру счета
     * который является полем класса Account (реквизит счета), и по номеру
     * паспорта
     * @param passport - поле класса User, содержащее номер паспорта
     * @param requisite - номер счета (поле класса User)
     * @return Account - объект класса Account
     *
     */
    public Account findByRequisite(String passport, String requisite) {
        User foundUser = this.findByPassport(passport);
        if (foundUser != null) {
           /* for (Account account : users.get(foundUser)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }*/
            return users.get(foundUser).stream()
                                        .filter(e -> e.getRequisite().equals(requisite))
                                        .findFirst()
                                        .orElse(null);
        }
        return null;
    }

    /**
     * Метод переводит деньги в размере amount с одного счета на другой и
     * возвращет true если транзакция прошла успешно.
     * @param srcPassport - поле класса User, содержащее номер паспорта клиента со счета которого
     *                    переводится amount
     * @param srcRequisite - поле класса Account, содержащее номер счета с которого
     *                       переводятся деньги
     * @param destPassport - поле класса User, содержащее номер паспорта клиента на счет которому
     *                       переводится amount
     * @param destRequisite - поле класса Account, содержащее номер счета на который
     *                        переводятся деньги
     * @param amount  -  размер переводимой суммы
     * @return true - если транзакция прошла успешно
     */
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
        System.out.println("Client - " + bs.findByPassport("1111 111111").getUsername()
        + " amount - " + bs.findByRequisite("1111 111111", "9087654321")
                .getBalance());
        bs.transferMoney("7777 007007", "1234567890", "1111 111111",
                    "9087654321", 50000.00);
        Account account = bs.findByRequisite("1111 111111", "9087654321");
        System.out.println("account after transfer - " + account.getBalance());
    }
}
