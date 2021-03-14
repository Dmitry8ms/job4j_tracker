package ru.job4j.oop;

public class Ball {
    private boolean eaten = false;

    public boolean isEaten() {
        return eaten;
    }

    public void setEaten(boolean eaten) {
        this.eaten = eaten;
    }

    public void leaveGrands() { }

    public void tellstory() {
        System.out.println("I ran away from grandpa and grandma...");
    }

    public void ranaway() {
        System.out.println("Ball is running away...");
    }
}
