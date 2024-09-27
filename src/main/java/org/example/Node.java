package org.example;

import java.util.ArrayList;

public class Node extends Component {
    ArrayList<Component> children = new ArrayList<Component>();

    public Node(String name, String absolutePath, int depth) {
        super(name, absolutePath, depth);
    }

    @Override
    public void display() {
        System.out.println("|- " + name);

        for (Component child : children) {
            for (int i = 0; i < depth; i++)
                System.out.print("\t\t");

            child.display();
        }
    }

    @Override
    public void add(Component c) {
        children.add(c);
    }
}
