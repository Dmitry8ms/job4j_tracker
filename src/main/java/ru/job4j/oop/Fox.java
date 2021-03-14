package ru.job4j.oop;

public class Fox {

    public boolean tryEat(Ball ball) {
        return ball.eaten;
    }

    public void cheat(Ball ball) {
        ball.eaten = true;
    }
}
