package main;

public class LambdaExample {

    interface Shape {
        void draw();
    }

    class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Rectangle class: draw() method");
        }
    }

    class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Sq uare class: draw() method");
        }
    }

}
