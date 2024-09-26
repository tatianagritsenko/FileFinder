package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        App app = new App();
        app.start();

//        int counter = 0;
//        while (true) {
//            // Очистка консоли
//            System.out.print("\033[H\033[2J");
//            System.out.flush();
//
//
//            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//
//            // Вывод текущего значения счетчика
//            System.out.println("Counter: " + counter);
//            counter++;
//
//            // Задержка на 1 секунду
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}