package org.example;

import java.io.IOException;

public class UIThread extends Thread {
    Finder finder;
    public UIThread(String name, Finder finder) {
        super(name);
        this.finder = finder;
    }

    public void run() {

        long startTime = System.currentTimeMillis();

        boolean lastPrint = false; // после того, как поиск закончился, нужно в последний раз вывести дерево и выйти из цикла
        while (!finder.getIsEnd() || !lastPrint) {
            if (finder.getIsEnd())
                lastPrint = true;

            // Очистка консоли
            //System.out.print("\033[H\033[2J");
            //System.out.flush();

            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Стартовая директория: " + finder.getStartDirectory());
            System.out.println("Шаблон поиска: " + finder.getRegex());
            System.out.println();
            System.out.println("Прошло времени: " +  (System.currentTimeMillis() - startTime)/1000 + " сек");
            System.out.printf("Найдено: %d \t Общее количество файлов: %d\n", finder.getFindCount(), finder.getTotalCount());
            System.out.println();
            finder.getTree().display();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.printf("%s has been interrupted\n", getName());
                System.out.println(e.getMessage());
            }
        }
    }
}
