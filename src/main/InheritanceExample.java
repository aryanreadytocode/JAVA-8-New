package main;

public class InheritanceExample {
    public static void main(String[] args) {
        Child p = new Child();

        System.out.println(p.salary);

        Parent p1 = new Child();
//        System.out.println(p1.bonus); bonus can't be accessible
        Child c = new Child();
        System.out.println(c.salary);
        System.out.println(c.bonus);
        //
//        Parent parent = new Parent();
//        parent.showBonus();

        Parent parent1 = new Child();
        parent1.showBonus();

//        Child c1 = new Child();
//        c.showBonus();


    }
}

class Parent {
    int salary = 100000;
    public void showBonus() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    int bonus = 5000;
    int salary = 0;

    public void showBonus() {
        System.out.println("Child");
    }
}
