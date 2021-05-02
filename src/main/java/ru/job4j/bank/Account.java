package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс - модель данных для счета в банке, служит для
 * хранения данных в полях requisite и balance и предоставляет
 * методы (сеттеры и геттеры) для работы с этими полями.
 */
public class Account {
    /**
     * Поле для хранения номера счета в банке
     */
    private String requisite;
    /**
     * Поле для хранения баланса на счету в банке
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позвращает строку
     * содержащую номер счета
     * @return String
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метода устанавливает значение номера счета
     * @param requisite - номер счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает  число с плавающей точкой,
     * которое является значением поля balance
     * @return double - баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер поля  баланс
     * @param balance - значение для поля balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод Object.equals для корректного сравнения объектов Account
     * @param o - объект для сравнения
     * @return true если объекты равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод Object.equals
     * @return целочисленное значение хэш-кода
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
