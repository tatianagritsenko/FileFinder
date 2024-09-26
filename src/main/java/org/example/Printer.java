package org.example;

import java.io.File;

public class Printer {
    public static void printCurrentDir(String dir) {
        System.out.println("Идёт поиск в директории " + dir);
    }

    public static void printCount(int findCount, int totalCount) {
        System.out.printf("Найдено: %d \t Общее количество файлов: %d", findCount, totalCount);
    }

    public static void DirectoryNotFound() {
        System.out.println("Данной директории не существует");
    }
}
