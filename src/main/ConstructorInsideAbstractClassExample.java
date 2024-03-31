package main;

public abstract class ConstructorInsideAbstractClassExample {

    public ConstructorInsideAbstractClassExample() {
        System.out.println("Inside abstract class");
    }
}

class Child1 extends ConstructorInsideAbstractClassExample {

    void childCry() {
        System.out.println("Child is crying");
    }
}

class Main {
    public static void main(String[] args) {
        Child1 c = new Child1();
        c.childCry();
    }
}