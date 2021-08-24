package ru.dolgov;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        int pc, life;
        life=3;
        pc=randomGame(0, 9);
        startGame(pc,life);
    }

    public static void startGame(int pc, int life) {
        int min, max, user;
        min = 0;
        max = 9;
        life--;
            if (life < 0) {
                gameOver();
            } else {
                Scanner scanner = new Scanner(System.in);
                user = readNumber(scanner, "число ", min, max);
                game(user, pc, life);

            }

    }

    public static int randomGame(int min, int max) {
        int s;
        s = new Random().nextInt(max - min) + min;
        return s;
    }

    public static int readNumber(Scanner scanner, String messag, int min, int max) {
        while (true) {
            System.out.println("Загадайте " + messag + "от " + min + " до " + max);
            int user = scanner.nextInt();
            if (user >= min && user <= max) {
                return user;
            }
        }
    }

    public static void game(int user, int pc, int life) {
        if (user == pc) {
            winGame();
        }
        if (user > pc) {
            System.out.println("Число меньше вашего!");
            startGame(pc,life);

        }
        if (user < pc) {
            System.out.println("Число больше вашего");
            startGame(pc,life);

        }
    }

    public static void winGame() {
        System.out.println("Win!!! Continuum? 1 yea 2 no");
        continuumGame();
    }

    public static void gameOver() {
        System.out.println("Game Over!!! Continuum? 1 yea 2 no");
        continuumGame();
    }

    public static void continuumGame(){
        int con;
        Scanner scanner = new Scanner(System.in);
        con=scanner.nextInt();
        if (con==1){
            start();
        }else {
            System.out.println("До встречи");
        }
    }
}
