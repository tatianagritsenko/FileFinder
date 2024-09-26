package org.example;

import org.example.composite.Leaf;
import org.example.composite.Node;

import java.io.File;

public class Finder {
    private String startDirectory;
    private String regex;
    private int findCount = 0; // кол-во найденных файлов
    private int totalCount = 0; // общее кол-во файлов

    public Finder(String startDirectory, String regex) {
        this.startDirectory = startDirectory;
        this.regex = regex;
    }

    public void start() {
        File startDir = new File(startDirectory);

        if (startDir.exists() && startDir.isDirectory()) {
            Node tree = new Node(startDir.getName(), startDir.getAbsolutePath(), 1);
            if (find(tree))
                tree.display(); // deepth
            System.out.printf("Найдено: %d \t Общее количество файлов: %d", findCount, totalCount);
        }
        else
            System.out.println("Данной директории не существует");
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
