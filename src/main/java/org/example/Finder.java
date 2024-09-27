package org.example;

import java.io.File;

public class Finder {
    private String startDirectory;
    public String getStartDirectory() { return startDirectory; }

    private String regex;
    public String getRegex() { return regex; }

    private int findCount = 0; // кол-во найденных файлов
    public int getFindCount() { return findCount; }

    private int totalCount = 0; // общее кол-во файлов
    public int getTotalCount() { return totalCount; }

    Node tree;
    public Node getTree() { return tree; }

    private boolean IsEnd = false;
    public boolean getIsEnd() { return IsEnd; }

    public Finder(String startDirectory, String regex) {
        this.startDirectory = startDirectory;
        this.regex = regex;
    }

    public void start() {
        File startDir = new File(startDirectory);

        if (startDir.exists() && startDir.isDirectory()) {
            tree = new Node(startDir.getAbsolutePath(), startDir.getAbsolutePath(), 1);
            UIThread printer = new UIThread("UIThread", this);
            printer.start();
            find(tree);
            IsEnd = true;

            try {
                printer.join();
            } catch (InterruptedException e) {
                System.out.printf("%s has been interrupted", printer.getName());
            }
            System.out.println("Поиск закончился");
        }
        else
            System.out.println("Данной директории не существует");
    }

    private void print(Node tree) {
        // добавить время
        while (true) {
            // Очистка консоли
            System.out.print("\033[H\033[2J");
            System.out.flush();

            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            System.out.printf("Найдено: %d \t Общее количество файлов: %d", findCount, totalCount);
            tree.display();
        }
    }

    private boolean find(Node tree) {
        File dir = new File(tree.getAbsolutePath());

        boolean FileIsFound = false;

        File[] list = dir.listFiles();
        if (list != null) {
            for (File item : list) {
                if (item.isFile()) {
                    totalCount++;
                    if (item.getName().matches(regex)) {
                        FileIsFound = true;
                        findCount++;
                        Leaf file = new Leaf(item.getName(), item.getAbsolutePath(), tree.getDepth() + 1);
                        tree.add(file);
                    }
                }
                else {
                    Node directory = new Node(item.getName(), item.getAbsolutePath(), tree.getDepth() + 1);
                    if (find(directory)) {
                        FileIsFound = true;
                        tree.add(directory);
                    }
                }
            }
        }

        return FileIsFound;
    }
}
