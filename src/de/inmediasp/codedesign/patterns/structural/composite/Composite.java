package de.inmediasp.codedesign.patterns.structural.composite;

import java.util.LinkedList;

public class Composite extends Component {

    private LinkedList<Component> children;

    public Composite(){
        this.children = new LinkedList<>();
    }

    public void addComponent(Component component){
        this.children.add(component);
    }

    public void removeComponent(Component component){
        this.children.remove(component);
    }

    @Override
    public void execute() {

    }
}
