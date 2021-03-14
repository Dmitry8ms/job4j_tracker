package ru.job4j.oop;

public class Fox {

    public boolean tryEat(Ball ball) {
        return ball.isEaten();
    }

    public void cheat(Ball ball) {
        ball.setEaten(true);
    }
}
