package main.thread_tutorial;

public class SynchronizedExample {
    public static void main(String[] args) {
        Display d = new Display();
//        Display d1 = new Display();
        MyThread6 mt6 = new MyThread6(d, "Aryan");
        MyThread6 mt = new MyThread6(d, "Raj");
        mt6.start();
        mt.start();
    }
}

class Display {
    public void wish(String name){
        System.out.println("Good Morning");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {}
        synchronized(this) {
            System.out.println(name);
        };
    }
}

class MyThread6 extends Thread {
    Display d;
    String name;
    MyThread6(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.wish(name);
    }
}
