package org.example.composite;

public class Leaf extends Component {
    public Leaf(String name, String absolutePath, int depth) {
        super(name, absolutePath, depth);
    }

    @Override
    public void display() {
        System.out.println("- " + name);
    }

    @Override
    public void add(Component c) {
        throw new UnsupportedOperationException();
    }
}
