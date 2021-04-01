package ru.job4j.ex;

public class UserNotValidException extends UserNotFoundException {
    public UserNotValidException(String message) {
        super(message);
    }
}
