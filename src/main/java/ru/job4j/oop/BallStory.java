package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare whiteHare = new Hare();
        Wolf greyWolf = new Wolf();
        Fox redFox = new Fox();
        ball.leaveGrands();
        ball.tellstory();
        if (!whiteHare.tryEat(ball)) {
            ball.ranaway();
        } else {
            System.out.println("Ball is eaten, end of story!");
        }
        ball.tellstory();
        if (!greyWolf.tryEat(ball)) {
            ball.ranaway();
        } else {
            System.out.println("Ball is eaten, end of story!");
        }
        ball.tellstory();
        redFox.cheat(ball);
        if (!redFox.tryEat(ball)) {
            ball.ranaway();
        } else {
            System.out.println("Ball is eaten, end of story!");
        }
    }
}
