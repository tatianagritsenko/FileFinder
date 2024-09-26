package org.example.composite;

public abstract class Component {
    protected String name;
    protected String absolutePath;
    protected int depth; // глубина дерева (уровень)

    public Component(String name, String absolutePath, int depth) {
        this.name = name;
        this.absolutePath = absolutePath;
        this.depth = depth;
    }

    public String getName() { return name; }
    public String getAbsolutePath() { return absolutePath; }
    public int getDepth() { return depth; }

    public abstract void display();
    public abstract void add(Component c);
}
