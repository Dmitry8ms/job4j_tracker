package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс - модель данных для клиента банка
 */
public class User {
    /**
     * Поле содержит номер паспорта клиента
     */
    private String passport;
    /**
     * Поле содержит строку с именем клиента
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер для для поля passport
     * @return - строка с номером паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер для поля {@param passport}
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер для поля username
     * @return - возвращает строку с именем клиена
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер для поля {@param username}
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод Object.equals для корректного сравнения объектов User
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метод Object.equals
     * @return целочисленное значение хэш-кода
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
