package org.example;

import java.util.Scanner;

public class App {
    private Scanner in = new Scanner(System.in);

    public void start() {
//        System.out.println("Стартовая директория: ");
//        String startDir = in.nextLine(); // добавить проверку
//
//        System.out.println("Шаблон поиска: ");
//        String regex = in.nextLine(); // добавить проверку

        String startDir = "C:\\Users\\Татьяна Гриценко\\Documents\\4 курс";
        String regex = "Резюме(.*)[.](.*)";
        Finder finder = new Finder(startDir, regex);
        finder.start();
    }
}
